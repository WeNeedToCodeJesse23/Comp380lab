import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getManagerId(){
        return managerId;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    
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

	public static ArrayList<manager> getManagerList()
	{
		return managerList;
	}

	public static ArrayList<HotelRoom> getAvailRoomList()
	{
		return availableRoomList;
	}
	
	public static ArrayList<HotelRoom> getOccuRoomList()
	{
		return occupiedRoomList;
	}

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