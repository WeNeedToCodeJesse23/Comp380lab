//package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * November 9, 2022
 * Description:
 * Class is going to Change the Room of the user. Displays current Rooms available and Rooms not available
 * @author omarg
 */
public class ChangeRoom {

    /**
     * makes main Window for this class
     */
    JFrame ThisWindow;

    /**
     * backspace button -
     * In actionPerformed() method, if this button is hit, it is going to return back to the
     * last window opened, which was the GUI home screen menu. It will also dispose of this window
     */
    JButton backspace;

    /**
     * Changes the Reservation button
     * In actionPerformed() method, if this button is hit, it is going to first check if the selected room  is available.
     * If it is,it is going to call updateRoomStatus twice for the old Room and the New one
     * Once both Room status has been updated, it is going to call ChangeRoom in Customer.java which will change the User Room in the collection to the new one
     * It finally displays dialog that it changed the room
     * If the room isn't available, the program will tell you that you can't proceed because the room is taken
     *
     */
    JButton ChangeReservation;

    /**
     * Going to store the user selected Room
     */
    public int RoomSelected;

    /**
     * is going to store the user data location of current user in the customer database collection
     */
    public int currentLocation;

    /**
     * grabs info from Hotel Class and displays a table off that information.
     * makes a selection listener so it takes in user selection of Rooms
     * adds a scroller for the table to navigate the table
     * It is going to store the user Room selection so it can pass it on to make the Reservation
     *
     */
    public void makeTable(){
        ArrayList testy = HotelRoom.ReturnCollection();

        Stream<HotelRoom> spet = testy.stream();
        Spliterator<HotelRoom> sptr = spet.spliterator();

        //make the table
        String Column[] = {"Room","Room Occupied","Room Type","Number of Beds"};
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

    /**
     * ChangeRoom is going to make up the ChangeRoom window
     * it's going to make the frames and the buttons and display it
     * it's also going to set the position of the buttons
     * It will call the method Table() to display the table for the window
     * Add action listeners to the buttons to respond to user input
     * @param cRoom
     * cRoom is going to store the user data location of current user in the customer database collection
     */
    ChangeRoom(int cRoom){
        this.currentLocation = cRoom;
        ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
        ThisWindow.getContentPane().setBackground(Color.darkGray);
        ChangeReservation = new JButton("Make Reservation");
        backspace.setBounds(20, 25, 150, 40);
        ChangeReservation.setBounds(20, 80, 150, 40);

        ThisWindow.setSize(10000, 10000);
        ThisWindow.setLayout(null);
        ThisWindow.setVisible(true);

        ThisWindow.add(ChangeReservation);
        ThisWindow.add(backspace);
        backspace.setVisible(true);
        ChangeReservation.setVisible(true);
        ThisWindow.setVisible(true);


        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
        ChangeReservation.addActionListener(Dothis);
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
            } if(event.getSource() == ChangeReservation){
                if(!HotelRoom.ReturnCollection().get(RoomSelected).getRoomStatus()){

//                    System.out.println("Old: " + RoomSelected + 1);
//                    System.out.println("new: " + Customer.getCurrentCustomerList().get(currentLocation).getRoomID());

                    HotelRoom.UpdateRoomStatus(RoomSelected + 1);
                    HotelRoom.UpdateRoomStatus(Customer.getCurrentCustomerList().get(currentLocation).getRoomID());
                    Customer.ChangeRoom(currentLocation,RoomSelected + 1);

                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Room has been changed \n" + " Your New Room: " + HotelRoom.ReturnCollection().get(RoomSelected).getRoomID() + " " );
                    ThisWindow.setVisible(false);
                    GUI goBack = new GUI();
                    goBack.createAndShowGUI();
                    ThisWindow.dispose();
                } else {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"This Room is Not Available");
                }

            }
        }

    }

}
