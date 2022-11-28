//import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 * Rate Reservation
 * @author Alondra, Jaztin, Omar, Jesse 
 * Nov 3, 2022
 * Rate Reservation allows customers to give a rating of 1 to 5 stars after logging into their accounts.
 * An important function used was myActionListener which allows for user input on which rating will be given.
 */


public class rateReservation extends JFrame{
    private static final long serialVersionUID = 1L;
    private String name;
    private int confirmationNum;
    
    JPanel panel;
    JFrame rateWindow;
    JButton backspace;
    JButton oneStar;
    JButton twoStar;
    JButton threeStar;
    JButton fourStar;
    JButton fiveStar;
    

    
    /** 
     * @return String
     * getName will get name and return the user name
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return int
     * getConfirmationNum will get user confirmaton number and return that number
     */
    public int getConfirmationNum(){
        return confirmationNum;
    }

    public rateReservation(int width){
        rateWindow = new JFrame();
        panel = new JPanel();
        
        rateWindow.setSize(700, 500);
        panel.setLayout(null);
        rateWindow.add(panel);


        //rateWindow = new JFrame("Rate");
        backspace = new JButton("Back Space");
        oneStar = new JButton("One Star");
        twoStar = new JButton("Two Stars");
        threeStar = new JButton("Three Stars");
        fourStar = new JButton("Four Stars");
        fiveStar = new JButton("Five Stars");

        oneStar.setBounds(25,25,125,40);
        twoStar.setBounds(150,25,125,40);
        threeStar.setBounds(275,25,125,40);
        fourStar.setBounds(400,25,125,40);
        fiveStar.setBounds(525,25,125,40);
        backspace.setBounds(250, 400, 125, 40);

        panel.add(oneStar);
        panel.add(twoStar);
        panel.add(threeStar);
        panel.add(fourStar);
        panel.add(fiveStar);
        panel.add(backspace);
        
        //rateWindow.setLayout(null);
        
        rateWindow.setVisible(true);

        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
        oneStar.addActionListener(Dothis);
        twoStar.addActionListener(Dothis);
        threeStar.addActionListener(Dothis);
        fourStar.addActionListener(Dothis);
        fiveStar.addActionListener(Dothis);
    }

    private class myActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                rateWindow.setVisible(false);
                GUI goBack = new GUI();
                goBack.createAndShowGUI();
                rateWindow.dispose();
               
            }
            else if(event.getSource() == oneStar){
                rateWindow.setVisible(false);
                JFrame Rating = new JFrame();
                JDialog d = new JDialog(Rating,"Rating" );
                JLabel one = new JLabel( "Thank you for your feedback!");
                d.add(one);
                d.setSize(200,100);
                d.setVisible(true);
            	 rateWindow.dispose();
            
            }
            else if(event.getSource() == twoStar){
                rateWindow.setVisible(false);
                JFrame Rating = new JFrame();
                JDialog d = new JDialog(Rating,"Rating" );
                JLabel one = new JLabel( "Thank you for your feedback!");
                d.add(one);
                d.setSize(200,100);
                d.setVisible(true);
            	 rateWindow.dispose();
            
            }
            else if(event.getSource() == threeStar){
                rateWindow.setVisible(false);
                JFrame Rating = new JFrame();
                JDialog d = new JDialog(Rating,"Rating" );
                JLabel one = new JLabel( "Thank you for your feedback!");
                d.add(one);
                d.setSize(200,100);
                d.setVisible(true);
            	 rateWindow.dispose();
            
            }
            else if(event.getSource() == fourStar){
                rateWindow.setVisible(false);
                JFrame Rating = new JFrame();
                JDialog d = new JDialog(Rating,"Rating" );
                JLabel one = new JLabel( "Thank you for your feedback!");
                d.add(one);
                d.setSize(200,100);
                d.setVisible(true);
            	 rateWindow.dispose();
            
            }
            else if(event.getSource() == fiveStar){
                rateWindow.setVisible(false);
                JFrame Rating = new JFrame();
                JDialog d = new JDialog(Rating,"Rating" );
                JLabel one = new JLabel( "Thank you for your feedback!");
                d.add(one);
                d.setSize(200,100);
                d.setVisible(true);
            	 rateWindow.dispose();
            
            }
        }
     
    }

}