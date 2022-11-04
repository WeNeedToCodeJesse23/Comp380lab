import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelRoom {
	
	private int hotelRoomID; //unique hotel ID
	private int numberOfBeds; //numberOfBedrooms
	private boolean reservedStatus;  //true = reserved, false = not reserved
	private String roomType; // luxury or regular
	private static ArrayList<HotelRoom> roomList = new ArrayList<HotelRoom>(); //this list will be the only one throughout
	
	/*private HotelRoom()
	{}*/
	
	public HotelRoom(int roomID, boolean status, String type, int numBed)
	{
		hotelRoomID = roomID;
		reservedStatus = status;
		roomType = type;
		numberOfBeds = numBed;
	}
	
	public int getRoomID()
	{
		return hotelRoomID;
	}
	
	public int getNumberOfBeds()
	{
		return numberOfBeds;
	}
	
	public boolean getRoomStatus()
	{
		return reservedStatus;
	}
	
	public void setReservedStatus(boolean status)
	{
		reservedStatus = status;
	}
	
	public String getRoomType()
	{
		return roomType;
	}
	
	@Override
	public String toString(){
		String roomFormat = "Room: " + hotelRoomID +  "\tReserved: " + reservedStatus + "\tRoomType: " + roomType + "\tNumber Of Beds: " + numberOfBeds;
		return roomFormat;
	}
	
	public ArrayList<HotelRoom> getCurrentRoomList()
	{
		return roomList;
	}
	
	public static void clearRoomList()
	{
		roomList.clear();
	}
	
	//read the text file holding the data
    public static void loadHotelData() { //Invalid method declaration; return type required //ArrayList<HotelRoom> -> void    
      
    	int roomID = 0;
        boolean roomStatus = false;
        String roomType;
        int numberOfRooms = 0;
        //ArrayList<HotelRoom> roomList = new ArrayList<>();
    	
    	// = 0;
        //roomStatus = false;
        //numberOfRooms = 0;
        
        Scanner txtInput = null;
	    
      try
	    {
	       txtInput = new Scanner(new File("RoomReservationTestDataHotelRooms.txt"));
	       txtInput.useDelimiter(",");
	    }
	    catch(FileNotFoundException e)
	    {
	       System.out.println("Did you forget the input file?");
	       System.exit(1);
	    } //setting up getting input from txt file
	    
        while(txtInput.hasNextLine() == true)
        {
        	String roomInfo = txtInput.nextLine();
        	String[] roomArray = roomInfo.split(",");
        	roomID = Integer.parseInt(roomArray[0]);
        	roomStatus = Boolean.parseBoolean(roomArray[1]);
        	roomType = roomArray[2];
          	numberOfRooms = Integer.parseInt(roomArray[3]);
        	HotelRoom room = new HotelRoom(roomID, roomStatus, roomType, numberOfRooms);
        	roomList.add(room);
        	//System.out.println(roomList);
        }
      //return roomList; 
    }
	
	  //The Collection must call LoadData before you can Return the Collection, Otherwise the Data will be returned as empty
    public static ArrayList<HotelRoom> ReturnCollection(){
            return roomList;
    }
	
	
    //write to text file
    public static void writeHotelData()
    {
    }
    
    //check if there are available rooms left for regular rooms
    public static int numAvailReg(/*ArrayList<HotelRoom> roomList*/)
    {
      int reg = 0;
      for(int counter = 0; counter < roomList.size(); counter++)
      {
        if( (roomList.get(counter).getRoomStatus() == false) && (roomList.get(counter).getRoomType().equals("Regular")) )
        {
            reg++;
        }
      }
      return reg;
    }
    
    //checks if there are available rooms left for luxury room
    public static int numAvailLux(/*ArrayList<HotelRoom> roomList*/)
    {
      int lux = 0;
      for(int counter = 0; counter < roomList.size(); counter++)
      {
        if( (roomList.get(counter).getRoomStatus() == false) && (roomList.get(counter).getRoomType().equals("Luxury")) )
        {
            lux++;
        }
      }
      return lux;
    }
    
}
