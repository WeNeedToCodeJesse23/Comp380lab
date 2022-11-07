//package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class SearchWindow extends JFrame {
	private static final long serialVersionUID = 1L;
    JFrame ThisWindow;
    JButton backspace;
    JButton MakeReservationButton;
    public int RoomSelected;
    public void makeTable(){
        ArrayList<HotelRoom> testy = HotelRoom.ReturnCollection();

        Stream<HotelRoom> spet = testy.stream();
        Spliterator<HotelRoom> sptr = spet.spliterator();

        //make the table
        String Column[] = {"Room","Room Status","Room Type","Number of Beds"};
        DefaultTableModel DataTable = new DefaultTableModel(Column,0);
        sptr.forEachRemaining((n) -> DataTable.addRow(new Object[]{n.getRoomID(), n.getRoomStatus(),n.getRoomType(), n.getNumberOfBeds()}));
        // sptr.forEachRemaining((n) -> System.out.println(n)); //test to print out the data stored in HotelRoom in console.

        JTable DeTable = new JTable(DataTable);

        DeTable.setPreferredScrollableViewportSize(new Dimension(600,900));
        DeTable.setFillsViewportHeight(true);
        DeTable.setDefaultEditor(Object.class, null);


        JScrollPane fr = new JScrollPane(DeTable);


        fr.setBounds(300,10,700,700);
        fr.setVisible(true);
        ThisWindow.add(fr);
        //

        //selector
        DeTable.setCellSelectionEnabled(true);
        DeTable.setRowSelectionAllowed(true);
        ListSelectionModel userPick = DeTable.getSelectionModel();
        userPick.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionListener plzwork = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selection = DeTable.getSelectedRow();
                 System.out.println("selected " + (selection + 1));
                 RoomSelected = selection;
            }
        };

        //
        userPick.addListSelectionListener(plzwork);

    }

     
  

    public SearchWindow(){
    	ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
        MakeReservationButton = new JButton("Make Reservation");
         backspace.setBounds(20, 25, 150, 40);
        MakeReservationButton.setBounds(20, 80, 150, 40);

        ThisWindow.setSize(10000, 10000);
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
            	 if(HotelRoom.ReturnCollection().get(RoomSelected).getRoomStatus() == false){
                    // Customer.loadCustomerData();
                    System.out.println("selected room: " + HotelRoom.ReturnCollection().get(RoomSelected));
                    System.out.println(HotelRoom.numAvailLux());
                    System.out.println(HotelRoom.numAvailReg());
                    ThisWindow.setVisible(false);
                    makeReservation reservationWindow = new makeReservation(RoomSelected);//add parameter for room Selected
                    ThisWindow.dispose();
                    
            	 } else {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"This Room is Not Available");
                }

                 
            }
        }
    }
}
