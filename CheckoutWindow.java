import javax.swing.*;

//import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import java.awt.event.ActionListener;
/**
* <h1>Cancel</h1>
*The Cancel class was served to cancel a reservation but it is now used to checkout from your reservation.
*Prompts user for some customer info and removes them from the customer list and sets the room to available.
*Displays a message after the Customer Successfully checks out.
* 
* <p>
* <b>Note:</b> 
*
* @author  Jesse Cruz, Jaztin Tabunda, Omar Garcia
* @version 2.0
* @since   2022-10-30
*/

public class CheckoutWindow {
	
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
	   /**
	    * Build the Check Out window
	    * Implements the action listener for two buttons.
	    * backspace button takes customer back to the main GUI
	    * cancel button gets todays date to estimate how many days the customer stayed in ordere to calculate an estimate.
	    * cancel button calls functions to remove unnecessary data.
	    * cancel button calls function to open a room for checking in
	    * cancel button shows user a quick summary of their stay.
	   * @param key used to access the Cancel Gui class after the customer logs in
	   * @return nothing
	   */

	
	public CheckoutWindow(int key)
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
            	// String sDate1=Customer.Checkout(custIDfld.getText()); 
            	 LocalDate before = LocalDate.parse(Customer.Checkout(custIDfld.getText()));
            	 LocalDate now = LocalDate.now();
            	 long nod = ChronoUnit.DAYS.between(before, now);
				 System.out.println(nod);
   
				 String roomtype = HotelRoom.getCurrentRoomList().get(Integer.parseInt(rumIDfld.getText())-1).getRoomType();
				 System.out.println(roomtype);
//            	 Customer.delCUS(custIDfld.getText());
//            	 HotelRoom.openRum(rumIDfld.getText());
				 String emaddy = Customer.findEmail(custIDfld.getText());
				 Integer noddy = (int) (long) nod;
				 int tot;
				 if(roomtype.equals("Regular")) {
					 tot = noddy*50;
				 }
				 else {
					 tot = noddy*90;
				 }
            	 
				 JOptionPane.showMessageDialog(null, "Payment processed\n"+"Your total for a "+roomtype+" room will be: $"+tot
						 +"\nNumber of days Stayed: "+nod+"\n Reciept sent to: "+emaddy);
             	 Customer.delCUS(custIDfld.getText());
            	 HotelRoom.openRum(rumIDfld.getText());
            	
            	 cancelFrame.dispose();
                 GUI goBack = new GUI();
                 goBack.createAndShowGUI();
      
             }
        }
    }
	
	
	
}


