import java.lang.Math;

public class Customer {
	
	private String name;
	private String address;
	private String email;
	private String cardNumber;
	private String custID;
	private int roomID;
	
	public Customer(String name, String address, String email, String cardNumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		custID = Integer.toString((int)(Math.random()));
		roomID = 1 + (int)(Math.random() * ((80 - 1) + 1));
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	private String pass;
	
	
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
	public String getPaytype() {
		return cardNumber;
	}
	public void setPaytype(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	
	@Override
	public String toString(){
		String roomFormat = "Name: " + name +  "\tEmail: " + email + "\tAddress: " + address + "\tCard Number: " + cardNumber + "\tCustomer ID: " + custID + "\tRoomID: " + roomID;
		return roomFormat;
	} 

}
