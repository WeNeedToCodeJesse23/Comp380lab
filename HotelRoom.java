import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
Provide a complete summary for each module/class header: 
include
- Module name or Class name in the Design
- Date of the code: Sep 25, 2022
- Programmer's name
- Brief description of the class/module
- Brief explanation of important functions in each class, including its input values and output values
- Any important data structure in class/methods
- Briefly describe any algorithm that you may have used and why did you select it upon other algorithms where more than one option exists.
*/

/**
 * 
 * @author Jaztin T
 *
 * Date of Code: Nov. 7, 2022
 * <p>
 * Programmer's Names: Alondra, Omar, Jesse, Jaztin
 * <p>
 * Brief Description of the Class/Module: 
 * <p>
 * This class is used to hold Hotel Room related data. hotelRoomID, numberOfBeds, reservedStatus, roomType are fields that are stored/utilized in
 * a Hotel Room instance. Additionally, this class implements the ArrayList data structure called roomList to store all different types of rooms
 * listed from the Hotel database/txt file. To bluntly put it, roomList is used to manipulate the data stored in the txt file and then is saved
 * back onto the txt file through the use of different methods relating to HotelRoom. 
 * 
 */

public class HotelRoom {
	
	private int hotelRoomID; //unique hotel ID
	private int numberOfBeds; //numberOfBedrooms
	private boolean reservedStatus;  //true = reserved, false = not reserved
	private String roomType; // luxury or regular
	private static ArrayList<HotelRoom> roomList = new ArrayList<HotelRoom>(); //this list will be the only one throughout
	
	/**
	 * 
	 * @param roomID
	 * @param status
	 * @param type
	 * @param numBed
	 * 
	 * The HotelRoom constructor takes in roomID, status, type, and numBed data and stores the data in HotelRoom class 
	 * data fields called hotelRoomID, reservedStatus, roomType, and numberOfBeds.
	 * 
	 */
	
	public HotelRoom(int roomID, boolean status, String type, int numBed)
	{
		hotelRoomID = roomID;
		reservedStatus = status;
		roomType = type;
		numberOfBeds = numBed;
	}
	
	/**
	 * 
	 * @return hotelRoomID
	 * 
	 * The getRoomID() method returns back the hotelRoomID of the instance. In other words, it returns back the Hotel Room number
	 * 
	 */
	
	public int getRoomID()
	{
		return hotelRoomID;
	}

	/**
	 * 
	 * @return numberOfBeds
	 * 
	 * The numberOfBeds() method returns back the numberOfBeds of the instance. In other words, it returns back the number of bedrooms a 
	 * HotelRoom instance has
	 * 
	 */
	
	public int getNumberOfBeds()
	{
		return numberOfBeds;
	}
	
	/**
	 * 
	 * @return reservedStatus
	 * 
	 * The getRoomStatus() method returns back the reservedStatus of the instance. In other words, it returns back the boolean
	 * value true = reserved or false = not reserved.
	 * 
	 */
	
	public boolean getRoomStatus()
	{
		return reservedStatus;
	}
	
	/**
	 * 
	 * @param status
	 * 
	 * The setReservedStatus() method sets the reservedStatus to the status parameter
	 * 
	 */
	
	public void setReservedStatus(boolean status)
	{
		reservedStatus = status;
	}
	
	/**
	 * 
	 * @return getRoomType
	 * 
	 * The getRoomType() method gets the roomType of the HotelRoom instance. In other words, it's used to get the type of HotelRoom. 
	 * There are 2 types of Hotel Rooms: Regular and Luxury.
	 * 
	 */
	
	public String getRoomType()
	{
		return roomType;
	}
	
	/**
	 * 
	 * @return roomFormat
	 * 
	 * The toString() method prints out a custom string for the HotelRoom class. This method is also used to write back to
	 * the HotelRoom Database/Txt file
	 * 
	 */
	
	@Override
	public String toString(){
		String roomFormat = hotelRoomID + "," + reservedStatus + "," + roomType + "," + numberOfBeds + "\n";
        return roomFormat;
	}
	
