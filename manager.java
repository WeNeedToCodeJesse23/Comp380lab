import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Manager
 * @author Alondra, Jaztin, Omar, Jesse  Nov. 3, 2022
 * The manager class will check to see if the user who logs in is a manager or not.
 * After logging in it will check to see if the user is a manager, if they are granted access to generate reports, check cancelled rooms, etc.
 * If the user is not a manager they will not be granted manager access.
 * An important function would be txtinput because it allows all of our data to be read and saved.
 */

public class manager {
    private String name;
    private String password;
    private int managerId;
    private static ArrayList<manager> managerList = new ArrayList<manager>();
    private static ArrayList<HotelRoom> availableRoomList = new ArrayList<HotelRoom>();
    private static ArrayList<HotelRoom> occupiedRoomList = new ArrayList<HotelRoom>();
    private static ArrayList<Customer> cancelledList = new ArrayList<Customer>();

    public manager(String name, String password, int managerId)
    {	
    	this.name = name;
    	this.password = password;
    	this.managerId = managerId;
    }
    
    
    /** 
     * @return String
     * getName will get manager name and return the name
     */
    public String getName() {
        return name;
    }
    
    /** 
     * @param name
     * setName will set the entered name as username
     */
    public void setName(String name){
        this.name = name;
    }
    
    /** 
     * @return String
     * getPassword will receive user input for desired password
     */
    public String getPassword() {
        return password;
    }
    
    /** 
     * @param password
     * setPassword will set user inputs password as account password
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /** 
     * @return int
     * getManagerId will receive input on managerID
     */
    public int getManagerId(){
        return managerId;
    }
    
    /** 
     * @param managerId
     * setManagerID will set users managerID
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    
	
    /** 
     * @param Name
     * @param pw
     * @return int
     * checkPass will check if user input is a valid password if it is it will allow login otherwise login not allowed.
     */
    public static int CheckPass(String Name, String pw){
        for(int i = 0; i< managerList.size(); i++){
            if((managerList.get(i).getName().equals(Name)) && (managerList.get(i).getPassword().equals(pw)) ) {
                return i;
            }
        }
        return -1;
       }

	public static void loadManagerData() { //Invalid method declaration; return type required //ArrayList<HotelRoom> -> void    
		String name;
		String password;
		int managerId;
        
        Scanner txtInput = null;
        try
	    {
	       txtInput = new Scanner(new File("Managers.txt"));
	       txtInput.useDelimiter(",");
	    }
	    catch(FileNotFoundException e)
	    {
	       System.out.println("Did you forget the input file?");
	       System.exit(1);
	    } //setting up getting input from txt file
	    
        while(txtInput.hasNextLine() == true)
        {
        	String managerInfo = txtInput.nextLine();
        	String[] managerInfoArray = managerInfo.split(",");
        	name = managerInfoArray[0];
    		password = managerInfoArray[1];
    		managerId = Integer.parseInt(managerInfoArray[2]);
    		
        	manager managerInst = new manager(name, password, managerId);
        	managerList.add(managerInst);
        	//System.out.println(customerList);
        }
      //return roomList; 
    }

	
    /** 
     * @return ArrayList<manager>
     * This will get a list of managers
     */
    public static ArrayList<manager> getManagerList()
	{
		return managerList;
	}

	
    /** 
     * @return ArrayList<HotelRoom>
     * This will get a list of available rooms in hotel.
     */
    public static ArrayList<HotelRoom> getAvailRoomList()
	{
		return availableRoomList;
	}
	
	
    /** 
     * @return ArrayList<HotelRoom>
     * This will grab a list of occupied rooms within the hotel
     */
    public static ArrayList<HotelRoom> getOccuRoomList()
	{
		return occupiedRoomList;
	}

	
    /** 
     * @return ArrayList<Customer>
     * This will grab a list of cancelled rooms within the hotel.
     */
    public static ArrayList<Customer> getCancelledList()
	{
		return cancelledList;
	}
	
	public static void fillAvailList()
	{
		for(int counter = 0; counter < HotelRoom.getCurrentRoomList().size(); counter++)
		{
			if(HotelRoom.getCurrentRoomList().get(counter).getRoomStatus() == false)
			{
				availableRoomList.add(HotelRoom.getCurrentRoomList().get(counter));
			}
		}
	}
	public static void fillOccuList()
	{
		for(int counter = 0; counter < HotelRoom.getCurrentRoomList().size(); counter++)
		{
			if(HotelRoom.getCurrentRoomList().get(counter).getRoomStatus() == true)
			{
				occupiedRoomList.add(HotelRoom.getCurrentRoomList().get(counter));
			}
		}
	}
	
	public static void writeCancelledList()
	{
		String data;
        try
        {
            PrintWriter pw = new PrintWriter(new File("CancelledList.txt"));
            for(int counter = 0; counter < cancelledList.size(); counter++)
            {
                data = cancelledList.get(counter).toString();
            //    System.out.println(hotelData);
                pw.write(data);
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
     * @param list
     * This will be able to generate this list of chosen data.
     */
    public static <T> void exportList(ArrayList<T> list)
	{
		String data;
        try
        {
            PrintWriter pw = new PrintWriter(new File("Report.csv"));
            for(int counter = 0; counter < list.size(); counter++)
            {
                data = list.get(counter).toString();
            //    System.out.println(hotelData);
                pw.write(data);
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
	
}