import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class rateReservation extends JFrame{
    JFrame test;
    JButton backspace;
    
    private String name;
    private int confirmationNum;

    public String getName() {
        return name;
    }

    public int getConfirmationNum(){
        return confirmationNum;
    }

    public rateReservation(){
        test = new JFrame("Rate");
        backspace = new JButton("Back Space");
   
        
        test.setSize(700,500);
        test.setLayout(null);
        backspace.setBounds(50,50, 50, 50);
        // fix backspace bounds probably
        test.setVisible(true);
        test.add(backspace);
        backspace.setVisible(true);

        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
    }

    private class myActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                test.setVisible(false);
                SearchWindow tryme = new SearchWindow();
               
            }
        }


     
    }

}