import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import ReviewReservationWindow.myActionListener;

public class ReviewReservationWindow {
	private Font testFont = new Font("Harlow Solid Italic", Font.PLAIN, 20);
	
	private String name; //login username
	private String address;
	private String email;
	private String cardNumber;
	private int roomID;
	private Customer userInfo;
	
	JFrame reviewWindow;
	JPanel panel;
	
	JLabel windowTitle;
	JLabel nameLabel; //login username
	JLabel addressLabel;
	JLabel emailLabel;
	JLabel cardNumberLabel;
	JLabel roomIDLabel;
	
	JButton confirm;
	JButton changeRoom;
	JButton changeInfo;
	myActionListener listener = new myActionListener();
	
	public ReviewReservationWindow(Customer userInfo)
	{
		this.userInfo = userInfo;
		reviewWindow = new JFrame();
		panel = new JPanel();
		confirm = new JButton("Confirm");
		changeRoom = new JButton("Change Room");
		changeInfo = new JButton("Change Details");
		
		name = userInfo.getName();
		address = userInfo.getAddy();
		email = userInfo.getEmaddy();
		cardNumber = userInfo.getCardNumber();
		roomID = userInfo.getRoomID();
		
		reviewWindow.setSize(700, 500);
        panel.setLayout(null);
        reviewWindow.add(panel);
        
        windowTitle = new JLabel("Please Review Reservation Information");
        windowTitle.setFont(testFont);
        nameLabel = new JLabel("Name: " + name);
        addressLabel = new JLabel("Address: " + address);
        emailLabel = new JLabel("Email: " + email);
        cardNumberLabel = new JLabel("Card Number: " + cardNumber);
        roomIDLabel = new JLabel("Assigned Room: " + roomID);
		
		changeInfo.setBounds(200, 350, 150, 40);
		changeRoom.setBounds(350, 350, 150, 40);
		confirm.setBounds(500, 350, 150, 40);
		
		windowTitle.setBounds(10, 25, 500, 25);
        nameLabel.setBounds(10, 75, 500, 25);
        addressLabel.setBounds(10, 125, 500, 25);
        emailLabel.setBounds(10, 175, 500, 25);
        cardNumberLabel.setBounds(10, 225, 500, 25);
        roomIDLabel.setBounds(10, 275, 500, 25);
		
		panel.add(confirm);
		panel.add(changeInfo);
		panel.add(changeRoom);
		panel.add(nameLabel);
		panel.add(addressLabel);
		panel.add(emailLabel);
		panel.add(cardNumberLabel);
		panel.add(roomIDLabel);
		panel.add(windowTitle);
		
		reviewWindow.setVisible(true);
		confirm.addActionListener(listener);
		changeInfo.addActionListener(listener);
		changeRoom.addActionListener(listener);
	}
	
    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if(event.getSource() == confirm) {
            	 reviewWindow.setVisible(false);
            	 Customer.addToList(userInfo);
                 HotelRoom.UpdateRoomStatus(userInfo.getRoomID());
            	 Customer.writeCustomerData();
                 HotelRoom.writeHotelData();
                 ConfirmationWindow conWindow = new ConfirmationWindow(userInfo);
                 reviewWindow.dispose();
             }
             else if(event.getSource() == changeInfo)
             {
            	 reviewWindow.setVisible(false);
            	 makeReservation conWindow = new makeReservation(userInfo.getRoomID());
            	 reviewWindow.dispose();
             }
             else //event.getSource == changeRoom
             {
            	 reviewWindow.setVisible(false);
            	 SearchWindow searchWindow = new SearchWindow();
            	 reviewWindow.dispose();
             }
        }
    }
}
