
/**
* <h1>Main</h1>
* The Main class and main class function boot starts the main GUI class
* The Gui Class is the mainframework to the project
* 
* <p>
* <b>Note:</b> 
*
* @author  Jesse Cruz, Omar Garcia
* @version 1.0
* @since   2022-10-01
*/

public class Main{
	   /**
	    * This is the main method it calls the function to load the saved data in to the object types array.
	    * Calls the main GUi class that accesses all other classes.
	   * @param numA This is the first paramter to addNum method
	   * @param numB  This is the second parameter to addNum method
	   * @return nothing
	   */
    public static void main(String[] args) {              
    	HotelRoom.loadHotelData();
       	Customer.loadCustomerData();
       	manager.loadManagerData();
        GUI test = new GUI();
        test.createAndShowGUI();
    }


}
