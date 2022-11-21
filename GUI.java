//package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;
//import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Date: October 24, 2022
 * The main GUI window
 * @author omarg,
 */

public class GUI extends JFrame  {
    /**
     * This is the main Interface of the program.
     *
     */


    //frame setup
    private static final long serialVersionUID = 1L;
    /**
     *
     *
     * @var locked ensures no one enters unless the user logs in .
     * @var visited keeps track of visited windows when it goes into login window and make it so that they can return to that window
     * @var customer key is the location of said user in the customer database
     */

    /**
     * the main frame
     */
    JFrame main;
    /**
     * the Login frame
     */
    JFrame hotelLogin;
    //button setup
    /**
     * the make button - goes to the Search window
     */
    JButton Make;
    /**
     * the Cancel button - goes to Cancel Window
     */
    JButton Cancel;
    /**
     * the Rate button - goes to Rate Window
     */
    JButton Rate;
    /**
     * the Change button - goes to the Change Rooms window
     */
    JButton Change;
    /**
     * the Login Button - goes to the Login Window
     * LoginPassword method-
     * Description: Login system is going to check userInput and passwordInput and going to go through the list in the database to vertify user
     * If password is correct, it finds that user in the database it is going to return to window where the user wanted to go and unlock it for them \n
     * It is also going to return the location of the user in the database so it can perform the necessary actions needed for that user account
     * if password is incorrect, it won't let the user pass

     * Accessed Classes: CheckPass(); in Customer, manager.java
     * Checkpass(); will check if the user input matches one of the profiles in the Customer/manager Database
     * If it does, it is going to return that location of the Accessed Class which passes the conditional login statement and unlocks access
     * If it doesn't it's going to return a negative meaning it doesn't pass the conditional login statement
     * It is going to look through the visited windows to return to that method that was previously locked and visited them, giving the
     * value of CustomerKey(location of their data in the collection) to be transferred to the window they goin to go
     *
     */
    JButton Login;
    /**
     * the Return to Menu button - backspace
     * Used in -
     * ReturnToMenuCases method-
     *      * Description: Backspace back into menu mostly used for login Window
     *      *  Set Login frame to false and open up GUI setup frame again
     */
    JButton ReturnMenu;
    /**
     * the Generate button - goes to the generate window
     */
    JButton Generate;


    //components need for password
    /**
     * user label
     */
    JLabel userLb;
    /**
     * Takes the user username input
     */
    JTextField userText;
    /**
     * password label
     */
    JLabel passwordLb;
    /**
     * Takes the user password label
     */
    JPasswordField password;
    /**
     * locked ensures no one enters unless the user logs in .
     */
    boolean locked;
    /**
     *  visited will record the windows visited through integers, to make the conditional statements easier
     */
    int visited;
    /**
     * CustomerKey is the user data location in the database collection
     */
    int CustomerKey;

    /**
     * constructor
     */
    GUI(){

    }


