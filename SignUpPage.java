import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

public class SignUpPage extends JFrame {

    int userTxtLines = 0;
    static ArrayList<User> users;
    static Point pagePos;
    static JFrame frame = new JFrame();

    SignUpPage(){
        JLabel successfulLabel = new JLabel();
        JButton signUpButton = new JButton("Sign Up");
        JTextField emailField = new JTextField();
        JLabel emailLabel = new JLabel("Email");
        JPasswordField confirmPasswordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        JPasswordField passwordField = new JPasswordField();
        JLabel passwordLabel = new JLabel("Password");
        JTextField usernameField = new JTextField();
        JLabel usernameLabel = new JLabel("Username");
        JLabel titleLabel = new JLabel("Sign Up",SwingConstants.CENTER);
        users = new ArrayList<User>();

        userTxtLines = getNumberLines("users.txt");

        System.out.println(userTxtLines);
        for(int i = 0;i < userTxtLines;i++){ //adds every existing user to the list of users.
            users.add(new User(getUsersName(i,"users.txt"),getUsersPassword(i,"users.txt"),getUsersEmail(i,"users.txt")));
        }

        for(int i = 0;i < users.size(); i++){
            System.out.println(users.get(i));
        }

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(500,500));
        frame.setLocation(MainPage.getPosition());

        // Creates a label at the top of the frame
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

        // Creates a label specifying what the following JTextField is used for.
        confirmPasswordLabel.setSize(200,50);
        confirmPasswordLabel.setBounds((frame.getWidth()/2)-(confirmPasswordLabel.getWidth()/2),210,200,20);
        confirmPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // The JTextField used for the previous specified label.
        confirmPasswordField.setSize(new Dimension(200,30));
        confirmPasswordField.setBounds((frame.getWidth()/2)-(confirmPasswordField.getWidth()/2),240,200,30);
        confirmPasswordField.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // Creates a label specifying what the following JTextField is used for.
        emailLabel.setSize(200,50);
        emailLabel.setBounds((frame.getWidth()/2)-(emailLabel.getWidth()/2),280,200,20);
        emailLabel.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        // The JTextField used for the previous specified label.
        emailField.setSize(new Dimension(200,30));
        emailField.setBounds((frame.getWidth()/2)-(emailField.getWidth()/2),310,200,30);
        emailField.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        successfulLabel.setSize(200,50);
        successfulLabel.setBounds((frame.getWidth()/2)-(successfulLabel.getWidth()/2),400,350,20);
        successfulLabel.setFont(new Font("Times New Roman",Font.PLAIN, 15));
        successfulLabel.setForeground(Color.green);
        successfulLabel.setVisible(false);

        // The JButton to enter the information in all JTextFields.
        signUpButton.setFocusable(false);
        signUpButton.setSize(new Dimension(200,30));
        signUpButton.setBounds((frame.getWidth()/2)-(signUpButton.getWidth()/2),360,200,30);
        signUpButton.setFont(new Font("Times New Roman",Font.PLAIN, 15));

        signUpButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                userTxtLines = getNumberLines("users.txt");

