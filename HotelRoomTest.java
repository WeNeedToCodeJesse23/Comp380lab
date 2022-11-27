//package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {
	
    HotelRoom test1 = new HotelRoom(10,false, "Regular",3);
    HotelRoom test2 = new HotelRoom(20,false, "Regular",3);
    HotelRoom test3 = new HotelRoom(30,false, "Luxury",5);
    HotelRoom test4 = new HotelRoom(40,false, "Regular",3);
    HotelRoom test5 = new HotelRoom(50,true, "Regular",3);
    HotelRoom test6 = new HotelRoom(60,true, "Luxury",5);
	
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

    @Test
    void updateRoomStatusTest() {
	testy.add(test1);
        testy.add(test2);
        testy.add(test3);
        testy.add(test4);
        testy.add(test5);
        testy.add(test6);

        assertEquals(false,test2.getRoomStatus());
        HotelRoom.UpdateRoomStatus(test2.getRoomID());
        assertEquals(true,test2.getRoomStatus());

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
