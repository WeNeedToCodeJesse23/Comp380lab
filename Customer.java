import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private String name; //login username
	private String address;
	private String email;
	private String cardNumber;
	private int custID;  //login password
	private int roomID;
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public Customer(String name, String address, String email, String cardNumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		this.custID = 1;
		this.roomID = 1;
		//for loop to make sure no repeated customerIDs
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
		
	}
	
	public Customer(String name, String address, String email, String cardNumber, int custID, int roomID)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		this.custID = custID;
		this.roomID = roomID;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	private String pass; //idk if we'll be needing this because the login password will be customerID
	
	
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
	
	public ArrayList<Customer> getCurrentCustomerList()
	{
		return customerList;
	}
	
	public static void clearCustomerList()
	{
		customerList.clear();
	}
	
	public static void loadCustomerData() { //Invalid method declaration; return type required //ArrayList<HotelRoom> -> void    
	      
		String name;
		String address;
		String email;
		String cardNumber;
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
        	Customer customerInst = new Customer(name, address, email, cardNumber, custID, roomID);
        	customerList.add(customerInst);
        	//System.out.println(customerList);
        }
      //return roomList; 
    }
	
	public static void addToList(Customer userInfo)
	{
		customerList.add(userInfo);
	}
	
	public static void deleteFromList(Customer userInfo)
	{
		customerList.remove(userInfo);
	}
	
    public static void writeCustomerData() {
        String customerData;
        try
        {
            PrintWriter pw = new PrintWriter(new File("CurrentCustomers(test).txt"));
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
	
	@Override
	public String toString(){
		String customerFormat =  name +  "," + email + "," + address + "," + cardNumber + "," + custID + "," + roomID + "\n";
        return customerFormat;
	} 

}
