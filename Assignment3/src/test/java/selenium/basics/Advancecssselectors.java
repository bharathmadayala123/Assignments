package selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Advancecssselectors {

	public static void main(String[] args) {
				
     	    //1. Launch the browser
				WebDriver driver = new FirefoxDriver();
				
			//2.Minimize the browser
				driver.manage().window().minimize();
				
			//3. Maximized the browser
			    driver.manage().window().maximize();	
						
			//4. maximize to specific resolution (800*400)
			    driver.manage().window().setSize(new Dimension(439,900));		
						
			//5.Delete all browser cookies
				driver.manage().deleteAllCookies();	
						
		    //6. Launch the URL https://integration.slyncer.com/
				driver.get("https://parabank.parasoft.com/");	
				
		   //7. If any duplicate locaters to fund the exact location by applying Advancecssselector.
				driver.findElement(By.cssSelector("ul[class='leftmenu'] > li > a[href='services.htm']"));
				System.out.println("Highlight");
				
				
		  //8. If Any duplicate locators we used for exact locator web element
			   driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(6) > a[href='admin.htm']"));
			   System.out.println("Highlighted Adminactions");
				
			}


}
