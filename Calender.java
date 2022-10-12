import java.util.Scanner;

public class Calender {


   public static void months (int totalDays, int startday){
           int blankdays = startday - 1;

        for (int currentDay = -(blankdays) + 1; currentDay < totalDays + 1; currentDay++) {

             String c = "  ";    
            if ( currentDay < 1 ) {
              c = c + " "; 
               System.out.print(c); 
                } else
                 if ( currentDay < 10 ){
                  System.out.print("  " + currentDay); 
                    } else {
                      System.out.print(" " + currentDay);    
                           }                         
         if ( ( (currentDay + blankdays) % 7 == 0 ) &&  ((currentDay + blankdays) != 0) ) {
                System.out.println(); 
         }            
      }
   }                                 

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
         System.out.println("Please enter number of days of the month"); 
      int days = in.nextInt();
          System.out.println("Enter the starting day of the week: 1 = Sun, 7 = Sat:");
      int startday = in.nextInt(); 
   
      System.out.println(); 
      months(days,startday);
   }




}