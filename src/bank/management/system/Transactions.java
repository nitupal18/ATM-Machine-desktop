
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author nitu
 */
public class Transactions extends JFrame implements ActionListener {
    
    CommonUtility utility=new CommonUtility();
    
    JButton deposit=new JButton("DEPOSIT");
    JButton cash_withdrawl=new JButton("Cash Withdrawl");
    JButton fast_cash=new JButton("Fast Cash");
    JButton balance_enquiry=new JButton("Balance Enquiry");
    JButton change_pin=new JButton("Change Pin");
    JButton mini_statement=new JButton("Mini Statement");
    JButton exit=new JButton("Exit");
    
    JLabel text=new JLabel("Please Select Your Transaction");
    
    String pin_number;
    
    Transactions(String pinnumber){
        
        setLayout(null);
        
        this.pin_number=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,650);
        add(image);
        
        
        
        utility.form_details_locator(text, 20, 180, 210, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        utility.buttons(deposit, 170, 250, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(deposit);
        deposit.addActionListener(this);
        
        utility.buttons(cash_withdrawl, 170, 285, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(cash_withdrawl);
        cash_withdrawl.addActionListener(this);
        
        utility.buttons(fast_cash, 170, 320, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(fast_cash);
        fast_cash.addActionListener(this);
        
        utility.buttons(balance_enquiry, 350, 250, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(balance_enquiry);
        balance_enquiry.addActionListener(this);
        
        utility.buttons(change_pin, 350, 285, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(change_pin);
        change_pin.addActionListener(this);
        
        utility.buttons(mini_statement, 350, 320, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(mini_statement);
        mini_statement.addActionListener(this);
        
        utility.buttons(exit, 350, 355, 150, 25,Color.WHITE,Color.DARK_GRAY);
        image.add(exit);
        exit.addActionListener(this);
        
        setSize(900,650);
        setLocation(200,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);
        }
        else if(ae.getSource()==cash_withdrawl){
            setVisible(false);
            new CashWithdrawl(pin_number).setVisible(true);
        }
        else if(ae.getSource()==fast_cash){
            setVisible(false);
            new FastCash(pin_number).setVisible(true);
        }
        else if(ae.getSource()==balance_enquiry){
            setVisible(false);
            new EnterPin(pin_number,"0","Checked Balance","Balance amount: ").setVisible(true);
        }
        else if(ae.getSource()==change_pin){
            setVisible(false);
            new ChangePin(pin_number).setVisible(true);
        }
        else if(ae.getSource()==mini_statement){
            setVisible(false);
            new EnterPin(pin_number,"0","Mini Statement","").setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
}
