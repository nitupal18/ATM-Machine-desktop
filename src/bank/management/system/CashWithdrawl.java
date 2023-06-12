/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

/**
 *
 * @author nitu
 */
public class CashWithdrawl extends JFrame implements ActionListener {

    CommonUtility utility = new CommonUtility();

    String pin_number;

    JLabel text = new JLabel("Enter the amount you want to withdraw");
    JTextField ammount = new JTextField();
    JButton withdraw = new JButton("Withdraw");
    JButton back = new JButton("Back");

    CashWithdrawl(String pinnumber) {
        setLayout(null);

        this.pin_number = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        utility.form_details_locator(text, 18, 170, 210, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        utility.for_text_field(ammount, 180, 260, 300, 35);
        image.add(ammount);

        utility.buttons(withdraw, 270, 320, 100, 35, Color.WHITE, Color.darkGray);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        utility.buttons(back, 270, 365, 100, 35, Color.WHITE, Color.darkGray);
        image.add(back);
        back.addActionListener(this);
        

        setSize(900, 650);
        setLocation(200, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String withdrawn_amount = ammount.getText();
            String message = "Successfully Withdrawn";
            String type = "Withdrawl";
            try {
                if (withdrawn_amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Amount");
                } else {
                    setVisible(false);
                    new EnterPin(pin_number, withdrawn_amount, type, message).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new CashWithdrawl("");
    }
}
