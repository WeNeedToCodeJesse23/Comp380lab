//package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Spliterator;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Date: October 28, 2022
 *
 * Description
 * Search Window opens up the Search menu where you search for Rooms you are looking for and displaying the ones that are unavailable
 * Then you can go ahead and make a reservation with the selected Room
 * @author omarg,
 *
 */
public class SearchWindow extends TableGUIWindow {
    private static final long serialVersionUID = 1L;
    

    /**
     * creates search window GUI
     * Adds the frame as well as the buttons in this window and sets position of the buttons
     * Call the table method to display the table
     * adds action listeners to buttons so it can respond to user input
     *
     */
    public SearchWindow(){
        ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
        MakeReservationButton = new JButton("Make Reservation");
        ThisWindow.getContentPane().setBackground(Color.darkGray);

        backspace.setBounds(20, 25, 150, 40);
        MakeReservationButton.setBounds(20, 80, 150, 40);

        ThisWindow.setSize(1100, 800);
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
                if(!HotelRoom.ReturnCollection().get(RoomSelected).getRoomStatus()){
                    ThisWindow.setVisible(false);
                    makeReservation reservationWindow = new makeReservation(RoomSelected); //add parameter for room Selected
                    ThisWindow.dispose();
                } else {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"This Room is Not Available");
                }

            }
        }

    }
}

