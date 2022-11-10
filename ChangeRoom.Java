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

public class ChangeRoom {
    JFrame ThisWindow;
    JButton backspace;
    JButton ChangeReservation;
    public int RoomSelected;
    public int currentLocation;


    public void makeTable(){
        ArrayList testy = HotelRoom.ReturnCollection();

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

    ChangeRoom(int cRoom){
        this.currentLocation = cRoom;
        ThisWindow = new JFrame("search");
        backspace = new JButton("Back Space");
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

                    HotelRoom.UpdateRoomStatus(RoomSelected + 1);
                    HotelRoom.UpdateRoomStatus(Customer.getCurrentCustomerList().get(currentLocation).getRoomID());
                    Customer.ChangeRoom(currentLocation,RoomSelected + 1);

                   // System.out.println("selected room: " + HotelRoom.ReturnCollection().get(RoomSelected).getRoomID());
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
