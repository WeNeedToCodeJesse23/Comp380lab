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
    
        public void makeTable(){
        ArrayList testy = HotelRoom.ReturnCollection();

        Stream<HotelRoom> spet = testy.stream();
        Spliterator<HotelRoom> sptr = spet.spliterator();

        String Column[] = {"Room","Room Status","Room Type","Number of Beds"};
        DefaultTableModel DataTable = new DefaultTableModel(Column,0);
        sptr.forEachRemaining((n) -> DataTable.addRow(new Object[]{n.getRoomID(), n.getRoomStatus(),n.getRoomType(), n.getNumberOfBeds()}));
        // sptr.forEachRemaining((n) -> System.out.println(n)); //test to print out the data stored in HotelRoom in console.

        JTable DeTable = new JTable(DataTable);

        DeTable.setPreferredScrollableViewportSize(new Dimension(30,100000));
        DeTable.setFillsViewportHeight(true);

        JScrollPane fr = new JScrollPane(DeTable);

        fr.setBounds(300,10,700,10000);
        fr.setVisible(true);
        ThisWindow.add(fr);
    }
     
  

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
        makeTable();

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
            	
            	// HotelRoom.loadHotelData();
            	// Customer.loadCustomerData();
            	 System.out.println(HotelRoom.numAvailLux());
            	 System.out.println(HotelRoom.numAvailReg());
                 ThisWindow.setVisible(false);
                 makeReservation reservationWindow = new makeReservation();
                 
            }
        }
    }
}
