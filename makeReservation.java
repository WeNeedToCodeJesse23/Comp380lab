//package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


//import java.awt.event.ActionListener;
//private String name;
//private String addy;
//private String emaddy;
//private String paytype;
//private String custID;
//private int roomID;

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
    int RoomSelected;
	
	
    ArrayList<HotelRoom> roomList;

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
                SearchWindow searchWin = new SearchWindow();  
                reserveWindow.dispose();
                HotelRoom.clearRoomList();
                Customer.clearCustomerList();
             }
             else if(event.getSource() == reserve)
             {
            	String name = nameField.getText();
                String address = addressField.getText();
                String email = emailField.getText();
                String cardNumber = cardNumberField.getText();
                Customer userInfo = new Customer(name, address, email, cardNumber);

                userInfo.setRoomID(RoomSelected);
               // System.out.println("this is Given ID " + userInfo.getRoomID());
                //System.out.println("RoomSelected = " + RoomSelected);
                HotelRoom.UpdateRoomStatus(RoomSelected);
                System.out.println(userInfo);

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
 


 