    /**
     * Going to make the Main GUI:
     * Going to create the buttons
     * Setup the framesize color and placements of buttons
     *
     * Add Buttons to action Listener
     * Setup the buttons and also call to ActionListener class "myActionListener"
     * Create an exit when close
     *
     * myActionListener Class:----------------------------
     * actionPerformed method- Description: All the button actions performed in the GUI main window and their output.
     * ReturnToMenu method - Description: Return to the main menu
     * LoginPassword - Description: Going to Login the Hotel Program to vertify and collect user data
     *
     *
     */
    //setup mainframe
    public void createAndShowGUI () {
        locked = true;
        main = new JFrame("Hotel AOJJ");
        hotelLogin = new JFrame("Login");
        main.setSize(700,500);
        hotelLogin.setSize(700,500);

        //main window
        Make = new JButton("Search Reservation");
        Cancel = new JButton("Check-Out");
        Rate = new JButton("Rate Reservation");
        Change = new JButton("Change Room");
        Login = new JButton("Login");
        ReturnMenu = new JButton("Backspace");
        Generate = new JButton("Generate");




        Make.setBounds(50,25,150, 40);
        Cancel.setBounds(350,25,150, 40);
        Rate.setBounds(400,25,150, 40);
        Change.setBounds(500,25,150, 40);
        Login.setBounds(10,80,80, 25);
        ReturnMenu.setBounds(400,400,100,50);
        Generate.setBounds(50,75,150, 40);


        main.getContentPane().setBackground(Color.darkGray);
       // hotelLogin.getContentPane().setBackground(Color.darkGray);

        main.add(Make);
        main.add(Cancel);
        main.add(Rate);
        main.add(Change);
        main.add(Generate);


        main.setLayout(new FlowLayout());
        hotelLogin.setLayout(null);
        main.setVisible(true);
        hotelLogin.setVisible(false);

        /*
        // make image
        try {
            BufferedImage makeJPG = ImageIO.read(new File("mqdefault.jpg"));
            JLabel picture = new JLabel(new ImageIcon(makeJPG));
            picture.setBounds(100,700,100,100);
            picture.setVisible(true);
            main.add(picture);

        } catch (IOException e){
            System.out.println("no image :(");
        }

         */

        //button Action Listeners
        myActionListener e = new myActionListener();

        /**
         * @param e
         * Call to an action listener and it will return action response
         */

        Make.addActionListener(e);
        Cancel.addActionListener(e);
        Rate.addActionListener(e);
        Change.addActionListener(e);
        ReturnMenu.addActionListener(e);
        Login.addActionListener(e);
        Generate.addActionListener(e);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    /**
     *
     * RateWindow will call the RateWindow class which opens up Rate Window interface
     * It will go to and call LoginWindow() if the window is locked
     * It will go to RateWindow class if the window is unlocked
     * visited is checked to that the program remembers where user was when they go to LoginWindow
     *
     * @param key
     * The user location in the Customer Database. By Default, it is set to 0 unless it gets that location.
     * once RateWindow, CancelWindow and ChangeWindow are unlocked, key will be used to carry that location on those other Windows
     */
    public void RateWindow(int key){
        visited = 1;
        CustomerKey = key;
        if(locked){
            LoginWindow();
        } else {
          //  System.out.println("this button functions" + CustomerKey);
            rateReservation rateWindow = new rateReservation(key);
            main.dispose();
        }
    }

    /**
     *
     * CancelWindow will call the CancelWindow class which opens up Cancel Window interface
     * It will go to and call LoginWindow() if the window is locked
     * It will go to CancelWindow class if the window is unlocked
     * visited is checked to that the program remembers where user was when they go to LoginWindow
     *
     * @param key
     * The user location in the Customer Database. By Default, it is set to 0 unless it gets that location.
     * once RateWindow, CancelWindow and ChangeWindow are unlocked, key will be used to carry that location on those other Windows
     */
    public void CancelWindow(int key){
        visited = 2;
        CustomerKey = key;
        if(locked){
            LoginWindow();
        } else {
          //  System.out.println("this button functions" + CustomerKey);
            CancelReservationWindow goTo = new CancelReservationWindow(CustomerKey);
            main.dispose();
        }
    }

    /**
     * Goes to search window
     * disposes main
     *
     */
    //add in this window
    public void searchWindow(){
        SearchWindow tryThis = new SearchWindow();
        main.dispose();
    }

    /**
     *
     * ChangeWindow will call the CancelWindow class which opens up Change Window interface
     * It will go to and call LoginWindow() if the window is locked
     * It will go to ChangeWindow class if the window is unlocked
     * visited is checked to that the program remembers where user was when they go to LoginWindow
     *
     * @param key
     *The user location in the Customer Database. By Default, it is set to 0 unless it gets that location.
     *once RateWindow, CancelWindow and ChangeWindow are unlocked, key will be used to carry that location on those other Windows
     */
    //Window Not Yet Made
    public void ChangeWindow(int key){
        visited = 3;
        CustomerKey = key;
        if(locked){
            LoginWindow();
        } else {
           // System.out.println("this button functions" + CustomerKey);
            ChangeRoom proces = new ChangeRoom(CustomerKey);
            main.dispose();
        }
    }
    /**
     * Make the Login Window (setup frame and button)
     * add actionlistener to button that is used to confirm user input
     * Take in Username and Password of user
     */
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

    /**
     *
     * goes to generate window for manager
     * Will check if the window is locked
     * if it is, it's going to call the login and access to the window will be denied
     * If unlocked, it will carry the user location in data to the gen window class
     * @param key
     * user location in data
     */
    public void genWindow(int key){
        visited = 4;
        CustomerKey = key;
        if(locked){
            LoginWindow();
        } else {
            System.out.println("this button functions" + CustomerKey);
            GenReportWindow genWindow = new GenReportWindow(key);
            main.dispose();
        }
    }


    /**
     * This class handles every action taken in the main frame
     */

    private class myActionListener implements ActionListener {
        /**
         * @author omarg
         * @param event describes action
         * All the button actions performed in the GUI main window and their output.
         */
        //Button actions
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Make) {
                searchWindow();
            } else if (event.getSource() == ReturnMenu){
                ReturnToMenuCases(event);
            } else if (event.getSource() == Cancel){
                CancelWindow(0);
            } else if (event.getSource() == Rate){
                RateWindow(0);
            } else if (event.getSource() == Change) {
                ChangeWindow(0);
            } else if(event.getSource() == Login){
                LoginPassword(event);
            } else if(event.getSource() == Generate) {
                genWindow(0);
            }
        }

