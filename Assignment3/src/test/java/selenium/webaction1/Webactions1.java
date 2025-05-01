package selenium.webaction1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Webactions1 {

	public static void main(String[] args) throws InterruptedException {
		
	//Web actions on each of the web element
		
		//1.Launch the browser 
		WebDriver driver = new FirefoxDriver();
		
		//2.Minimize the window
		driver.manage().window().minimize();
		
		//3.Maximize the window
		driver.manage().window().maximize();
		
		//4.Resolution of window
		driver.manage().window().setSize(new Dimension(439,500));
		
		//5.delete all browser cookies
		driver.manage().deleteAllCookies();
		
		//Launch the url
		driver.get("https://integration.slyncer.com/");
		System.out.println("Sucessfully TYS home page is launched");
	     Thread.sleep(3000);
		
		
		//Enter Email address
		WebElement emailtextbox = driver.findElement(By.xpath("//input[@name='email']"));
		
		//enter text in to emailAddress
		emailtextbox.sendKeys("bharathadpint@maildrop.cc");
		System.out.println("Successfully email text accepted 1st time");
		
		emailtextbox.isDisplayed();
		System.out.println("Email address text box element is displayed");
		
		emailtextbox.isEnabled();
		System.out.println("Email address text field is enabled");
		
		WebElement Continuebtn = driver.findElement(By.xpath("//div/button[text()='Continue']"));
		String actuallabel = Continuebtn.getText();
		String explabel = "Continue";
		Assert.assertEquals(actuallabel, explabel);
		Continuebtn.click();
		System.out.println("Screen navigated and shows password element");
		
	
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Page navigate and display with new element password
		driver.navigate().refresh();
		
//		String mainwindowhandleid = driver.getWindowHandle();
//		System.out.println("main window id:"+mainwindowhandleid);
//		
//		driver.switchTo().window(mainwindowhandleid);
		
		
		emailtextbox.sendKeys("bharathadpint@maildrop.cc");
		System.out.println("Successfully email text accepted for 2nd time");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//form/div/div[1]/input[@name='password']"), 0));
				
		WebElement textbox1 = driver.findElement(By.xpath("//form/div/div[1]/input[@name='password']"));
		
		textbox1.sendKeys("Password1");
		
		textbox1.isDisplayed();
		System.out.println("Password field address text box element is displayed");
		
		textbox1.isEnabled();
		System.out.println("Password field address text box element is Enabled");
		
		//click on sign button
		
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit' and text()='Sign In']"));
		
		
		signin.isDisplayed();
		System.out.println("Sign in button is displayed");
		
		signin.isEnabled();
		System.out.println("SignIn button is Enabled");
		
		String button = signin.getAttribute("submit");
		signin.click();
		
		//Screen navigated to Dashboard
		
		driver.navigate().to("https://integration.slyncer.com/dashboard");
		Thread.sleep(2000);
		
		//Check the dashboard with Tys logo
		
	   WebElement text = driver.findElement(By.xpath("//div/h3[text()='My Dashboard']"));
	   
	   text.isDisplayed();
		
	    System.out.println("Successfully login to the TYS dashboard");
	}

}