	/**
	 * 
	 * @return roomList
	 * 
	 * The getCurrentRoomList() returns the gets the roomList. In other words, the static ArrayList that holds all the Hotel Room 
	 * data is returned.
	 * 
	 */
	public static ArrayList<HotelRoom> getCurrentRoomList()
	{
		return roomList;
	}
	
	/**
	 * 
	 * The clearRoomList() method clears the private roomList array. This method actually uses ArrayList's .clear() function. In other words,
	 * this method delegates clearing to the .clear() method of ArrayList.
	 * 
	 */
	
	public static void clearRoomList()
	{
		roomList.clear();
	}
	
	/**
	 * The loadHotelData() method loads the Hotel Data from a text file to an ArrayList of HotelRooms. In order to do so,
	 * the class iterates through the entire text file by using the comma delimiter and scanner. 
	 * Each Line in the text file signifies one set of Hotel Room data. Therefore, each line is one element is 
	 * stored in the static ArrayList called roomList.
	 */
	
	//read the text file holding the data
    public static void loadHotelData() {     
      
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
	       txtInput = new Scanner(new File("RoomReservationTestDataHotelRooms.txt")); //RoomReservationTestDataHotelRooms.txt
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
	
    /**
     * 
     * @return roomList
     * The ReturnCollection method that will return the roomList ArrayList. 
     * In other words, the static ArrayList that holds all the Hotel Room data is returned.
     */
    
	//The Collection must call LoadData before you can Return the Collection, Otherwise the Data will be returned as empty
    public static ArrayList<HotelRoom> ReturnCollection(){
            return roomList;
    }
	
    /**
     * 
     * @param RoomID
     * The UpdateRoomStatus method is used to change the status of the room.
     * It turns a room that is true (reserved) to false (empty/unreserved).
     * 
     */
	
    public static void UpdateRoomStatus(int RoomID){
        //  System.out.println("this is RoomID in WriteHotel " + RoomID);
        // System.out.println(roomList.get(RoomID-1));
       System.out.println(roomList.get(RoomID - 1) + " -----------before--------------- " + roomList.get(RoomID-1).getRoomStatus());
        if(roomList.get(RoomID - 1).getRoomStatus() == false) {
            roomList.get(RoomID - 1).setReservedStatus(true);
        } else {
            roomList.get(RoomID - 1 ).setReservedStatus(false);
        }
       System.out.println(roomList.get(RoomID-1) + " ------------after------------- " + roomList.get(RoomID-1).getRoomStatus());
        writeHotelData();
    }

    /**
     * The writeHotelData() method writes the Hotel Data to a text file from an ArrayList of HotelRooms. In order to do so,
	 * the class iterates through the entire ArrayList and writes to the text file by using the toString method. 
	 * Each Line in the text file signifies one set of Hotel Room data with their fields separated by a comma delimiter. 
	 * Therefore, each line is one element is stored in the static ArrayList called roomList.
     */
     
    public static void writeHotelData() {
        String hotelData;
        try
        {
            PrintWriter pw = new PrintWriter(new File("RoomReservationTestDataHotelRooms.txt"));
            for(int counter = 0; counter < roomList.size(); counter++)
            {
                hotelData = roomList.get(counter).toString();
            //    System.out.println(hotelData);
                pw.write(hotelData);
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
     * @return reg
     * The numAvailReg method counts how many values in the ArrayList that are "Regular" rooms and are available to be reserved (roomStatus=false).
     * The Value is then returned as reg
     */
    
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
    
    /**
     * @return lux
     * The numAvailLux method counts how many values in the ArrayList that are "Luxury" rooms and are available to be reserved (roomStatus=false).
     * The Value is then returned as lux
     */
    
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
    
    /**
     * 
     * @param id
     * The openRum method is used to set the reserved status of a room to false. In other words, it clears a room for reservation.
     * 
     */
    public static void openRum(String id)
    {
    	int rumID = Integer.parseInt(id)-1;
    	System.out.println(roomList.get(rumID).toString());
    	roomList.get(rumID).setReservedStatus(false);
    	System.out.println(roomList.get(rumID).toString());
    	writeHotelData();
    }
}
