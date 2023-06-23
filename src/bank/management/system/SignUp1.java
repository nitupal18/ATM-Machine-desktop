
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

/**
 *
 * @author nitu
 */
public class SignUp1 extends JFrame implements ActionListener {
    
    CommonUtility utility=new CommonUtility();
    
    
    //maths
        /**
         * creates random number
         */
        Random rand=new Random();
        /**
         * its a random
         */
        long random_number=Math.abs((rand.nextLong()%9000L) +1000L );
    
    //variables defination
        JLabel heading=new JLabel("APPLICATION FORM NO. "+random_number);
        JLabel page_1 = new JLabel("Page 1: Personal Details");
        
        JLabel name = new JLabel("Name: ");
        JTextField name_field= new JTextField();
        
        JLabel father_name = new JLabel("Father's Name: ");
        JTextField father_name_field= new JTextField();
        
        JLabel date_of_birth = new JLabel("Date of Birth: ");
        JDateChooser calendar=new JDateChooser();
        
        JLabel gender = new JLabel("Gender: ");
        //JTextField heading_field= new JTextField();
        
        JLabel email = new JLabel("Email Address: ");
        JTextField email_field= new JTextField();
        
        JLabel marital_status = new JLabel("Marital Status: ");
        //JTextField heading_field= new JTextField();
        
        JLabel address = new JLabel("Address: ");
        JTextField address_field= new JTextField();
        
        JLabel city = new JLabel("City: ");
        JTextField city_field= new JTextField();
        
        JLabel state = new JLabel("State: ");
        JTextField state_field= new JTextField();
        
        JLabel pin_code = new JLabel("Pin Code: ");
        JTextField pin_code_field= new JTextField();
        
        JRadioButton male=new JRadioButton("Male");
        JRadioButton female=new JRadioButton("Female");
        JRadioButton other=new JRadioButton("Other");
        
        ButtonGroup gender_group=new ButtonGroup();
        
        JComboBox dropdown= new JComboBox();
        
        JButton next=new JButton("Next");
    
    SignUp1(){
        
        // instances of another classes
        
        
        // Frame
        setSize(800,630);
        setLocation(250,10);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        
        //application number
        utility.form_details_locator(heading,30,200,10,500,30);
        add(heading);
        //page title
        utility.form_details_locator(page_1,20,300,50,300,30);
        add(page_1);
        //name
        utility.form_details_locator(name,18,150,90,100,30);
        add(name);
        utility.for_text_field(name_field,300,90,300,30);
        add(name_field);
        //father's name
        utility.form_details_locator(father_name,18,150,130,150,30);
        add(father_name);
        utility.for_text_field(father_name_field,300,130,300,30);
        add(father_name_field);
        //date_of_birth
        utility.form_details_locator(date_of_birth,18,150,170,150,30);
        add(date_of_birth);
        calendar.setBounds(300,170,300,30);
        add(calendar);
        //gender
        utility.form_details_locator(gender,18,150,210,150,30);
        add(gender);
        utility.radio_button_style(male,300,210,60,30);
        add(male);
        utility.radio_button_style(female,380,210,80,30);
        add(female);
        utility.radio_button_style(other,480,210,60,30);
        add(other);
        gender_group.add(male);
        gender_group.add(female);
        gender_group.add(other);
        //email
        utility.form_details_locator(email,18,150,250,170,30);
        add(email);
        utility.for_text_field(email_field,300,250,300,30);
        add(email_field);
        //marital_status
        utility.form_details_locator(marital_status,18,150,290,150,30);
        add(marital_status);
        String[] items = { "Married", "Unmarried", "Divorced", "Widow" };
        dropdown = new JComboBox<>(items);
        dropdown.setBounds(300,290,300,30);
        System.out.println(dropdown);
        add(dropdown);

        //address
        utility.form_details_locator(address,18,150,330,100,30);
        add(address);
        utility.for_text_field(address_field,300,330,300,30);
        add(address_field);
        //city
        utility.form_details_locator(city,18,150,370,100,30);
        add(city);
        utility.for_text_field(city_field,300,370,300,30);
        add(city_field);
        //state
        utility.form_details_locator(state,18,150,410,100,30);
        add(state);
        utility.for_text_field(state_field,300,410,300,30);
        add(state_field);
        //pin_code
        utility.form_details_locator(pin_code,18,150,450,100,30);
        add(pin_code);
        utility.for_text_field(pin_code_field,300,450,300,30);
        add(pin_code_field);
        
        //button
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(400,500,100,30);
        add(next);
        next.addActionListener(this);
        
        //form
        
        
        setVisible(true);
    }
    
    /**
     *
     * @param ae
     */
    public void actionPerformed(ActionEvent ae){
        String formno=""+random_number; // long
        String name=name_field.getText();
        String father_name=father_name_field.getText();
        String date_of_birth=((JTextField)calendar.getDateEditor().getUiComponent()).getText();
        
        String gender="";
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender="Other";
        }
        
        String email=email_field.getText();
        
        String marital_status = (String) dropdown.getSelectedItem();
        
        String address=address_field.getText();
        String city=city_field.getText();
        String state=state_field.getText();
        String pin_code=pin_code_field.getText();
        
        try{
          if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is Required");
          }
          else if(father_name.equals("")){
              JOptionPane.showMessageDialog(null,"Father's Name is Required");
          }
          else if(date_of_birth.equals("")){
              JOptionPane.showMessageDialog(null,"Date of birth is Required");
          }
          else if(gender.equals("")){
              JOptionPane.showMessageDialog(null,"Select Gender");
          }
          else if(email.equals("")){
              JOptionPane.showMessageDialog(null,"Email is Required");
          } 
          else if(marital_status.equals("")){
              JOptionPane.showMessageDialog(null,"Select Marital Status");
          } 
          else if(address.equals("")){
              JOptionPane.showMessageDialog(null,"Address is Required");
          } 
          else if(city.equals("")){
              JOptionPane.showMessageDialog(null,"City Name is Required");
          } 
          else if(state.equals("")){
              JOptionPane.showMessageDialog(null,"State Name is Required");
          }
          else if(pin_code.equals("")){
              JOptionPane.showMessageDialog(null,"Pincoe is Required");
          }
          else{
              Conn c=new Conn();
              String query="insert into signup values('"+formno+"','"+name+"','"+father_name+"','"+date_of_birth+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+state+"','"+pin_code+"')";
              c.s.executeUpdate(query);
              setVisible(false);
              new SignUp2(formno).setVisible(true);
              
          }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String args[]){
        new SignUp1();
    }
}
