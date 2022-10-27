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
    JFrame test;
    JButton backspace;  

    public SearchWindow(){
    	test = new JFrame("search");
        backspace = new JButton("Back Space");
        backspace.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
        test.setSize(700,500);
       // Search.setLayout(null);

       // main.setVisible(false);
        test.setVisible(true);
        test.add(backspace);
        backspace.setVisible(true);
      
        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
    }

  //read the text file 
    public ArrayList<HotelRoom> loadData() { //Invalid method declaration; return type required
      int reg = 0;
      int lux = 0;
        
      int roomID = 0;
      boolean roomStatus = false;
      String roomType;
      int numberOfRooms = 0;
      ArrayList<HotelRoom> roomList = new ArrayList<HotelRoom>();
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
        		/*if(room.getRoomType().equals("Regular")) 
            {
        			reg++;
              return reg;
            }*/
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
        		/*if(room.getRoomType().equals("Regular")) 
            {
        			reg++;
              return reg;
            }*/
        }
      }
      return lux;
    }

  //make actions 
   private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                test.setVisible(false);
                GUI goBack = new GUI();
                goBack.createAndShowGUI();
            }
        }


     
    }

  
}



