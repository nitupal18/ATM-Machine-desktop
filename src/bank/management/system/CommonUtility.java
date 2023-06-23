
package bank.management.system;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author nitu
 */
public class CommonUtility {
    /**
     * 
     * @param text
     * @param font
     * @param x
     * @param y
     * @param width
     * @param height 
     * this helps to locate any text
     */
    public void form_details_locator(JLabel text, int font, int x, int y, int width, int height) {
        text.setFont(new Font("Raleway", Font.BOLD, font));
        text.setBounds(x, y, width, height);
    }
    
    
    /**
     * 
     * @param button
     * @param x
     * @param y
     * @param width
     * @param height 
     * 
     * this method can be used to locate and style radio buttons
     */
    public void radio_button_style(JRadioButton button,int x, int y, int width, int height){
        button.setBounds(x,y,width,height);
        button.setBackground(Color.WHITE);
    }
    
    /**
     * 
     * @param button
     * @param x
     * @param y
     * @param width
     * @param height 
     * this method can be used to locate and style buttons
     */
    public void checkbox_button_style(JCheckBox button,int x, int y, int width, int height){
        button.setBounds(x,y,width,height);
        button.setBackground(Color.WHITE);
    }
    
    /**
     * 
     * @param button
     * @param x
     * @param y
     * @param width
     * @param height 
     * @param background
     * @param foreground
     * 
     * this methods helps in styling buttons
     */
    public void buttons(JButton button, int x,int y,int width,int height,Color foreground,Color background){
        button.setBounds(x,y,width,height);
        button.setBackground(background);
        button.setForeground(foreground);
    }
    
    /**
     * 
     * @param text
     * @param font
     * @param x
     * @param y
     * @param width
     * @param height 
     * 
     * it is used to style the text for login page
     */
    public void for_texts(JLabel text, int font, int x, int y, int width , int height){
        text.setFont(new Font("Osward",Font.BOLD,font));
        text.setBounds(x,y,width,height);
    }
    /**
     * 
     * @param textField
     * @param x
     * @param y
     * @param width
     * @param height 
     * for locating text field
     */
    public void for_text_field(JTextField textField, int x, int y, int width, int height){
        textField.setBounds(x,y,width,height);
        Font font = new Font("Arial", Font.PLAIN, 23);
        textField.setFont(font);
    }
    /**
     * 
     * @param passwordField
     * @param x
     * @param y
     * @param width
     * @param height 
     * locating password fields
     */
    
    public void for_password_field(JPasswordField passwordField, int x, int y, int width, int height){
        passwordField.setBounds(x,y,width,height);
    }
}
