package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Seleniumbasiclocators {

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
				
			   //7.Locators and web elements
				
				driver.findElement(By.name("email"));
				
			    driver.findElement(By.tagName("input"));	
			    
			  //  driver.findElement(By.cla("class=\"form-control form-control-sm box-shadow-none is-invalid"));
			    
			    System.out.println("Successfully find the element");
			    
			    driver.findElement(By.tagName("button"));
			    
			   System.out.println("Continue button is identified");
			   
			   driver.findElement(By.linkText("Go to Home page"));
			   System.out.println("Link test identified");
			   
			   driver.findElement(By.partialLinkText("Home page"));
			   System.out.println("Partial link text success");
			   
			   ///css selector
			   
			   
			   
			    

	}

}
