package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener {

   /**
    * 
    * @param text
    * @param font
    * @param x
    * @param y
    * @param width
    * @param height 
    * it helps to locate an text on the page
    */
    
    public void form_details_locator(JLabel text, int font, int x, int y, int width, int height) {
        text.setFont(new Font("Raleway", Font.BOLD, font));
        text.setBounds(x, y, width, height);
        add(text);
    }

    public void for_text_field(JTextField textField, int x, int y, int width, int height) {
        textField.setBounds(x, y, width, height);
        add(textField);
    }

    public void radio_button_style(JRadioButton button, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setBackground(Color.WHITE);
        add(button);
    }

    public void dropdown_style(JComboBox dropdown, String[] items, int x, int y, int width, int height) {
        dropdown = new JComboBox<>(items);
        dropdown.setBounds(x, y, width, height);
        dropdown.setBackground(Color.WHITE);
        add(dropdown);
    }

    //variables defination
    JLabel page_2 = new JLabel("Page 2: Additional Details");

    JLabel religion = new JLabel("Religion: ");
    JComboBox religion_dropdown = new JComboBox();

    JLabel category = new JLabel("Category: ");
    JComboBox category_dropdown = new JComboBox();

    JLabel income = new JLabel("Income: ");
    JComboBox income_dropdown = new JComboBox();

    JLabel education = new JLabel("Education: ");
    JComboBox education_dropdown = new JComboBox();

    JLabel occupation = new JLabel("Occupation: ");
    JComboBox occupation_dropdown = new JComboBox();

    JLabel pan_number = new JLabel("PAN NUMBER: ");
    JTextField pan_number_field = new JTextField();

    JLabel aadhar_no = new JLabel("Aadhar Number: ");
    JTextField aadhar_no_field = new JTextField();

    JLabel sr_citizen = new JLabel("Senior Citizen: ");

    JLabel existing_account = new JLabel("Existing Account: ");

    JRadioButton yes = new JRadioButton("Yes");
    JRadioButton no = new JRadioButton("No");

    JRadioButton yes1 = new JRadioButton("Yes");
    JRadioButton no1 = new JRadioButton("No");

    ButtonGroup sr_citizen_group = new ButtonGroup();
    ButtonGroup existing_account_group = new ButtonGroup();

    JButton next = new JButton("Next");
    JButton previous = new JButton("Previous");
    
    String formno;

    SignUp2(String formno) {
        // Frame
        setSize(800, 630);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        this.formno=formno;
        
        JLabel text=new JLabel("form no "+formno);
        text.setBounds(300,10,100,30);
        add(text);
        
        // Page title
        form_details_locator(page_2, 20, 300, 50, 300, 30);

        form_details_locator(religion, 18, 150, 90, 100, 30);
        String[] s1 = {"Hindu", "Islamic", "Cristian", "Sikkh"};
        religion_dropdown = new JComboBox<>(s1);
        religion_dropdown.setBounds(400, 90, 300, 30);
        System.out.println(religion_dropdown);
        add(religion_dropdown);

        form_details_locator(category, 18, 150, 130, 100, 30);
        String[] s2 = {"General", "OBC", "SC", "ST", "ST"};
        category_dropdown = new JComboBox<>(s2);
        category_dropdown.setBounds(400, 130, 300, 30);
        add(category_dropdown);

        form_details_locator(income, 18, 150, 170, 100, 30);
        String[] s3 = {"<100000", "100000>= & <500000", ">=1000000"};
        income_dropdown = new JComboBox<>(s3);
        income_dropdown.setBounds(400, 170, 300, 30);
        add(income_dropdown);
        // dropdown_style(income_dropdown,s3,400,170,300,30);

        form_details_locator(education, 18, 150, 210, 100, 30);
        String[] s4 = {"Graduation", "Post Graduation", "High School"};
        education_dropdown = new JComboBox<>(s4);
        education_dropdown.setBounds(400, 210, 300, 30);
        add(education_dropdown);
        //dropdown_style(education_dropdown,s4,400,210,300,30);

        form_details_locator(occupation, 18, 150, 250, 200, 30);
        String[] s5 = {"Government Employee", "Buisness Owner", "Private Job", "Unemployeed"};
        occupation_dropdown = new JComboBox<>(s5);
        occupation_dropdown.setBounds(400, 250, 300, 30);
        add(occupation_dropdown);
        //dropdown_style(occupation_dropdown,s5,400,250,300,30);

        form_details_locator(pan_number, 18, 150, 290, 200, 30);
        for_text_field(pan_number_field, 400, 290, 300, 30);

        form_details_locator(aadhar_no, 18, 150, 330, 200, 30);
        for_text_field(aadhar_no_field, 400, 330, 300, 30);

        form_details_locator(sr_citizen, 18, 150, 370, 200, 30);
        radio_button_style(yes, 400, 370, 100, 30);
        radio_button_style(no, 550, 370, 100, 30);
        sr_citizen_group.add(yes);
        sr_citizen_group.add(no);

        form_details_locator(existing_account, 18, 150, 410, 200, 30);
        radio_button_style(yes1, 400, 410, 100, 30);
        radio_button_style(no1, 550, 410, 100, 30);
        existing_account_group.add(yes);
        existing_account_group.add(no);

        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(600, 500, 100, 30);
        add(next);
        next.addActionListener(this);

        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 20));
        previous.setBounds(400, 500, 150, 30);
        add(previous);
        previous.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String religion = (String) religion_dropdown.getSelectedItem();
            System.out.println(religion);
            String category = (String) category_dropdown.getSelectedItem();
            String income = (String) income_dropdown.getSelectedItem();
            String education = (String) education_dropdown.getSelectedItem();
            String occupation = (String) occupation_dropdown.getSelectedItem();
            String pan_number = pan_number_field.getText();
            String aadhar_no = aadhar_no_field.getText();

            String sr_citizen = "";
            if (yes.isSelected()) {
                sr_citizen = "Yes";
            } else if (no.isSelected()) {
                sr_citizen = "No";
            }

            String existing_account = "";
            if (yes1.isSelected()) {
                existing_account = "Yes";
            } else if (no1.isSelected()) {
                existing_account = "No";
            }

            try {
                if (religion.equals("")) {
                    JOptionPane.showMessageDialog(null, "Religion is Required");
                }
                if (category.equals("")) {
                    JOptionPane.showMessageDialog(null, "Category is Required");
                }
                if (income.equals("")) {
                    JOptionPane.showMessageDialog(null, "income is Required");
                }
                if (education.equals("")) {
                    JOptionPane.showMessageDialog(null, "Select Education");
                }
                if (occupation.equals("")) {
                    JOptionPane.showMessageDialog(null, "Select is Occupation");
                }
                if (pan_number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Pan Number");
                }
                if (aadhar_no.equals("")) {
                    JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
                } else {
                    Conn c = new Conn();
                    String query = "insert into signup2 values('" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan_number + "','" + aadhar_no + "','" + sr_citizen + "','" + existing_account + "')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new SignUp3(formno).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==previous){
            new SignUp1().setVisible(true);
        }

    }

    public static void main(String args[]) {
        new SignUp2("");
    }
}
