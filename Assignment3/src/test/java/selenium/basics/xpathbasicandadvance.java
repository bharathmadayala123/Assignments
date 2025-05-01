package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class xpathbasicandadvance {

	public static void main(String[] args) throws InterruptedException {
		// Xpath basic level1
		
		//Launch the chrome driver
		WebDriver driver = new EdgeDriver();
		//Thread.sleep(2000);
		
		//Minimize the window
		driver.manage().window().minimize();
		
		//maximize the browser
		driver.manage().window().maximize(); 
		
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		//resolution of browser
		driver.manage().window().setSize(new Dimension(435,900));
		
		//get the url
		driver.get("https://parabank.parasoft.com/");
		
		
	   //Locator by using Xpath
	
		driver.findElement(By.xpath("//li[@class='captionone']"));
		System.out.println("Locator found based on xpath-1");
		
		driver.findElement(By.xpath("//li[text()='ATM Services']"));
        System.out.println("Locators found based on xpath-2");
        
        //Xpath level 2-Find the hyperlink with partial text
        
        driver.findElement(By.xpath("//a[contains(@href,'reg')]"));
        System.out.println("Locator conatins partial text-1");
        
        driver.findElement(By.xpath("//a[contains(text(),'info')]"));
        System.out.println("Locator conatins partial text-2");
        
        driver.findElement(By.xpath("//p[starts-with (text(),'Experience')]"));
        System.out.println("Locator starts-with partial text-1");
        
        driver.findElement(By.xpath("//img[starts-with(@title,'Par')]"));
        System.out.println("Locator starts-with partial text-2");
        
        //Xpath level 3
        
        driver.findElement(By.xpath("//li[@class='captionone']/following-sibling::li[1]/child::a"));
        System.out.println("locator found successfully Xpath level-3");
        Thread.sleep(2000);
        
      //li/a[text()='Withdraw Funds']
        driver.findElement(By.xpath("//ul[@class='services']/child::li/child::a[text()='Withdraw Funds']"));
        System.out.println("Xpath level 3");
        
        driver.findElement(By.xpath("//ul[@class='services']//a[text()='Withdraw Funds']"));
        System.out.println("Xpath level3");
        
        driver.findElement(By.xpath("//ul[@class='services']/li/a[text()='Withdraw Funds']"));
        System.out.println("Xpath level3-1");
        
       
        
        
        
        
       		
	}

}
