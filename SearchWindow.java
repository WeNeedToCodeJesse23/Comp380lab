//package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import java.awt.event.ActionListener;

public class SearchWindow extends JFrame {
    JFrame ThisWindow;
    JButton backspace;
    JButton MakeReservationButton;
    //static int roomID = 0;
    //static boolean roomStatus = false;
    //static String roomType;
    //static int numberOfRooms = 0;
    //static ArrayList<HotelRoom> roomList;
     
  

    public SearchWindow(){
    	ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
        MakeReservationButton = new JButton("Make Reservation");
        backspace.setBounds(500, 25, 150, 40);
        MakeReservationButton.setBounds(250, 25, 150, 40);

        ThisWindow.setSize(700, 500);
        ThisWindow.setLayout(null);
        ThisWindow.setVisible(true);
        
        ThisWindow.add(MakeReservationButton);
        ThisWindow.add(backspace);
        backspace.setVisible(true);
        MakeReservationButton.setVisible(true);
        ThisWindow.setVisible(true);

        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
        MakeReservationButton.addActionListener(Dothis);
    }

  //make actions 
   private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                ThisWindow.setVisible(false);
                GUI goBack = new GUI();
                goBack.createAndShowGUI();
                ThisWindow.dispose();
            } if(event.getSource() == MakeReservationButton){
            	
            	 HotelRoom.loadHotelData();
            	 System.out.println(HotelRoom.numAvailLux());
            	 System.out.println(HotelRoom.numAvailReg());
                 ThisWindow.setVisible(false);
                 makeReservation reservationWindow = new makeReservation();
                 
            }
        }
    }
}
