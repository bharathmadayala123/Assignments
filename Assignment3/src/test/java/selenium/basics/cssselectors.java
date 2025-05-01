package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cssselectors {

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
	    Thread.sleep(2000);
	    
	    driver.findElement(By.cssSelector("input[name='email']"));
	    System.out.println("Search field shows successfully highlighted");
	    
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    System.out.println("Continue button is visible and click");
	    Thread.sleep(2000);
	    
	    //Email address is mandatory and shows required warning message
	    driver.findElement(By.cssSelector("div[class='form-error mt-1']"));
	    System.out.println("Required warning message shows successfully highlighted");
	    
	    driver.findElement(By.cssSelector("label[for='inputEmail']")); 
	    System.out.println("Emailaddress text is available");
	    
	    
	    
	    
	    
	    
	}

}
