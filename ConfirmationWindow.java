import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConfirmationWindow {
	
	private String name; //login username
	private String address;
	private String email;
	private String cardNumber;
	private int custID;  //login password
	private int roomID;
	
	JFrame conWindow;
	JPanel panel;
	
	JLabel nameLabel; //login username
	JLabel addressLabel;
	JLabel emailLabel;
	JLabel cardNumberLabel;
	JLabel custIDLabel;  //login password
	JLabel roomIDLabel;
	
	public ConfirmationWindow(Customer userInfo)
	{
		name = userInfo.getName();
		address = userInfo.getAddy();
		email = userInfo.getEmaddy();
		cardNumber = userInfo.getCardNumber();
		custID = userInfo.getCustID();
		roomID = userInfo.getRoomID();
	}
	
    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             /*if () {
                
             }*/
        }
    }
}
