//import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return int
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

        oneStar.setBounds(300,25,150,40);
        twoStar.setBounds(350,25,150,40);
        threeStar.setBounds(400,25,150,50);
        fourStar.setBounds(450,25,150,40);
        fiveStar.setBounds(500,25,150,40);
        backspace.setBounds(250, 400, 150, 40);

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
        
        
    }

    private class myActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                rateWindow.setVisible(false);
                SearchWindow tryme = new SearchWindow();
               
            }
        }
     
    }

}