import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
/**
* <h1>Main</h1>
*The Customer class is used to keep track of the customer info
*Customer class knew what room a custoemr had and their Customer ID for logging in
*Customer class kept basic info of customer
* 
* <p>
* <b>Note:</b> 
*
* @author  Jesse Cruz, Jaztin Tabunda , Omar Garcia, Alondra Sanchez
* @version 1.0
* @since   2022-10-15
*/

public class Customer {
	
	private String name; //login username
	private String address;
	private String email;
	private String cardNumber;
	private int custID;  //login password
	private int roomID;
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	private String pass; //idk if we'll be needing this because the login password will be customerID
	
	private String checkin;
	  /**
	    * Customer Constructor everything necessary to create a customer
	    * saves the date the customer checks in
	   * @param name Customers name
	   * @param address Customers address
	   * @param email customers email
	   * @param cardNumber Customers Credit card number
	   * @return nothing
	   */

	public Customer(String name, String address, String email, String cardNumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		this.custID = 1;
		this.roomID = 1;
		//for loop to make sure no repeated customerIDs
		
		checkin = LocalDate.now().toString();
		for(int counter = 0; counter < customerList.size(); counter++)
		{
			if(custID == customerList.get(counter).custID)
			{
				custID = 1 + (int)(Math.random() * ((Integer.MAX_VALUE - 1) + 1));
			}
		}
		//for loop to make sure no repeated roomIDs
		for(int counter = 0; counter < customerList.size(); counter++)
		{
			if(roomID == customerList.get(counter).roomID)
			{
				this.roomID = 1 + (int)(Math.random() * ((80 - 1) + 1));
			}
		}
		       
	        pass = String.valueOf(custID);
		
	}
	  /**
	    * Creates the customer
	   * @param name Customers name
	   * @param address Customers address
	   * @param email customers email
	   * @param cardNumber Customers Credit card number
	   * @param custID sets the customer id
	   * @param roomID sets the room id
	   * @param checkin sets check in date
	   * @return nothing
	   */

	public Customer(String name, String address, String email, String cardNumber, int custID, int roomID, String checkin)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		this.custID = custID;
		this.roomID = roomID;
		this.checkin = checkin;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	  /**
	    * Name and Customerid are checked to make sure theyre dealing with the correct reservation and customer
	   * @param Name Customers name
	   * @param pw Customers ID which is random
	   * @return i returns positive number to allow for login
	   */
	
