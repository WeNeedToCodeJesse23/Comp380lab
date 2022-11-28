//package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class HotelRoomTest {
	
    HotelRoom test1 = new HotelRoom(10,false, "Regular",3);
    HotelRoom test3 = new HotelRoom(30,false, "Luxury",3);
    HotelRoom test4 = new HotelRoom(40,false, "Regular",3);
    HotelRoom test6 = new HotelRoom(60,true, "Luxury",5);
    
    HotelRoom test2 = new HotelRoom(1,false, "Regular",2);
    HotelRoom test5 = new HotelRoom(2,true, "Regular",2);
    
    ArrayList<HotelRoom> testy = new ArrayList();

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
    	testy.add(test1);
        testy.add(test2);
        testy.add(test3);
        testy.add(test4);
        testy.add(test5);
        testy.add(test6);

        assertEquals(3,HotelRoom.numAvailReg());
    }

    @Test
    void numAvailLuxTest() {
    	testy.add(test1);
        testy.add(test2);
        testy.add(test3);
        testy.add(test4);
        testy.add(test5);
        testy.add(test6);

        assertEquals(1,HotelRoom.numAvailLux());

        HotelRoom test7 = new HotelRoom(66,false,"Luxury",5);
        testy.add(test7);
    }

    @Test
    void openRumTest() {
    }
}
