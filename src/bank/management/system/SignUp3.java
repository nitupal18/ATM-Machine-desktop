package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 *
 * @author nitu
 */
public class SignUp3 extends JFrame implements ActionListener {

    CommonUtility utility = new CommonUtility();

    String formn_number;

    JLabel page_3 = new JLabel("Page 3: Account Details");

    JLabel account_type = new JLabel("Account Type");
    JRadioButton saving_account = new JRadioButton("Saving Account");
    JRadioButton fd_account = new JRadioButton("Fixed Deposite Account");
    JRadioButton current_account = new JRadioButton("Current Account");
    JRadioButton recurring_account = new JRadioButton("Recurring Deposite Account");
    ButtonGroup ac_btn_grp = new ButtonGroup();

    JLabel card_number = new JLabel("Card Number");
    JLabel your_16_dig_number = new JLabel("Your 16 Digit Card Number");
    JLabel crd_number = new JLabel("XXXX-XXXX-XXXX-");

    JLabel pin = new JLabel("PIN:");
    JLabel your_4_dig_password = new JLabel("Your 16 Digit Digit Password");
    JLabel pin_number = new JLabel("XXXX");

    JLabel services_required = new JLabel("Services Required:");
    JCheckBox atm_card = new JCheckBox("ATM CARD");
    JCheckBox internet_banking = new JCheckBox("Internet Banking");
    JCheckBox mobile_banking = new JCheckBox("Mobile Banking");
    JCheckBox email_sms_alerts = new JCheckBox("Email and SMS Alerts");
    JCheckBox cheque_book = new JCheckBox("Cheque Book");
    JCheckBox statement = new JCheckBox("Statement");

    JCheckBox concent = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");

    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");

    SignUp3(String formno) {
        setSize(800, 630);
        setLocation(250, 10);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        this.formn_number = formno;
        JLabel text = new JLabel("form no " + formn_number);
        utility.form_details_locator(text, 18, 300, 10, 200, 30);
        add(text);

        utility.form_details_locator(page_3, 20, 300, 50, 300, 30);
        add(page_3);

        // Account type
        utility.form_details_locator(account_type, 18, 150, 90, 300, 30);
        add(account_type);
        utility.radio_button_style(saving_account, 150, 120, 200, 30);
        add(saving_account);
        utility.radio_button_style(fd_account, 400, 120, 200, 30);
        add(fd_account);
        utility.radio_button_style(current_account, 150, 160, 200, 30);
        add(current_account);
        utility.radio_button_style(recurring_account, 400, 160, 200, 30);
        add(recurring_account);

        ac_btn_grp.add(saving_account);
        ac_btn_grp.add(fd_account);
        ac_btn_grp.add(current_account);
        ac_btn_grp.add(recurring_account);

        // Card number
        utility.form_details_locator(card_number, 18, 150, 220, 300, 30);
        add(card_number);
        utility.form_details_locator(your_16_dig_number, 10, 150, 240, 300, 30);
        add(your_16_dig_number);
        utility.form_details_locator(crd_number, 18, 380, 220, 300, 30);
        add(crd_number);

        //pin
        utility.form_details_locator(pin, 18, 150, 300, 300, 30);
        add(pin);
        utility.form_details_locator(your_4_dig_password, 10, 150, 320, 300, 30);
        add(your_4_dig_password);
        utility.form_details_locator(pin_number, 18, 380, 300, 300, 30);
        add(pin_number);

        // services required
        utility.form_details_locator(services_required, 18, 150, 380, 300, 30);
        add(services_required);
        utility.checkbox_button_style(atm_card, 150, 410, 200, 30);
        add(atm_card);
        utility.checkbox_button_style(internet_banking, 150, 430, 200, 30);
        add(internet_banking);
        utility.checkbox_button_style(mobile_banking, 150, 450, 200, 30);
        add(mobile_banking);
        utility.checkbox_button_style(email_sms_alerts, 400, 410, 200, 30);
        add(email_sms_alerts);
        utility.checkbox_button_style(cheque_book, 400, 430, 200, 30);
        add(cheque_book);
        utility.checkbox_button_style(statement, 400, 450, 200, 30);
        add(statement);

        //concent
        utility.checkbox_button_style(concent, 150, 500, 500, 30);
        add(concent);

        utility.buttons(cancel, 170, 550, 100, 20,Color.WHITE,Color.BLACK);
        add(cancel);
        cancel.addActionListener(this);

        utility.buttons(submit, 330, 550, 100, 20,Color.WHITE,Color.BLACK);
        add(submit);
        submit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            Random rand = new Random();
            String card_number_t = "" + Math.abs((rand.nextLong() % 90000000L) + 2435675000000000L);
            System.out.println(card_number_t);
            String pin_number_t = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);

            String account_type_enter = "";
            if (saving_account.isSelected()) {
                account_type_enter = "Saving Account";
            }
            if (fd_account.isSelected()) {
                account_type_enter = "Fixed Deposit Acount";
            }
            if (current_account.isSelected()) {
                account_type_enter = "Current Account";
            }
            if (recurring_account.isSelected()) {
                account_type_enter = "Recurring Deposit Account";
            }

            String facility = "";
            if (atm_card.isSelected()) {
                facility += "ATM CARD ";
            }
            if (internet_banking.isSelected()) {
                facility += "Internet Banking ";
            }
            if (mobile_banking.isSelected()) {
                facility += "Mobile Banking ";
            }
            if (email_sms_alerts.isSelected()) {
                facility += "Email SMS Alerts ";
            }
            if (cheque_book.isSelected()) {
                facility += "Cheque Book ";
            }
            if (statement.isSelected()) {
                facility += "E-Statement ";
            }
            
            try{
                if(account_type_enter.equals("")){
                    JOptionPane.showMessageDialog(null, "Select account type");
                }else{
                    Conn c=new Conn();
                    String query1 ="insert into login values('"+card_number_t+"', '"+pin_number_t+"')";
                    String query2 = "insert into signup3 values('" + card_number_t + "','" + pin_number_t + "','" + account_type_enter + "','" + facility+ "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+card_number_t+"and pin: "+pin_number_t);
                    setVisible(false);
                    new Transactions(pin_number_t).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }else if(ae.getSource()==cancel){
            
        }

    }

    public static void main(String args[]) {
        new SignUp3("");
    }
}
