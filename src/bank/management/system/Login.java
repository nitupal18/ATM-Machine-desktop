
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    CommonUtility utility=new CommonUtility();
    
    JLabel welcome=new JLabel("Welcome to ATM");
    JLabel enter_card_no=new JLabel("Enter Card No :");
    JLabel enter_the_pin=new JLabel("Enter the Pin :");
    
    JButton login=new JButton("Login");
    JButton clear=new JButton("clear");
    JButton signup=new JButton("Sign Up");
    JTextField textField_ForCardNumber = new JTextField();
    JPasswordField passwordField_ForPin = new JPasswordField();
    
   
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("Automated Teller Machine");
        setSize(800,480);
        setLayout(null);
        // for icon
        ImageIcon logo_of_atm_for_login_page = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image resized_logo_of_atm_for_login_page = logo_of_atm_for_login_page.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon final_image=new ImageIcon(resized_logo_of_atm_for_login_page);
        JLabel got_logo_of_atm_for_login_page = new JLabel(final_image);
        add(got_logo_of_atm_for_login_page);
        got_logo_of_atm_for_login_page.setBounds(70, 10, 100, 100);
        
        // for heading
        utility.for_texts(welcome,38,200,10,400,100);
        add(welcome);
        // for account number
        utility.for_texts(enter_card_no,30,100,150,300,50);
        add(enter_card_no);
        utility.for_text_field(textField_ForCardNumber,350,170,300,30);
        add(textField_ForCardNumber);
        // for pin
        utility.for_texts(enter_the_pin,30,100,190,300,50);
        add(enter_the_pin);
        utility.for_password_field(passwordField_ForPin,350,210,300,30);
        add(passwordField_ForPin);
        
        // buttons
        //login button
        utility.buttons(login,350,250,140,30,Color.WHITE,Color.BLACK);
        add(login);
        login.addActionListener(this);
        // clear button
        utility.buttons(clear,510,250,140,30,Color.WHITE,Color.BLACK);
        add(clear);
        clear.addActionListener(this);
        // signup button
        utility.buttons(signup,350,290,300,30,Color.WHITE,Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
        setVisible(true);
        setLocation(250,100);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            textField_ForCardNumber.setText("");
            passwordField_ForPin.setText("");
        }
        else if(ae.getSource() == login){
            String cardnumber=textField_ForCardNumber.getText();
            String pinnumber=passwordField_ForPin.getText();
            Conn c=new Conn();
            String query="select* from login where Card_number='"+cardnumber+"' and PIN='"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Crad Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
