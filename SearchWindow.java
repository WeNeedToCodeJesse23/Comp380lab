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

public class SearchWindow extends JFrame {
    JFrame ThisWindow;
    JButton backspace;
    JButton MakeReservationButton;
    int roomID = 0;
    boolean roomStatus = false;
    String roomType;
    int numberOfRooms = 0;
    ArrayList<HotelRoom> roomList;
     
  

    public SearchWindow(){
    	 ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
        MakeReservationButton = new JButton("Make Reservation");
        backspace.setBounds(500,25,150, 40);
        MakeReservationButton.setBounds(500,100,100, 100);

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

  //read the text file 
    public ArrayList<HotelRoom> loadData() { //Invalid method declaration; return type required     
      
        roomID = 0;
        roomStatus = false;
        numberOfRooms = 0;
        roomList = new ArrayList<>();
        Scanner txtInput = null;
	    
      try
	    {
	       txtInput = new Scanner(new File("RoomReservationTestDataHotelRooms.txt"));
	       txtInput.useDelimiter(",");
	    }
	    catch(FileNotFoundException e)
	    {
	       System.out.println("Did you forget the input file?");
	       System.exit(1);
	    } //setting up getting input from txt file
	    
        while(txtInput.hasNextLine() == true)
        {
        	String roomInfo = txtInput.nextLine();
        	String[] roomArray = roomInfo.split(",");
        	roomID = Integer.parseInt(roomArray[0]);
        	roomStatus = Boolean.parseBoolean(roomArray[1]);
          roomType = roomArray[2];
          numberOfRooms = Integer.parseInt(roomArray[3]);
        	HotelRoom room = new HotelRoom(roomID, roomStatus, roomType, numberOfRooms);
        	roomList.add(room);
        	//System.out.println(roomList);
        }
      return roomList; 
    }

  //check if there are available rooms left for regular rooms
    public int numAvailReg(ArrayList<HotelRoom> roomList)
    {
      int reg = 0;
      for(int counter = 0; counter < roomList.size(); counter++)
      {
        if( (roomList.get(counter).getRoomStatus() == false) && (roomList.get(counter).getRoomType().equals("Regular")) )
        {
            reg++;
        }
      }
      return reg;
    }

  //checks if there are available rooms left for luxury room
    public int numAvailLux(ArrayList<HotelRoom> roomList)
    {
      int lux = 0;
      for(int counter = 0; counter < roomList.size(); counter++)
      {
        if( (roomList.get(counter).getRoomStatus() == false) && (roomList.get(counter).getRoomType().equals("Luxury")) )
        {
            lux++;
        }
      }
      return lux;
    }

  //make actions 
   private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                ThisWindow.setVisible(false);
                GUI goBack = new GUI();
                goBack.createAndShowGUI();
            } if(event.getSource() == MakeReservationButton){
                 ThisWindow.setVisible(false);
                 makeReservation reservationWindow = new makeReservation();
            }
        }
    }
}
