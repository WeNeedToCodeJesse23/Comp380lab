import javax.swing.*;

//import java.awt.*;
import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import java.awt.event.ActionListener;

public class CancelReservationWindow {
	
	JFrame cancelFrame;
	JPanel panel;
	
	JLabel custIDlbl;
	JLabel rumIDlbl;

	JButton backspace;
	JButton cancel;
	    
	JTextField custIDfld;
	JTextField rumIDfld;
    
	myActionListener listener = new myActionListener();
	int CustomerKey;

	
	public CancelReservationWindow(int key)
	{
		CustomerKey = key;
		cancelFrame = new JFrame("Cancel Reservation");
		panel = new JPanel();
	    cancel =  new JButton("Confirm Cancel");
		backspace = new JButton("Main Menu");
		cancel.setBounds(375,200,150, 40);
		backspace.setBounds(175,200,150, 40);
		 
		custIDlbl = new JLabel("Customer ID:");
		rumIDlbl = new JLabel("Room ID:");
		custIDfld = new JTextField(20);
		rumIDfld = new JTextField(20);
		cancelFrame.setSize(700,500);
		panel.setLayout(null);
		
		custIDlbl.setBounds(10, 100, 80, 25);
		rumIDlbl.setBounds(10, 150, 80, 25);
		
		custIDfld.setBounds(100, 100, 500, 25);
		rumIDfld.setBounds(100, 150, 500, 25);
        
        cancelFrame.add(panel);
        
        panel.add(custIDlbl);
        panel.add(rumIDlbl);
        
        panel.add(custIDfld);
        panel.add(rumIDfld);
	
		panel.add(cancel);
		panel.add(backspace);
		//400 width and 500 height  
	
		cancelFrame.setVisible(true);//making the frame visible  
       
		cancel.addActionListener(listener);
        backspace.addActionListener(listener);
	}

    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                cancelFrame.setVisible(false);
              
                cancelFrame.dispose();
                
                GUI goBack = new GUI();
                goBack.createAndShowGUI();
            
             }
             else if(event.getSource() == cancel)
             {
            	 manager.getCancelledList().add(Customer.getCurrentCustomerList().get(CustomerKey));
            	 manager.writeCancelledList();
            	 System.out.println("here");
            	 Customer.delCUS(custIDfld.getText());
            	 HotelRoom.openRum(rumIDfld.getText());
            	 JOptionPane.showMessageDialog(null, "Reservation Canceled");
            	 cancelFrame.dispose();
                 GUI goBack = new GUI();
                 goBack.createAndShowGUI();
      
             }
        }
    }
	
	
	
}
/*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/



