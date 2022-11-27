//package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

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
    }

    @Test
    void writeHotelDataTest() {
    }

    @Test
    void numAvailRegTest() {
    }

    @Test
    void numAvailLuxTest() {
    }

    @Test
    void openRumTest() {
    }
}
