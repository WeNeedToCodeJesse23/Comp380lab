package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main extends JFrame {
//frames
    JFrame main;
    JFrame Search;
    JFrame viewRegister;
    JFrame CancelRoom;
    JFrame ChangeRoom;
    JFrame RateRoom;
    JFrame hotelLogin;
//buttons
    JButton Make;
    JButton View;
    JButton Cancel;
    JButton Rate;
    JButton Change;
    JButton Login;
    JButton ReturnMenu;


    Main(){

    }

    public void createAndShowGUI () {
         main = new JFrame("Hotel AOJJ");
         Search = new JFrame("search");
        // viewRegister = new JFrame("view register");
         CancelRoom = new JFrame("cancel");
         ChangeRoom = new JFrame("change room");
         hotelLogin = new JFrame("Login");
         RateRoom = new JFrame("Rate");

        main.setSize(700,500);
        Search.setSize(700,500);
        //viewRegister.setSize(700,500);
        CancelRoom.setSize(700,500);
        ChangeRoom.setSize(700,500);
        hotelLogin.setSize(500,500);
        RateRoom.setSize(700,500);

        //main window
        Make = new JButton("Search Reservation");
        //View = new JButton("View Reservation");
        Cancel = new JButton("Cancel Reservation");
        Rate = new JButton("Rate Reservation");
        Change = new JButton("Change Room");
        Login = new JButton("Login menu");
        ReturnMenu = new JButton("Backspace");

        Make.setBounds(50,25,150, 40);
       // View.setBounds(200,25,150, 40);
        Cancel.setBounds(350,25,150, 40);
        Rate.setBounds(400,25,150, 40);
        Change.setBounds(500,25,150, 40);
        Login.setBounds(500,100,150, 40);
        ReturnMenu.setBounds(200,50,150,40);

        main.add(Make);
        //main.add(View);
        main.add(Cancel);
        main.add(Rate);
        main.add(Change);

        main.setLayout(new FlowLayout());
        Search.setLayout(new FlowLayout());
        //viewRegister.setLayout(new FlowLayout());
        CancelRoom.setLayout(new FlowLayout());
        ChangeRoom.setLayout(new FlowLayout());
        hotelLogin.setLayout(new FlowLayout());

        main.setVisible(true);
        Search.setVisible(false);
       // viewRegister.setVisible(false);
        CancelRoom.setVisible(false);
        ChangeRoom.setVisible(false);
        hotelLogin.setVisible(false);

        // Make.addActionListener(this);
        //button Action Listeners

        myActionListener e = new myActionListener();

        Make.addActionListener(e);
       // View.addActionListener(e);
        Cancel.addActionListener(e);
        Rate.addActionListener(e);
        Change.addActionListener(e);
        ReturnMenu.addActionListener(e);

    }

    //add in this window
    public void RateWindow(){
        main.setVisible(false);
        RateRoom.setVisible(true);
        RateRoom.add(ReturnMenu);
    }

    //add in this window
    public void CancelWindow(){
        main.setVisible(false);
        CancelRoom.setVisible(true);
        CancelRoom.add(ReturnMenu);
    }

    //add in this window
    public void searchWindow(){
        main.setVisible(false);
        Search.setVisible(true);
        Search.add(ReturnMenu);
    }

    //add in this window
    public void ChangeWindow(){
        main.setVisible(false);
        ChangeRoom.setVisible(true);
        ChangeRoom.add(ReturnMenu);
    }


    public static void main(String[] args) {
        Main test = new Main();
        test.createAndShowGUI();
    }

    private class myActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Make) {
                searchWindow();
            } else if (event.getSource() == ReturnMenu){
                ReturnToMenuCases(event);
            } else if (event.getSource() == Cancel){
                CancelWindow();
            } else if (event.getSource() == Rate){
               RateWindow();
            } else if (event.getSource() == Change) {
                ChangeWindow();
            }
        }

        public void ReturnToMenuCases (ActionEvent event){
            if ( (RateRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                RateRoom.setVisible(false);
                createAndShowGUI();
            }  else if ((ChangeRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ){
                ChangeRoom.setVisible(false);
                createAndShowGUI();
            } else if ((Search.isVisible() ) && (event.getSource() == ReturnMenu ) ){
                Search.setVisible(false);
                createAndShowGUI();
            } else if ((CancelRoom.isVisible() ) && (event.getSource() == ReturnMenu ) ) {
                CancelRoom.setVisible(false);
                createAndShowGUI();
            }
        }

    }
}