                if(!(usernameField.getText().equals("")||String.valueOf(confirmPasswordField.getPassword()).equals("")||String.valueOf(confirmPasswordField.getPassword()).equals("")||emailField.getText().equals(""))){ //Checks all textFields for text.
                    if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))){ //Checks if password and confirmPassword match
                        if(checkPassword(String.valueOf(passwordField.getPassword())) == 0){
                            if(checkUsername(usernameField.getText()) == false){
                                if(checkEmail(emailField.getText()) == 0){
                                    users.add(new User(usernameField.getText(),String.valueOf(passwordField.getPassword()),emailField.getText()));
                                    successfulLabel.setText(users.get(users.size()-1).getUsername() + " Has successfully signed up!");
                                    successfulLabel.setVisible(true);
                                    System.out.println("User " + usernameField.getText() + " has been added.\n");
                                    System.out.println("User List\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
            
                                    Writer output;
                                    try {
                                        output = new BufferedWriter(new FileWriter("users.txt",true));
                                        if(userTxtLines == 0){
                                            output.append(users.get(users.size()-1).toString());
                                        }
                                        else{
                                            output.append("\n" + users.get(users.size()-1).toString());
                                        }
                                        output.close();
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }

                                    usernameField.setText("");
                                    passwordField.setText("");
                                    confirmPasswordField.setText("");
                                    emailField.setText("");
                                }
                                else if(checkEmail(emailField.getText()) == 1){
                                    JOptionPane.showMessageDialog(null, "Email has already been used", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Invalid Email", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Username is taken", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else if(checkPassword(String.valueOf(passwordField.getPassword())) == 1){
                            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", " ALERT",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Password must contain a capital letter, a number, and a special character.", " ALERT",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Passwords do not match", "ALERT", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Fill all text boxes", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                }

                for(int i = 0;i < users.size(); i++){
                    System.out.println(users.get(i));
                }
            }});

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosed(WindowEvent e) {
                if(e.getSource()==frame){
                    pagePos = frame.getLocation();
                    MainPage.mainPage.setState(JFrame.NORMAL);
                    MainPage.setMainPosition(pagePos);
                }
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
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
        frame.add(successfulLabel);
        frame.add(signUpButton);
        frame.add(emailField);
        frame.add(emailLabel);
        frame.add(confirmPasswordField);
        frame.add(confirmPasswordLabel);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(usernameLabel);
        frame.add(titleLabel);

        frame.setVisible(true);
    }

    public void closeSignUpPage(){
        System.exit(0);
    }

    public int getNumberLines(String fileName){
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String getUsersName(int lineNumber,String fileName){
        String usersData;
        String usersName = "";
        Boolean read = true;
        try {
            usersData = Files.readAllLines(Paths.get(fileName)).get(lineNumber);
            for(int i = 0; read; i++){
                if(!((i+1) >= usersData.length())){
                    if(usersData.substring(i,i+1).equals(",")){
                        read = false;
                    }
                    else{
                        usersName.equals(usersName += usersData.substring(i,i+1));
                    }
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return usersName;
    }

    public String getUsersPassword(int lineNumber,String fileName){
        String usersData;
        String usersPassword = "";
        int commas = 0;
        Boolean read = true;
        try {
            usersData = Files.readAllLines(Paths.get(fileName)).get(lineNumber);
            for(int i = 0; read; i++){
                if(!((i+1) >= usersData.length())){
                    if(usersData.substring(i,i+1).equals(",")){
                        commas++;
                    }
                    else{
                        if(commas == 1){
                            usersPassword.equals(usersPassword += usersData.substring(i,i+1));
                            
                        }
                        else{
                            if(commas > 1){
                                read = false;
                            }
                        }
                    }
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return usersPassword;
    }

    public String getUsersEmail(int lineNumber,String fileName){
        String usersEmail = "";
        int commas = 0;
        Boolean read = true;
        try {
            String usersData = Files.readAllLines(Paths.get(fileName)).get(lineNumber);
            for(int i = 0; read; i++){
                if(!((i+1) >= usersData.length())){
                    if(usersData.substring(i,i+1).equals(",")){
                        commas++;
                    }
                    else{
                        if(commas == 2){
                            usersEmail.equals(usersEmail += usersData.substring(i,i+1));
                        }
                    }
                }
                else{
                    read = false;
                }
            }
            usersEmail += usersData.charAt(usersData.length()-1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return usersEmail;
    }

    public boolean checkUsername(String username){
        boolean matches = false;
        for(int i = 0;i < users.size();i++){
            if(username.equalsIgnoreCase(users.get(i).getUsername())){
                matches = true;
            }
        }
        return matches;
    }

    public int checkEmail(String email){
        boolean isAtSymbol = false;
        boolean isPeriod = false;
        int matches = 0;
        for(int i = 0;i < users.size();i++){
            if(email.equalsIgnoreCase(users.get(i).getEmail())){
                matches = 1;
            }
        }
        for(int j = 0; j < email.length();j++){
            if((j+1) < email.length()){
                if(email.substring(j,j+1).equals("@")){
                    isAtSymbol = true;
                }
                if(email.substring(j,j+1).equals(".")){
                    isPeriod = true;
                }
            }
        }
        if(isAtSymbol == false||isPeriod == false){
            matches = 2;
        }
        return matches;
    }

    public int checkPassword(String password){
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        String[] special = {"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","{","}","[","]",",","<",".",">","?","/",";",":"};
        int checkPassword = 0;
        boolean containsCapital = false;
        boolean containsNumber = false;
        boolean containsSpecial = false;
        if(password.length() < 8){
            checkPassword = 1;
        }
        for(int i = 0;i < alphabet.length;i++){
            if(password.contains(alphabet[i])){
                containsCapital = true;
            }
        }
        
        for(int i = 0;i < numbers.length;i++){
            if(password.contains(numbers[i])){
                containsNumber = true;
            }
        }
        
        for(int i = 0;i < special.length;i++){
            if(password.contains(special[i])){
                containsSpecial = true;
            }
        }

        if(!(containsCapital&&containsNumber&&containsSpecial)){
            checkPassword = 2;
        }
        
        return checkPassword;
    }
}