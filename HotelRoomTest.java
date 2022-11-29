//package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class HotelRoomTest {
	
	
    HotelRoom test1 = new HotelRoom(3,false, "Regular",3);
    HotelRoom test7 = new HotelRoom(5,false, "Regular",3);
    HotelRoom test3 = new HotelRoom(4,false, "Luxury",5);
    HotelRoom test4 = new HotelRoom(7,false, "Regular",3);
    HotelRoom test8 = new HotelRoom(5,true, "Regular",3);
    HotelRoom test6 = new HotelRoom(6,true, "Luxury",5);
    
    HotelRoom test2 = new HotelRoom(1,false, "Regular",2);
    HotelRoom test5 = new HotelRoom(2,true, "Regular",2);
    

	HotelRoom testRoom = new HotelRoom(55, false, "Regular", 2);
	
    @Test
    void getRoomIDTest() {
    	int output = testRoom.getRoomID();
    	assertEquals(55, output);
    }

    @Test
    void getNumberOfBedsTest() {
    	int output = testRoom.getNumberOfBeds();
    	assertEquals(2, output);
    }

    @Test
    void getRoomStatusTest() {
    	boolean output = testRoom.getRoomStatus();
    	assertEquals(false, output);
    }

    @Test
    void setReservedStatusTest() {
    	testRoom.setReservedStatus(true);
    	boolean output = testRoom.getRoomStatus();
    	assertEquals(true, output);
    }

    @Test
    void getRoomTypeTest() {
    	String output = testRoom.getRoomType();
    	assertEquals("Regular", output);
    }

    @Test
    void testToStringTest() {
    	assertEquals("55,false,Regular,2\n", testRoom.toString());		
    }

    @Test
    void loadHotelDataTest() {
    	
    }

    @Test
    void getCurrentRoomListTest() {
    }

    @Test
    void returnCollectionTest() {
    }

	/* Cases Testing:
	 * if the room starts false
	 * if the room starts true
	 */
    
    @Test
    void updateRoomStatusTest() {
    	
        HotelRoom.getCurrentRoomList().add(test2); //start false case
        HotelRoom.getCurrentRoomList().add(test5); //start true case
        boolean output;
        
        //if the room starts false
        HotelRoom.UpdateRoomStatus(test2.getRoomID());
        output = test2.getRoomStatus();
        assertEquals(true,output);

        //if the room starts true
        HotelRoom.UpdateRoomStatus(test5.getRoomID());
        output = test5.getRoomStatus();
        assertEquals(false,output);

    }

    @Test
    void writeHotelDataTest() {
    }

    @Test
    void numAvailRegTest() {
    	//There are no Rooms, returns 0 
        assertEquals(0,HotelRoom.numAvailReg());

        //There is a Regular Room, but it's occupied
        HotelRoom.ReturnCollection().add(test5);
        assertEquals(0,HotelRoom.numAvailReg());

        //There is a Room that is unoccupied but it's a Luxury Room
        HotelRoom.ReturnCollection().add(test3);
        assertEquals(0,HotelRoom.numAvailReg());

        //There is a Room that is occupied and Luxury Room
        HotelRoom.ReturnCollection().add(test6);
        assertEquals(0,HotelRoom.numAvailReg());

        //There is a Room that is Regular and unoccupied
        HotelRoom.ReturnCollection().add(test1);
        HotelRoom.ReturnCollection().add(test7);
        HotelRoom.ReturnCollection().add(test4);
        HotelRoom.ReturnCollection().add(test2);
        assertEquals(4,HotelRoom.numAvailReg());

    }

    @Test
    void numAvailLuxTest() {
    	
    }

    @Test
    void openRumTest() {
    }
}
