import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GenReportWindow {
	
	int luxury = HotelRoom.numAvailLux();
	int regular = HotelRoom.numAvailReg();
	
	JFrame GenWindow = new JFrame();
	JPanel panel = new JPanel();
	
	JButton GuestListButton = new JButton("Guest List");
	JButton ListOfCancelled = new JButton("List of Cancelled");
	JButton ListOfAvailable = new JButton("List of Available");
	JButton ListOfOccupied = new JButton("List of Occupied");
	JButton Home = new JButton("Main Menu");
	
	JLabel windowTitle = new JLabel("Generate a Report");
	JLabel availLux = new JLabel("Number of Available Luxury Rooms: " + luxury);
	JLabel availReg = new JLabel("Number of Available Regular Rooms: " + regular);
	
	myActionListener listener = new myActionListener();
	
	public GenReportWindow(int key)
	{
		GenWindow.setSize(700, 500);
        panel.setLayout(null);
        GenWindow.add(panel);
        
        Home.setBounds(250, 400, 150, 40);
        GuestListButton.setBounds(100, 200, 150, 40);
        ListOfCancelled.setBounds(100, 300, 150, 40);
        ListOfAvailable.setBounds(350, 200, 150, 40);
        ListOfOccupied.setBounds(350, 300, 150, 40);
        
        windowTitle.setBounds(10, 25, 500, 25);
        availLux.setBounds(350, 25, 500, 25);
        availReg.setBounds(350, 75, 500, 25);
        
        panel.add(windowTitle);
        panel.add(availLux);
        panel.add(availReg);
        panel.add(Home);
        panel.add(GuestListButton);
        panel.add(ListOfCancelled);
        panel.add(ListOfAvailable);
        panel.add(ListOfOccupied);
        
        GenWindow.setVisible(true);
        Home.addActionListener(listener);
        GuestListButton.addActionListener(listener);
        ListOfCancelled.addActionListener(listener);
        ListOfAvailable.addActionListener(listener);
        ListOfOccupied.addActionListener(listener);
	}
	
    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if(event.getSource() == Home) {
            	 GenWindow.setVisible(false);
                 GUI gui = new GUI();
                 gui.createAndShowGUI();
                 GenWindow.dispose();
             }
             else if(event.getSource() == GuestListButton)
             {
            	 manager.exportList(Customer.getCurrentCustomerList());
             }
             else if(event.getSource() == ListOfCancelled)
             {
            	 manager.exportList(manager.getCancelledList());
             }
             else if(event.getSource() == ListOfAvailable)
             {
            	 manager.fillAvailList();
            	 manager.exportList(manager.getAvailRoomList());
             }
             else if(event.getSource() == ListOfOccupied)
             {
            	 manager.fillOccuList();
            	 manager.exportList(manager.getOccuRoomList());
             }
        }
    }
	
}
