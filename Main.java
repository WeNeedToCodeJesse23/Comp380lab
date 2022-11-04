 //package com.company;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.*;


public class Main{
	
    public static void main(String[] args) {              //has a connection to sql database //loads data when launch
	HotelRoom.loadHotelData();
       // Customer.loadCustomerData();
        GUI test = new GUI();
        test.createAndShowGUI();
    }


}
