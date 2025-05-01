package selenium.basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Practiceonbrowseractions {

	public static void main(String[] args) throws InterruptedException {
		
		
		//1. Launch the Browser window (Browser = Chrome)

		WebDriver driver = new ChromeDriver();

		// 2. Minimize browser window

		driver.manage().window().minimize();

		// 3. Maximize to specific resolution(800X400)

		driver.manage().window().setSize(new Dimension(800,400));

		// 4. Maximize the browser window
		
		driver.manage().window().maximize();
		
		// 5. Delete all browser cookies
		
		driver.manage().deleteAllCookies();
		System.out.println("Successfully deleted all cookies");
	
		// 6. Enter URL and Launch the Application (https://www.google.co.in/)
		
         driver.get("https://integration.slyncer.com/");
		
		// 7. Verify the application title (Google)
         
         String actualresult = driver.getTitle();
         String expectedresult="Trust Your Supplier";
         Assert.assertEquals(actualresult, expectedresult);
         System.out.println("Title shows successfuly as expected");
          
		
		//8.Navigate to different application
         driver.navigate().to("https://mvnrepository.com/artifact/org.testng/testng/7.11.0");
         
		
		//9.Go back to previous application
         driver.navigate().back();
         Thread.sleep(3000);
		
		//10. Move forward to next application
		
         driver.navigate().forward();
         Thread.sleep(3000);
		
		//11. Refresh the application
         driver.navigate().refresh();
         
		
		//12.collect the main window id (window handle id)
         String windowhandleid = driver.getWindowHandle();
         System.out.println("Window Handle ID :"+windowhandleid);
		
		//13.Launch new tab and Launch the application in new tab
         
         driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://www.google.com");
         Thread.sleep(3000);
         
		//14. Switch back to the main window
		driver.switchTo().window(windowhandleid);
		System.out.println("Move back to maven old site");
		Thread.sleep(3000);
         
		//15.Launch new window and Launch the application in new window
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		System.out.println("All Window IDs :"+driver.getWindowHandle());
		Thread.sleep(2000);
		
		//16.Switch back to main window
		
		driver.switchTo().window(windowhandleid);
		System.out.println("Move back to maven old site");
		Thread.sleep(3000);
		
		//17.Print browser window URL
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL :"+currenturl);
		
	   //18. Get the Size of window
		
		int width = driver.manage().window().getSize().getWidth();
		int height= driver.manage().window().getSize().getHeight();
		System.out.println("Size of Window :"+width+"X"+height);
		
	 //19.Close Current Window
		
		driver.close();
		Thread.sleep(1000);
     
	//20.Close all windows
		
		driver.quit();	

	}

}
