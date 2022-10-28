import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


import java.awt.event.ActionListener;


public class makeReservation extends JFrame {
    JFrame test;
    JButton backspace;  

    public makeReservation(){
    	test = new JFrame("reserve");
        backspace = new JButton("Back Space");
   
        
        test.setSize(700,500);
        test.setLayout(null);
       // Search.setLayout(null);
        backspace.setBounds(50,50, 50, 50);

        test.setVisible(true);
        test.add(backspace);
        backspace.setVisible(true);
      
        myActionListener Dothis = new myActionListener();
        backspace.addActionListener(Dothis);
    }
    private class myActionListener implements ActionListener {

        //Button actions
        public void actionPerformed(ActionEvent event) {
             if (event.getSource() == backspace) {
                test.setVisible(false);
                SearchWindow tryme = new SearchWindow();
               
            }
        }


     
    }
}

	//Button actions
 


 
