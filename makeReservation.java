//package com.company;
//import java.awt.*;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import java.awt.event.ActionListener;


//import java.awt.event.ActionListener;
//private String name;
//private String addy;
//private String emaddy;
//private String paytype;
//private String custID;
//private int roomID;

/**
 * @author Jaztin Tabunda
 * Date of Code: Nov. 7, 2022
 * <p>
 * Programmer's Names: Alondra, Omar, Jesse, Jaztin
 * <p>
 * Brief Description of the Class/Module:
 * <p> 
 * This class is used to make the GUI for the Make a Reservation Window Functionality. This Window will take in input from the user.
 * Inputted Reservation information such as name, address, email, card number,
 * Customer ID, and Room ID are received through the use of this class. This class implements Java's built-in Swing library to create a
 * Reservation Window GUI. Additionally, this class implements the ActionListener class to provide button functionality for the buttons on the 
 * MakeReservation Window. 
 * 
 */

public class makeReservation /*extends JFrame*/ {
    JFrame reserveWindow;
    JPanel panel;
    
    JLabel nameLabel;
    JLabel addressLabel;
    JLabel emailLabel;
    JLabel cardNumberLabel;
    
    JTextField nameField = new JTextField(20);
    JTextField emailField = new JTextField(345);
    JTextField addressField = new JTextField();
    JTextField cardNumberField = new JTextField();
    
    JButton backspace;
    JButton reserve;
    myActionListener listener = new myActionListener();
    int RoomSelected = 0;

	
    //ArrayList<HotelRoom> roomList;
/**
 * 
 * @param RoomSelected
 * The MakeReservation class's constructor takes in the RoomSelected parameter to generate an instance of MakeReservationWindow that
 * will reserve a room that has a roomID that matches the value passed in. In other words, after receiving the selected room,
 * this class will allow the user to fill out the rest of the reservation information such as name, address, email address, and card number
 */
     public makeReservation(int RoomSelected){
        this.RoomSelected = RoomSelected + 1;
        reserveWindow = new JFrame();
        panel = new JPanel();
        backspace = new JButton("Backspace");
        reserve = new JButton("Reserve");
        
        nameLabel = new JLabel("Name:");
        addressLabel = new JLabel("Address:");
        emailLabel = new JLabel("Email:");
        cardNumberLabel = new JLabel("Card Number:");
        
        nameField = new JTextField(20);
        emailField = new JTextField(345);
        addressField = new JTextField();
        cardNumberField = new JTextField();
        
        reserveWindow.setSize(700, 500);
        panel.setLayout(null);
        reserveWindow.add(panel);
        backspace.setBounds(500, 350, 150, 40);
        reserve.setBounds(250, 350, 150, 40);
        
        nameLabel.setBounds(10, 100, 80, 25);
        addressLabel.setBounds(10, 150, 80, 25);
        emailLabel.setBounds(10, 200, 80, 25);
        cardNumberLabel.setBounds(10, 250, 80, 25);
        
        nameField.setBounds(100, 100, 500, 25);
        addressField.setBounds(100, 150, 500, 25);
        emailField.setBounds(100, 200, 500, 25);
        cardNumberField.setBounds(100, 250, 500, 25);
        
        panel.add(backspace);
        panel.add(reserve);
        panel.add(nameLabel);
        panel.add(emailLabel);
        panel.add(addressLabel);
        panel.add(cardNumberLabel);
        panel.add(nameField);
        panel.add(emailField);
        panel.add(addressField);
        panel.add(cardNumberField);
        
        reserveWindow.setVisible(true);
        
        reserve.addActionListener(listener);
        backspace.addActionListener(listener);
    }

    
  /*public void LuxuryWindow(){

  }*/

  /*public void RegularWindow(){
        test = new JFrame("reserve");
        backspace = new JButton("Back Space");
   
        
        test.setSize(700,500);
        test.setLayout(null);
       // Search.setLayout(null);
        backspace.setBounds(50,50, 50, 50);

        test.setVisible(true);
        test.add(backspace);
        backspace.setVisible(true);
      
        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);    
  }*/

    


    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                reserveWindow.setVisible(false);
              
                reserveWindow.dispose();
                
               
              //  HotelRoom.clearRoomList();
              //  Customer.clearCustomerList();
                  SearchWindow searchWin = new SearchWindow(); 
             }
             else if(event.getSource() == reserve)
             {
            	String name = nameField.getText();
                String address = addressField.getText();
                String email = emailField.getText();
                String cardNumber = cardNumberField.getText();
                
                	 if(cardNumber.length()!=16) {
                     	JOptionPane.showMessageDialog(null, "Invalid card number. \n Try again!");
                     	return;
                	 }
             
                Customer userInfo = new Customer(name, address, email, cardNumber);
                System.out.println(userInfo.getCheckin());

                userInfo.setRoomID(RoomSelected);
               // System.out.println("this is Given ID " + userInfo.getRoomID());
                //System.out.println("RoomSelected = " + RoomSelected);
                ReviewReservationWindow review = new ReviewReservationWindow(userInfo);
                reserveWindow.setVisible(false);
                reserveWindow.dispose();
                //ConfirmationWindow confirm = new ConfirmationWindow(userInfo);
                
                //System.out.println(userInfo);
                
                //SearchWindow.loadData();
            	 /*System.out.println("Reserved!\n"
            	 		+ "Provided Info:\n"
            	 		+ "Name: " + name + "\n"
            	 		+ "Email: " + email + "\n"
            	 		+ "Address: " + address + "\n");*/
             }
        }
    }

}

	//Button actions
 


 
