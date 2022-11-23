import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void test() {

		Customer test = new Customer("jesse", "123 sesame st", "jaysee808@yahoo.com", "1234567891234560");
		String me = test.getAddy();
		assertEquals("123 sesame st",me);
		test.loadCustomerData();
		String name = test.getCurrentCustomerList().get(1).getName();
		assertEquals("George",name);
	}

}
