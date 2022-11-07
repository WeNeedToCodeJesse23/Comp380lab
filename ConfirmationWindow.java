import java.awt.event.ActionListener;
import java.util.Locale;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

//import makeReservation.myActionListener;

public class ConfirmationWindow {
	
	private Font testFont = new Font("Harlow Solid Italic", Font.PLAIN, 20);
	
	private String name; //login username
	private String address;
	private String email;
	private String cardNumber;
	private int custID;  //login password
	private int roomID;
	
	JFrame conWindow;
	JPanel panel;
	
	JLabel windowTitle;
	JLabel nameLabel; //login username
	JLabel addressLabel;
	JLabel emailLabel;
	JLabel cardNumberLabel;
	JLabel custIDLabel;  //login password
	JLabel roomIDLabel;
	
	JButton home;
	myActionListener listener = new myActionListener();
	
	public ConfirmationWindow(Customer userInfo)
	{
		conWindow = new JFrame();
		panel = new JPanel();
		home = new JButton("Home");
		
		name = userInfo.getName();
		address = userInfo.getAddy();
		email = userInfo.getEmaddy();
		cardNumber = userInfo.getCardNumber();
		custID = userInfo.getCustID();
		roomID = userInfo.getRoomID();
		
		conWindow.setSize(700, 500);
        panel.setLayout(null);
        conWindow.add(panel);
        
        windowTitle = new JLabel("ROOM RESERVED! ");
        windowTitle.setFont(testFont);
        nameLabel = new JLabel("Name: " + name);
        addressLabel = new JLabel("Address: " + address);
        emailLabel = new JLabel("Email: " + email);
        cardNumberLabel = new JLabel("Card Number: " + cardNumber);
        custIDLabel = new JLabel("Customer ID / Password: " + custID);
        roomIDLabel = new JLabel("Assigned Room: " + roomID);
		
		home.setBounds(500, 350, 150, 40);
		
		windowTitle.setBounds(10, 25, 500, 25);
        nameLabel.setBounds(10, 75, 500, 25);
        addressLabel.setBounds(10, 125, 500, 25);
        emailLabel.setBounds(10, 175, 500, 25);
        cardNumberLabel.setBounds(10, 225, 500, 25);
        custIDLabel.setBounds(10, 275, 500, 25);
        roomIDLabel.setBounds(10, 325, 500, 25);
		
		panel.add(home);
		panel.add(nameLabel);
		panel.add(addressLabel);
		panel.add(emailLabel);
		panel.add(cardNumberLabel);
		panel.add(custIDLabel);
		panel.add(roomIDLabel);
		panel.add(windowTitle);
		
		conWindow.setVisible(true);
		home.addActionListener(listener);
		
	}
	
    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if(event.getSource() == home) {
            	 conWindow.setVisible(false);
                 GUI gui = new GUI();
                 gui.createAndShowGUI();
                 conWindow.dispose();
             }
        }
    }
}
