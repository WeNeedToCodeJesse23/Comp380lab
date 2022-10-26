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

public class SearchWindow extends GUI{
    JFrame test;
    JButton backspace;

    public void DoSearch() {
      //  Search.add(ReturnMenu);
        test = new JFrame("search");
        backspace = new JButton("Back Space");
        backspace.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
        test.setSize(700,500);
       // Search.setLayout(null);

       // main.setVisible(false);
        test.setVisible(true);
        test.add(backspace);
        backspace.setVisible(true);
        

       // ReturnMenu.setBounds(280,400,100,50);
       // peta.add(ReturnMenu);
        
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
        	if(room.getRoomStatus()) {
        		if(room.getRoomType().equals("Regular")) {
        			reg++;
        		}
        		else {
        			lux++;
        		}
        	}
        	roomList.add(room);
        	//System.out.println(roomList);
        }
        txtInput.close();
        if(reg<80){
        	
        }
        
        

    }


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
    }


}
