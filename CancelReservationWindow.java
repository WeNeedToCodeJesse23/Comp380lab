import javax.swing.*;  

public class CancelReservationWindow {
	
	JFrame cancelFrame;
	
	CancelReservationWindow()
	{
		cancelFrame = new JFrame("Cancel Reservation");
		JButton d =new JButton("Cancel Reservation");
		d.setBounds(350,25,150, 40);
		cancelFrame.add(d);
		
		cancelFrame.setSize(700,500);//400 width and 500 height  
		cancelFrame.setLayout(null);//using no layout managers  
		cancelFrame.setVisible(true);//making the frame visible  
	}
	
	public static void main(String[] args) {
		
		CancelReservationWindow window = new CancelReservationWindow();
	}
	
}
