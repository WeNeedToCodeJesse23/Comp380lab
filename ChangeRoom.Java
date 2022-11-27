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
public class ChangeRoom extends TableGUIWindow {
    
      /**
        * is going to store the user data location of current user in the customer database collection
        */
    public int currentLocation;

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
