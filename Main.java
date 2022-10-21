package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main extends JFrame {
    JFrame main;
    JFrame Search;
    JFrame viewRegister;
    JFrame register;
    JFrame ChangeRoom;
    JFrame RateRoom;
    JFrame hotelLogin;

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
         register = new JFrame("cancel");
         ChangeRoom = new JFrame("change room");
         hotelLogin = new JFrame("Login");
         RateRoom = new JFrame("Rate");

        main.setSize(700,500);
        Search.setSize(700,500);
        //viewRegister.setSize(700,500);
        register.setSize(700,500);
        ChangeRoom.setSize(700,500);
        hotelLogin.setSize(700,500);

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
        ReturnMenu.setBounds(10,50,150,40);

        main.add(Make);
        //main.add(View);
        main.add(Cancel);
        main.add(Rate);
        main.add(Change);
        main.add(ReturnMenu);

        main.setLayout(new FlowLayout());
        Search.setLayout(new FlowLayout());
        //viewRegister.setLayout(new FlowLayout());
        register.setLayout(new FlowLayout());
        ChangeRoom.setLayout(new FlowLayout());
        hotelLogin.setLayout(new FlowLayout());

        main.setVisible(true);
        Search.setVisible(false);
       // viewRegister.setVisible(false);
        register.setVisible(false);
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

//////////For Separate Windows Portion now//////



    }

    public static void main(String[] args) {
        Main test = new Main();
        test.createAndShowGUI();

//        Make.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent a) {
//                 main.setVisible(false);
//                 hotelLogin.setVisible(true);
//            }
//        });

    }

    private class myActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Make) {
                main.setVisible(false);
                Search.setVisible(true);
            } else if (event.getSource() == ReturnMenu){
                main.setVisible(false);
                hotelLogin.setVisible(true);
            } else if (event.getSource() == Cancel){
                main.setVisible(false);
                register.setVisible(true);
            } else if (event.getSource() == Rate){
                main.setVisible(false);
            } else if (event.getSource() == Change) {
                main.setVisible(false);
                ChangeRoom.setVisible(true);
            }
        }

        public void actionPerformedCase1 (ActionEvent event){


        }

    }
}
