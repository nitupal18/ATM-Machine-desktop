/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author nitu
 */
public class EnterPin extends JFrame implements ActionListener {

    CommonUtility utility = new CommonUtility();

    JLabel text = new JLabel("Enter PIN");
    JPasswordField pin = new JPasswordField();
    JButton enter = new JButton("Enter");
    JButton back = new JButton("Back");

    String pin_number;
    String amount_t;
    String type_of_transaction;
    String message_t;

    EnterPin(String pinnumber, String amount, String typeOfTransaction, String message) {
        setLayout(null);

        this.pin_number = pinnumber;
        this.amount_t = amount;
        this.type_of_transaction = typeOfTransaction;
        this.message_t = message;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        utility.form_details_locator(text, 18, 170, 210, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        utility.for_text_field(pin, 180, 260, 300, 35);
        image.add(pin);

        utility.buttons(enter, 270, 320, 100, 35, Color.WHITE, Color.darkGray);
        image.add(enter);
        enter.addActionListener(this);

        utility.buttons(back, 270, 365, 100, 35, Color.WHITE, Color.darkGray);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 650);
        setLocation(200, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        int balance = 0;
        String card_number="";
        Date date = new Date();
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        } else if (ae.getSource() == enter) {
            String pin_no = pin.getText();
            Conn c = new Conn();
            String query1 = "select* from login where PIN='" + pin_no + "'";
            try {
                //calculating balance
                ResultSet rs1 = c.s.executeQuery(query1);
                if (rs1.next()) {
                    try {
                        String temp=rs1.getString("Card_number");
                        card_number+=temp;
                        ResultSet rs2 = c.s.executeQuery("select * from bank ");
                        while (rs2.next()) {
                            if (rs2.getString("tot").equals("Deposit")) {
                                balance += Integer.parseInt(rs2.getString("amount"));
                            } else if (rs2.getString("tot").equals("Withdrawl")) {
                                balance -= Integer.parseInt(rs2.getString("amount"));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (type_of_transaction == "Withdrawl") {
                        if (balance < Integer.parseInt(amount_t)) {
                            JOptionPane.showMessageDialog(null, "Insuffient Balance");
                            return;
                        }
                    }
                    if (type_of_transaction == "Checked Balance") {
                        message_t += "" + balance;
                        JOptionPane.showMessageDialog(null, message_t);
                        return;
                    }
                    if (type_of_transaction == "Pin Change") {
                        String q1 = "UPDATE bank SET PIN ='"+amount_t+"'  WHERE PIN = '"+pin_no+"'";
                        String q2="update login set PIN='"+amount_t+"' where PIN='"+pin_no+"'";
                        String q3="update signup3 set PIN='"+amount_t+"' where PIN='"+pin_no+"'";
                        try{
                           c.s.executeUpdate(q1);
                           c.s.executeUpdate(q2);
                           c.s.executeUpdate(q3);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        JOptionPane.showMessageDialog(null, message_t);
                        return;
                    }
                    if(type_of_transaction=="Mini Statement"){
                        String balance_for_ms=""+balance;
                        new MiniStatement(card_number,balance_for_ms).setVisible(true);
                        return;
                    }
                    String query2 = "insert into bank values('" + pin_no + "','"+date+"','" + type_of_transaction + "','" + amount_t + "')";
                    try {
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, message_t);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String args[]) {
        new EnterPin("", "", "", "");
    }
}