	public static int CheckPass(String Name, String pw){
        for(int i = 0; i< customerList.size(); i++){
            if((customerList.get(i).getName().equals(Name)) && String.valueOf(customerList.get(i).getCustID()).equals(pw)) {
                return i;
            }
        }
        return -1;
       }
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddy() {
		return address;
	}
	public void setAddy(String address) {
		this.address = address;
	}
	public String getEmaddy() {
		return email;
	}
	public void setEmaddy(String email) {
		this.email = email;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	public static ArrayList<Customer> getCurrentCustomerList()
	{
		return customerList;
	}
	  /**
	    * Clears the customer array list object type
	   * @return void 
	   */
	public static void clearCustomerList()
	{
		customerList.clear();
	}
	
	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	  /**
	    * Uses the file "CurrentCustomers.txt" to fill the customer arraylist of the customer object type.
	    * Function loaded up in the beginning of the project so the data is accessible to the appropriate customer and or manager.
	    * while loop cehcks each line of the text file for data and is broken up into pieces into the proper value data.
	   * @return void
	   */

	
	public static void loadCustomerData() { //Invalid method declaration; return type required //ArrayList<HotelRoom> -> void    
	      
		String name;
		String address;
		String email;
		String cardNumber;
		String checkin;
		int custID;
		int roomID;
        
        Scanner txtInput = null;
        try
	    {
	       txtInput = new Scanner(new File("CurrentCustomers.txt"));
	       txtInput.useDelimiter(",");
	    }
	    catch(FileNotFoundException e)
	    {
	       System.out.println("Did you forget the input file?");
	       System.exit(1);
	    } //setting up getting input from txt file
	    
        while(txtInput.hasNextLine() == true)
        {
        	String customerInfo = txtInput.nextLine();
        	String[] customerInfoArray = customerInfo.split(",");
        	name = customerInfoArray[0];
    		address = customerInfoArray[1];
    		email = customerInfoArray[2];
    		cardNumber = customerInfoArray[3];	
    		custID = Integer.parseInt(customerInfoArray[4]);
          	roomID = Integer.parseInt(customerInfoArray[5]);
          	checkin = customerInfoArray[6];
        	Customer customerInst = new Customer(name, address, email, cardNumber, custID, roomID, checkin);
        	customerList.add(customerInst);
        	//System.out.println(customerList);
        }
      //return roomList; 
    }
	  /**
	    * adds a customer type to the customer array list
	   * @return void
	   */
	public static void addToList(Customer userInfo)
	{
		customerList.add(userInfo);
	}
	 /**
	    * removes a customer type to the customer array list
	   * @return void
	   */
	public static void deleteFromList(Customer userInfo)
	{
		customerList.remove(userInfo);
	}
	 /**
	    * Called to update data on the text file written from the customer array list object type.
	   * @return void
	   */
    public static void writeCustomerData() {
        String customerData;
        try
        {
            PrintWriter pw = new PrintWriter(new File("CurrentCustomers.txt"));
            for(int counter = 0; counter < customerList.size(); counter++)
            {
                customerData = customerList.get(counter).toString();
            //    System.out.println(hotelData);
                pw.write(customerData);
            //  System.out.println("HotelData: " + hotelData);
            }
            pw.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Did you forget the input file?");
            System.exit(1);
        } //setting up getting input from txt file
    }
    /**
	    *Used to print a customer
	   * @return void
	   */
	@Override
	public String toString(){
		String customerFormat =  name +  "," + email + "," + address + "," + cardNumber + "," + custID + "," + roomID +","+ checkin +"\n";
        return customerFormat;
	}
	  /**
	    *deletes a specific customer from the csutomer array list and updates the data
	    *@param id used to find the specific customer with their unique customer ID
	   * @return void
	   */
	public static void delCUS(String id){
		System.out.println(id);
		int i;
		for(i = 0 ; i<customerList.size();i++) {
			if(String.valueOf(customerList.get(i).getCustID()).equals(id)) {
				System.out.println(customerList.get(i).toString());
				customerList.remove(i);
				writeCustomerData();
				
			}
			
		}
	}
	  /**
	    *changes the roomID of the customer
	    *@param location gets room id of the customer
	    *@param newRoom sets newRoom of the customer
	   * @return void
	   */
	public static void ChangeRoom(int location, int newRoom){
       // System.out.println("CHECK THIS RN: " + customerList.get(location).getRoomID() + " AND " + customerList.get(location).getName());
       // System.out.println("New Room = " + newRoom);
        customerList.get(location).setRoomID(newRoom);
       //System.out.println("CHECK THIS RN: " + customerList.get(location).getRoomID() + " AND " + customerList.get(location).getName());

       writeCustomerData();
    }
	  /**
	    *gets the check in date of a specific customer
	    *@param id used to find the specific customer with their unique customer ID
	   * @return String returns the date
	   */
	public static String Checkout(String id){
		
		int i;
		for(i = 0 ; i<customerList.size();i++) {
			if(String.valueOf(customerList.get(i).getCustID()).equals(id)) {
				return customerList.get(i).getCheckin();
				
			}
			
	      

	       
	    }
		return "not found";
	}
	  /**
	    * gets the email of specific customer
	    *@param id used to find the specific customer with their unique customer ID
	   * @return String returns the date
	   */
	public static String findEmail(String id){
		int i;
		for(i = 0 ; i<customerList.size();i++) {
			if(String.valueOf(customerList.get(i).getCustID()).equals(id)) {
				return customerList.get(i).getAddy();
				
			}
	    }
		return "no email found";
	}
}
