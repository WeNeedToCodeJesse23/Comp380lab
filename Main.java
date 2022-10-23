package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Main extends JFrame {
    //frame setup
    JFrame main;
    JFrame Search;
    JFrame CancelRoom;
    JFrame ChangeRoom;
    JFrame RateRoom;
    JFrame hotelLogin;

    //button setup
    JButton Make;
    JButton Cancel;
    JButton Rate;
    JButton Change;
    JButton Login;
    JButton ReturnMenu;

    //components need for password               
    JLabel userLb;
    JTextField userText;
    JLabel passwordLb;
    JPasswordField password;
    boolean locked;
    int visited; //visited will record the windows visited through integers, to make the conditional statements easier
    //


    Main(){
    }

    //setup mainframe
    public void createAndShowGUI () {
        locked = true;
        //visited = 0;

         main = new JFrame("Hotel AOJJ");
         Search = new JFrame("search");
         CancelRoom = new JFrame("cancel");
         ChangeRoom = new JFrame("change room");
         hotelLogin = new JFrame("Login");
         RateRoom = new JFrame("Rate");

        main.setSize(700,500);
        Search.setSize(700,500);
        CancelRoom.setSize(700,500);
        ChangeRoom.setSize(700,500);
        hotelLogin.setSize(700,500);
        RateRoom.setSize(700,500);

        //main window
        Make = new JButton("Search Reservation");
        Cancel = new JButton("Cancel Reservation");
        Rate = new JButton("Rate Reservation");
        Change = new JButton("Change Room");
        Login = new JButton("Login");
        ReturnMenu = new JButton("Backspace");


        Make.setBounds(50,25,150, 40);
       // View.setBounds(200,25,150, 40);
        Cancel.setBounds(350,25,150, 40);
        Rate.setBounds(400,25,150, 40);
        Change.setBounds(500,25,150, 40);
        Login.setBounds(10,80,80, 25);
        ReturnMenu.setBounds(400,400,100,50);

        main.add(Make);
        main.add(Cancel);
        main.add(Rate);
        main.add(Change);

        main.setLayout(new FlowLayout());
        Search.setLayout(null);
        CancelRoom.setLayout(null);
        ChangeRoom.setLayout(null);
        RateRoom.setLayout(null);
        hotelLogin.setLayout(null);

        main.setVisible(true);
        Search.setVisible(false);
        CancelRoom.setVisible(false);
        ChangeRoom.setVisible(false);
        hotelLogin.setVisible(false);


        //button Action Listeners

        myActionListener e = new myActionListener();

        Make.addActionListener(e);
       // View.addActionListener(e);
        Cancel.addActionListener(e);
        Rate.addActionListener(e);
        Change.addActionListener(e);
        ReturnMenu.addActionListener(e);
       // password.addKeyListener(e);

        Login.addActionListener(e);


        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    //add in this window
    public void RateWindow(){
        visited = 1;
        if(locked){
            LoginWindow();
        } else {
            main.setVisible(false);
            RateRoom.setVisible(true);
            RateRoom.add(ReturnMenu);
        }
    }

    //add in this window
    public void CancelWindow(){
        visited = 2;
        if(locked){
            LoginWindow();
        } else {
            main.setVisible(false);
            CancelRoom.setVisible(true);
            CancelRoom.add(ReturnMenu);
        }
    }

    //add in this window
    public void searchWindow(){
        main.setVisible(false);
        Search.setVisible(true);
        Search.add(ReturnMenu);
    }

    //add in this window
    public void ChangeWindow(){
        visited = 3;
        if(locked){
            LoginWindow();
        } else {
            main.setVisible(false);
            ChangeRoom.setVisible(true);
            ChangeRoom.add(ReturnMenu);
        }
    }

    //This is the Login window
    public void LoginWindow(){
        userLb = new JLabel("User:");
        userLb.setBounds(10,20,80,25);
        hotelLogin.add(userLb);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        hotelLogin.add(userText);

        passwordLb = new JLabel("Password:");
        passwordLb.setBounds(10,50,80,25);
        hotelLogin.add(passwordLb);

        password = new JPasswordField();
        password.setBounds(100,50,165,25);
        hotelLogin.add(password);

        hotelLogin.add(Login);
        hotelLogin.add(ReturnMenu);

        hotelLogin.setVisible(true);
        hotelLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {     
        Main test = new Main();
        test.createAndShowGUI();
    }

    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Make) {
                searchWindow();
            } else if (event.getSource() == ReturnMenu){
                ReturnToMenuCases(event);
            } else if (event.getSource() == Cancel){
                CancelWindow();
            } else if (event.getSource() == Rate){
                RateWindow();
            } else if (event.getSource() == Change) {
                ChangeWindow();
            } else if(event.getSource() == Login){
                LoginPassword(event);
            }
        }

        //Backspace to Home menu function
        public void ReturnToMenuCases (ActionEvent event){
            if ( (RateRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                RateRoom.setVisible(false);
                createAndShowGUI();
            }  else if ((ChangeRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ){
                ChangeRoom.setVisible(false);
                createAndShowGUI();
            } else if ((Search.isVisible() ) && (event.getSource() == ReturnMenu ) ){
                Search.setVisible(false);
                createAndShowGUI();
            } else if ((CancelRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                CancelRoom.setVisible(false);
                createAndShowGUI();
            }else if ((hotelLogin.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                hotelLogin.setVisible(false);
            }

        }

        //this checks login info and implements the Login action
        public void LoginPassword (ActionEvent event){
            String UserTextInput = userText.getText();
            String passwordInput = password.getText();
            if(UserTextInput.equals("guest") && passwordInput.equals("pass1")){
                hotelLogin.setVisible(false);
                locked = false;
                switch(visited){
                    case 1:
                        RateWindow();
                        break;
                    case 2:
                        CancelWindow();
                        break;
                    case 3:
                        ChangeWindow();
                        break;
                }
            }
        }
    }
}