        /**
         *
         * Description: Backspace back into menu mostly used for login Window
         *  Set Login frame to false and open up GUI setup frame again
         *
         *  @author omarg
         *  @param event
         *  Action Event
         */
        //Backspace to Home menu function
        public void ReturnToMenuCases (ActionEvent event){
      if ((hotelLogin.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                hotelLogin.setVisible(false);
                main.setVisible(false);
                createAndShowGUI();
            }

        }


        /**
         * Description: Login system is going to check userInput and passwordInput and going to go through the list in the database to vertify user
         * If password is correct, it finds that user in the database it is going to return to window where the user wanted to go and unlock it for them
         * It is also going to return the location of the user in the database so it can perform the necessary actions needed for that user account
         * if password is incorrect, it won't let the user pass
         *
         * Accessed Classes: CheckPass(); in Customer, manager.java
         * Checkpass(); will check if the user input matches one of the profiles in the Customer/manager Database
         * If it does, it is going to return that location of the Accessed Class which passes the conditional login statement and unlocks access
         * If it doesn't it's going to return a negative meaning it doesn't pass the conditional login statement
         * It is going to look through the visited windows to return to that method that was previously locked and visited them, giving the
         * value of CustomerKey(location of their data in the collection) to be transferred to the window they goin to go
         *
         * @author omarg
         * @param event
         * Action Event
         *
         */
        //this checks login info and implements the Login action
        public void LoginPassword (ActionEvent event){
            String UserTextInput = userText.getText();
            String passwordInput = password.getText();
            // System.out.println(Customer.CheckPass("Sam","10"));
            int results = Customer.CheckPass(UserTextInput,passwordInput);
            int managerLogin = manager.CheckPass(UserTextInput,passwordInput);
          //  System.out.println(managerLogin);
            if((results >= 0) || (managerLogin >= 0)){
                System.out.println(true);
                hotelLogin.dispose();
                locked = false;
                switch(visited){
                    case 1:
                        RateWindow(results); //
                        break;
                    case 2:
                        CancelWindow(results);
                        break;
                    case 3:
                        ChangeWindow(results);
                        break;
                    case 4:
                        genWindow(managerLogin);
                        break;
                }
            } else {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Incorrect information provided");
            }

        }
    }
}
