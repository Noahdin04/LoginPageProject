import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class MainPage extends JFrame{

    static JFrame mainPage = new JFrame();;

    LoginPage loginPage;
    SignUpPage  signUpPage;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem signUp;
    JMenuItem login;
    JMenuItem exit;

    MainPage(){

        mainPage.setLayout(null);
        mainPage.setSize(new Dimension(500,500));
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menu = new JMenu();

        menu.setText("Menu");

        signUp = new JMenuItem();
        login = new JMenuItem();
        exit = new JMenuItem();

        signUp.setText("Sign Up");
        login.setText("Login");
        exit.setText("Exit");

        signUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPage = new SignUpPage();
                mainPage.setState(JFrame.ICONIFIED);
            }
        });

        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage = new LoginPage();
                mainPage.setState(JFrame.ICONIFIED);
            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(signUp);
        menu.add(login);
        menu.add(exit);

        menuBar.add(menu);

        mainPage.setJMenuBar(menuBar);
        
        mainPage.setVisible(true);
    }

    public static Point getPosition(){
        return mainPage.getLocationOnScreen();
    }
    public void createFile(){
        try {
            File users = new File("users.txt");
            if (users.createNewFile()) {
                System.out.println("File created: " + users.getName());
            }
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void setMainPosition(Point newPosition){
        mainPage.setLocation(newPosition);
    }
}
