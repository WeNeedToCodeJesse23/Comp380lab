import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/***
 * 
 * @author Jaztin T
 * This test class will be used to test the Manager Class. 
 * The method of significance is the checkPassTest().
 */

class ManagerTest {

	manager managerTestClass = new manager("John", "testPassword", 1);
	manager managerTestClass2 = new manager("Kim", "testPassword", 2);
	manager managerTestClass3 = new manager("Chloe", "testPassword", 3);
	manager managerTestClass4 = new manager("Migo", "testPassword", 4);
	
	/* Cases Testing:
	 * if there are no managers in managerList
	 * if there is at least one manager in managerList, but the name doesn't match
	 * if there is at least one manager in managerList. The name matches, but the password passed isn't correct
	 * if there is at least one manager in managerList. The name and password passed is correct
	 */
	@Test
	void checkPassTest() {
		int output;
		output = manager.CheckPass("John", "testPassword");
		//if there are no managers in managerList
		assertEquals(-1, output);
		manager.getManagerList().add(managerTestClass);
		//if there is at least one manager in managerList, but the name doesn't match
		output = manager.CheckPass("Johnny", "testPassword");
		assertEquals(-1, output);
		//if there is at least one manager in managerList. The name matches, but the password passed isn't correct
		output = manager.CheckPass("John", "wrongPassword");
		assertEquals(-1, output);
		//if there is at least one manager in managerList. The name and password passed is correct
		output = manager.CheckPass("John", "testPassword");
		assertEquals(0, output);
	
	/* For Loop Testing:
	 * 1) 0 times through the loop
	 * 2) 1 time through the loop
	 * 3) 1 < m < n-1 (general case) approx. m= n/2
	 * 4) n-1 times
	 * 5) n times
	 * 6) n+1 times
	 */
		manager.getManagerList().remove(managerTestClass);
		//1) 0 times through the loop
		output = manager.CheckPass("John", "testPassword");
		assertEquals(-1, output);
		//2) 1 time through the loop
		manager.getManagerList().add(managerTestClass);
		manager.getManagerList().add(managerTestClass2);
		manager.getManagerList().add(managerTestClass3);
		manager.getManagerList().add(managerTestClass4);
		output = manager.CheckPass("John", "testPassword");
		assertEquals(0, output);
		//3) 1 < m < n-1 (general case) approx. m= n/2
		output = manager.CheckPass("Kim", "testPassword");
		assertEquals(1, output);
		//4) n-1 times
		output = manager.CheckPass("Chloe", "testPassword");
		assertEquals(2, output);
		//5) n times and 6) n+1 times
		output = manager.CheckPass("Migo", "testPassword");
		assertEquals(3, output);
	}
	
	@Test
	void getNameTest()
	{
		String output;
		output = managerTestClass.getName();
		assertEquals("John", output);
	}
	
	@Test
	void setNameTest()
	{
		String output;
		managerTestClass.setName("Johnny");
		output = managerTestClass.getName();
		assertEquals("Johnny", output);
	}
	
	@Test
	void getPasswordTest()
	{
		String output;
		output = managerTestClass.getPassword();
		assertEquals("testPassword", output);
	}
	
	@Test
	void setPasswordTest()
	{
		String output;
		managerTestClass.setPassword("newPassword");
		output = managerTestClass.getPassword();
		assertEquals("newPassword", output);
	}

}
