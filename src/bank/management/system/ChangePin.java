package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author nitu
 */
public class ChangePin extends JFrame implements ActionListener {

    CommonUtility utility = new CommonUtility();

    String pin_number;

    JLabel enter_new_pin = new JLabel("enter new pin :");
    JPasswordField enter_new_pin_field = new JPasswordField();
    JLabel confirm_pin = new JLabel("confirm pin: ");
    JPasswordField confirm_pin_field = new JPasswordField();
    JButton change = new JButton("Change");
    JButton back = new JButton("Back");

    ChangePin(String pinnumber) {
        setLayout(null);

        this.pin_number = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        utility.form_details_locator(enter_new_pin, 18, 160, 220, 200, 30);
        enter_new_pin.setForeground(Color.WHITE);
        image.add(enter_new_pin);
        utility.for_password_field(enter_new_pin_field, 320, 220, 180, 30);
        image.add(enter_new_pin_field);

        utility.form_details_locator(confirm_pin, 18, 160, 260, 200, 30);
        confirm_pin.setForeground(Color.WHITE);
        image.add(confirm_pin);
        utility.for_password_field(confirm_pin_field, 320, 260, 180, 30);
        image.add(confirm_pin_field);

        utility.buttons(change, 270, 300, 100, 35, Color.WHITE, Color.darkGray);
        image.add(change);
        change.addActionListener(this);

        utility.buttons(back, 270, 345, 100, 35, Color.WHITE, Color.darkGray);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 650);
        setLocation(200, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        } else if (ae.getSource() == change) {
            try {
                String new_pin = enter_new_pin_field.getText();
                String confirm = confirm_pin_field.getText();
                if (!new_pin.equals(confirm)) {
                    System.out.println(new_pin);
                    System.out.println(confirm);
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                    return;
                }
                if (enter_new_pin_field.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (confirm_pin_field.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                setVisible(false);
                new EnterPin(pin_number,confirm,"Pin Change","Pin Changed successfully").setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String args[]) {
        new ChangePin("");
    }
}
