//package swinging;
import javax.swing.*;  

public class jira {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Hotel AOJJ");
	 
		JButton b=new JButton("Make Reservation");
		b.setBounds(50,25,150, 40);
		f.add(b);
		JButton c=new JButton("View Reservation");
		c.setBounds(200,25,150, 40);
		f.add(c);
		JButton d=new JButton("Cancel Reservation");
		d.setBounds(350,25,150, 40);
		f.add(d);
		JButton e=new JButton("Rate Reservation");
		e.setBounds(500,25,150, 40);
		f.add(e);
		
		
		
		f.setSize(700,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		

	}

}
