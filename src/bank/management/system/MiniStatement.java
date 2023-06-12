/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 *
 * @author nitu
 */
public class MiniStatement extends JFrame implements ActionListener {
    
    CommonUtility utility = new CommonUtility();
    String cn,b;
    JButton back = new JButton("Back");
    
    MiniStatement(String card_number,String balance){
        
        this.cn=card_number;
        this.b=balance;
        
        setLayout(null);
        setSize(500,600);
        setLocation(400,60);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title=new JLabel("Mini Bank Statement");
        utility.form_details_locator(title, 20, 80, 30, 300, 30);
        add(title);
        
        
        JLabel cardno=new JLabel();
        cardno.setText("Your Card Number is:  "+cn.substring(0,4)+"XXXXXXXX"+cn.substring(7, 11));
        cardno.setBounds(70,150,400,30);
        cardno.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(cardno);
        
        JLabel pin=new JLabel();
        pin.setText("Your PIN :  XXXX");
        pin.setBounds(70,200,400,30);
        pin.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(pin);
        
        JLabel amount=new JLabel();
        amount.setText("Balance left is :  "+b);
        amount.setBounds(70,260,400,30);
        amount.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(amount);
        
      
        utility.buttons(back, 90, 420, 100, 30, Color.WHITE, Color.BLACK);
        add(back);
        back.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions("").setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("","");
    }
}
