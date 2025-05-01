package selenium.basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BrowserActions {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Launch the browser
		WebDriver driver = new FirefoxDriver();
		
		//2.Minimize the browser window
		driver.manage().window().maximize();
		
		//3. Maximized the browser
		
		driver.manage().window().minimize();
		
		//4. maximize to specific resolution (800*400)
		driver.manage().window().setSize(new Dimension(430,932));
		
		//5.Delete all browser cookies
		
		driver.manage().deleteAllCookies();
		
		//6. Launch the URL https://integration.slyncer.com/
		driver.get("https://integration.slyncer.com/");
		
		//7.Verify the application title
		String actualresult = driver.getTitle();
		String expectedresult = "Trust Your Supplier";
		Assert.assertEquals(actualresult, expectedresult);
		System.out.println("Assertvalidations are successfull");	
		
        //8.Navigate to different application
	     
		driver.navigate().to("https://mvnrepository.com/artifact/org.testng/testng/7.11.0");
		
		//9.go back to previous application 
		driver.navigate().back();
		Thread.sleep(3000);
		
		//10. Moving farword to next application
		driver.navigate().forward();
		Thread.sleep(3000);
		
		//11/If you want to refresh the application
		driver.navigate().refresh();
		System.out.println("Successfully refresh");	
		
		//12.Collect main window id
		String mainWindowHandleId = driver.getWindowHandle();
		System.out.println("Main Window ID :"+mainWindowHandleId);
		
		//13. Launch new tab and launch  the application in new tab (google.com)
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		
		//14.Switch back to main window
		driver.switchTo().window(mainWindowHandleId);
		
		//15.Launch the new window and launch the application in new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		System.out.println("All Window Handle Ids:"+driver.getWindowHandles());
		Thread.sleep(2000);
		
		//16.Switch back to main window
		driver.switchTo().window(mainWindowHandleId);
		
		//17. Print browser window url
		String currentWindowUrl = driver.getCurrentUrl();
		System.out.println("Current Window Url :"+currentWindowUrl);
		
		//18.Get Size of the window
		
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		System.out.println("Size of Window :"+width+"X"+height);
		
		//19. Close current window.
		driver.close();
		
		//20. Close all remaining  windows
		driver.quit();
		
		
		
		
		
		
		
		
	
		
	}

}
