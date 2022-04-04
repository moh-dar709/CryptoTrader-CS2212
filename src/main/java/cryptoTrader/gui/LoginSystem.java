/**
 * LoginSystem holds the Login UI and integrates with the rest of the main UI
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */

package cryptoTrader.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class LoginSystem extends JFrame implements LoginUI, ActionListener {

    /**
     * All variables represent different visual elements of the login UI
     */
    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JCheckBox showPassword=new JCheckBox("Show Password");

    /**
     * This method implements the LayoutManager interface which allows us to edit the size and position of the visual elements.
     */
    public void setLayoutManager() {
        container.setLayout(null);
    }

    /**
     * This method sets the placements of all elements within the Login UI
     */
    public void setLocationAndSize()
    {
        userLabel.setBounds(50,100,100,30);
        passwordLabel.setBounds(50,150,100,30);
        userTextField.setBounds(150,100,150,30);
        passwordField.setBounds(150,150,150,30);
        showPassword.setBounds(150,200,150,30);
        loginButton.setBounds(50,250,100,30);
        resetButton.setBounds(200,250,100,30);

    }

    /**
     * This method adds the Login elements to the JFrame popup
     */
    public void addComponentsToContainer()
    {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    /**
     * This method adds creates an action when the user presses a button
     */
    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    /**
     * This constructor creates a login object by calling all the previous methods
     */
    public LoginSystem() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * This methods checks to see if the user's login information is valid
     * @param username represents the username input of the user
     * @param password represents the password input of the user
     * @return true if the username and password combination is valid, false otherwise
     * @throws FileNotFoundException
     */
    private boolean verify(String username, String password) throws FileNotFoundException {
    	// Opens and reads the file containing all valid credentials
        try {
        FileReader fr = new FileReader("credentials.txt");    
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        br.readLine();

        // Loops through the file and attempts to find a match for the user's input
        while(true) {
            String user = br.readLine();
            String pass = br.readLine();
            System.out.println(user);
            System.out.println(pass);

            // If a match is found, the method returns true
            if(user.toLowerCase().equals(username) && pass.toLowerCase().equals(password)) {
            	br.close(); 
            	return true;
            }

            // If a match is not found, the method returns false
            if(user == null) {
            	br.close();
            	return false;
            }
        }
    	} catch(Exception e) {
    		return false;
    	}
    }

    /**
     * This method performs all required actions of the Login UI.
     * It determines if the credentials are valid and displays the UI accordingly.
     * @param e represents the user pushing the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            try {
                // If the user successfully logs in, the Main UI is displayed
            if (verify(userText,pwdText)) {
                setVisible(false);
                JFrame frame = MainUI.getInstance();
                frame.setSize(900, 600);
                frame.pack();
                frame.setVisible(true);
            }
            // If the user does not successfully log in, the program terminates
            else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. \nProgram will terminate.");
                System.exit(0);
            }
            } catch (Exception FileNotFoundException) {
            	
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
} // end of file