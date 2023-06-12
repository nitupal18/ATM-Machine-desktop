package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nitu
 */
public class FastCash extends JFrame implements ActionListener {

    CommonUtility utility = new CommonUtility();

    JRadioButton five_hundred = new JRadioButton("500");
    JRadioButton thousand = new JRadioButton("1000");
    JRadioButton fiftin_hundred = new JRadioButton("1500");
    JRadioButton two_thousand = new JRadioButton("2000");
    JRadioButton twentyfive_hundred = new JRadioButton("2500");
    JRadioButton three_thousand = new JRadioButton("3000");
    
    ButtonGroup cash_btn_grp = new ButtonGroup();

    JButton withdraw = new JButton("Withdraw");
    JButton back = new JButton("Back");

    JLabel text = new JLabel("Please Select The Amount");

    String pin_number;

    FastCash(String pinnumber) {
        setLayout(null);

        this.pin_number = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        utility.form_details_locator(text, 20, 180, 210, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        utility.radio_button_style(five_hundred, 170, 250, 150, 25);
        image.add(five_hundred);
        five_hundred.addActionListener(this);

        utility.radio_button_style(thousand, 170, 285, 150, 25);
        image.add(thousand);
        thousand.addActionListener(this);

        utility.radio_button_style(fiftin_hundred, 170, 320, 150, 25);
        image.add(fiftin_hundred);
        fiftin_hundred.addActionListener(this);

        utility.radio_button_style(two_thousand, 350, 250, 150, 25);
        image.add(two_thousand);
        two_thousand.addActionListener(this);

        utility.radio_button_style(twentyfive_hundred, 350, 285, 150, 25);
        image.add(twentyfive_hundred);
        twentyfive_hundred.addActionListener(this);

        utility.radio_button_style(three_thousand, 350, 320, 150, 25);
        image.add(three_thousand);
        three_thousand.addActionListener(this);
        
        cash_btn_grp.add(five_hundred);
        cash_btn_grp.add(thousand);
        cash_btn_grp.add(fiftin_hundred);
        cash_btn_grp.add(two_thousand);
        cash_btn_grp.add(twentyfive_hundred);
        cash_btn_grp.add(three_thousand);

        utility.buttons(withdraw, 350, 355, 150, 25, Color.WHITE, Color.DARK_GRAY);
        image.add(withdraw);
        withdraw.addActionListener(this);
      

        utility.buttons(back, 350, 355, 150, 25, Color.WHITE, Color.DARK_GRAY);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 650);
        setLocation(200, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String amount="0";

        if(five_hundred.isSelected()){
            amount="500";
        }
        if(thousand.isSelected()){
            amount="1000";
        }
        if(fiftin_hundred.isSelected()){
            amount="1500";
        }
        if(two_thousand.isSelected()){
            amount="2000";
        }
        if(twentyfive_hundred.isSelected()){
            amount="2500";
        }
        if(three_thousand.isSelected()){
            amount="3000";
        }
        
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }if (ae.getSource() == withdraw) {
            setVisible(false);
            new EnterPin(pin_number,amount,"Withdrawl","Withdrawl Successfull").setVisible(true);
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
