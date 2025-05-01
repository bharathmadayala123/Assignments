package selenium.basics;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class assesrtions {

	public static void main(String[] args) {
	
		
    //Hard Assertion - When expected result not matching with actual result it will fail the program immediately.
    // It is static
		
		Assert.assertEquals("bharath", "bharath");
		Assert.assertNotEquals("sharath", "bharath");	
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertNull(null);
		Assert.assertNotNull(123);
	  //  Assert.fail("Intentionlly Failed");
	    
	    
   // Soft Assertion - When expected result not matching with actual result it will fail the program at the end.
   // It is Non Static
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals("bharath", "ert");
		softassert.assertNotEquals("sharath", "bharath");	
		softassert.assertTrue(true);
		softassert.assertFalse(false);
		softassert.assertNull(234);
		softassert.assertNotNull(123);
	  softassert.fail("Intentionlly Failed");
		softassert.assertAll();
	
	  System.out.println("Execution completed");

	}

}
