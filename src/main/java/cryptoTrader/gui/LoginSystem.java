package cryptoTrader.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginSystem extends JFrame implements LoginUI, ActionListener {
    Container container = getContentPane();

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize()
    {
        //Setting location and Size of each components using setBounds() method.
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);


    }
    public void addComponentsToContainer()
    {
        //Adding each components to the Container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    public void addActionEvent()
    {
        //adding Action listener to components
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public LoginSystem() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    
    
    private boolean verify(String username, String password) throws FileNotFoundException {
    	try {
        FileReader fr = new FileReader("credentials.txt");    
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        br.readLine();
        
        while(true) {
            String user = br.readLine();
            String pass = br.readLine();
            System.out.println(user);
            System.out.println(pass);
            if(user.toLowerCase().equals(username) && pass.toLowerCase().equals(password)) {
            	br.close(); 
            	return true;
            }
            if(user == null) {
            	br.close();
            	return false;
            }
        }
        
    	} catch(Exception e) {
    		return false;
    	}
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            try {
            if (verify(userText,pwdText)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
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
}