import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPage extends JFrame{
    
    JButton logInButton = new JButton("Log In");
    JTextField passwordField = new JTextField();
    JLabel passwordLabel = new JLabel("Password");
    JTextField usernameField = new JTextField();
    JLabel usernameLabel = new JLabel("Username");
    JLabel titleLabel = new JLabel("Log In",SwingConstants.CENTER);
    static Point pagePos;
    static JFrame frame = new JFrame();

    LoginPage(){
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(500,500));
        frame.setLocation(MainPage.getPosition());

        titleLabel.setSize(200,50);
        titleLabel.setBounds((frame.getWidth()/2)-(titleLabel.getWidth()/2),10,200,50);
        titleLabel.setFont(new Font("Times New Roman",Font.PLAIN, 25));

        // Creates a label specifying what the following JTextField is used for.
        usernameLabel.setSize(200,50);
        usernameLabel.setBounds((frame.getWidth()/2)-(usernameLabel.getWidth()/2),70,200,20);
        usernameLabel.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // The JTextField used for the previous specified label.
        usernameField.setSize(new Dimension(200,30));
        usernameField.setBounds((frame.getWidth()/2)-(usernameField.getWidth()/2),100,200,30);
        usernameField.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // Creates a label specifying what the following JTextField is used for.
        passwordLabel.setSize(200,50);
        passwordLabel.setBounds((frame.getWidth()/2)-(passwordLabel.getWidth()/2),140,200,20);
        passwordLabel.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // The JTextField used for the previous specified label.
        passwordField.setSize(new Dimension(200,30));
        passwordField.setBounds((frame.getWidth()/2)-(passwordField.getWidth()/2),170,200,30);
        passwordField.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        logInButton.setFocusable(false);
        logInButton.setSize(new Dimension(200,30));
        logInButton.setBounds((frame.getWidth()/2)-(logInButton.getWidth()/2),230,200,30);
        logInButton.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        logInButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }});

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosed(WindowEvent e) {
                if(e.getSource()==frame){
                    pagePos = frame.getLocation();
                    MainPage.mainPage.setState(JFrame.NORMAL);
                }
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        frame.add(logInButton);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(usernameLabel);
        frame.add(titleLabel);
        frame.setVisible(true);
    }

}
