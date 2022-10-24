
public class HotelRoom {
	
	private int hotelRoomID;
	private int numberOfBeds;
	private boolean reservedStatus;
	private String roomType;
	
	
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
	
}
