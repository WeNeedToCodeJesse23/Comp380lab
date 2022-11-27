package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * grabs info from Hotel Class and displays a table off that information.
 * makes a selection listener so it takes in user selection of Rooms
 * adds a scroller for the table to navigate the table
 * It is going to store the user Room selection so it can pass it on to make the Reservation
 *
 */

public class TableGUIWindow {
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
     * If it is,it is going to call reservationWindow where it calls RoomSelected as a parameter and transfer RoomSelected data in reservation
     * it is going to then dispose of this window
     * If the room isn't available, the program will tell you that you can't proceed because the room is taken
     */
    JButton MakeReservationButton;

    /**
     * Going to store the user selected Room
     */
    public int RoomSelected;

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
                // System.out.println("selected " + (selection + 1));
                RoomSelected = selection;
            }
        };

        //
        userPick.addListSelectionListener(plzwork);

    }

}
