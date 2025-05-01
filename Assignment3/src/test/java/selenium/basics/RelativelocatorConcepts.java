package selenium.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativelocatorConcepts {

	public static void main(String[]args) throws InterruptedException {
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
		
		
		driver.findElement(RelativeLocator.with(By.linkText("Contact Us")).toLeftOf(By.xpath("//a[text()='Site Map']")));
		System.out.println("relativelocator successfully shown direction");
		
		driver.findElement(RelativeLocator.with(By.xpath("//h2[text()='Customer Login']")).below(By.xpath("//b[text()='Username']")));
		System.out.println("Relative locator successfully shows  the direction-2");
		
		driver.findElement(By.xpath("//b[text()='Username'] and //div[@id='loginPanel']/form/p[1]/b]"));
        System.out.println("Relative locator successfully shows  the direction-3");

	}

}
