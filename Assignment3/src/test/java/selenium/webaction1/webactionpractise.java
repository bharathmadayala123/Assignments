package selenium.webaction1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webactionpractise {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch browser window(Chrome)
		driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);

		// 4. Enter URL and Launch the application
		// (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String Actualtitle = driver.getTitle();
		String Expectedtitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(Actualtitle, Expectedtitle);

		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@title='ParaBank']"));
		Assert.assertTrue(logo.isDisplayed());

		// 7. Verify application caption (Experience the difference)
		WebElement textelement = driver.findElement(By.xpath("//p[text()='Experience the difference']"));
		textelement.isDisplayed();
		System.out.println("Logo text is displayed");

		// 8. Enter Invalid credentials in Username and Password textboxes
		WebElement usertext = driver.findElement(By.xpath("//div[1]/input[@class='input']"));
		usertext.clear();
		Assert.assertTrue(usertext.isDisplayed());
		Assert.assertTrue(usertext.isEnabled());
		usertext.sendKeys("invalid user");

		WebElement pwdtext = driver.findElement(By.xpath("//div[2]/input[@class='input']"));
		pwdtext.clear();
		Assert.assertTrue(pwdtext.isDisplayed());
		Assert.assertTrue(pwdtext.isEnabled());
		pwdtext.sendKeys("Pwd123");

		// 9. Verify button label (LOG IN) and Click on Login Button
		WebElement logbutton = driver.findElement(By.xpath("//input[@class='button']"));
		String Actuallabel = logbutton.getAttribute("value");
		String Expectedlabel = "Log In";
		Assert.assertEquals(Actuallabel, Expectedlabel);

		logbutton.click();

		// 10. Verify error message is coming
		// Implicit wait -
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));

//	      FluentWait<WebDriver> FluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10));
//	      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));

		// 11. Click on Admin page link

		WebElement link = driver.findElement(By.xpath("//a[text()='Admin Page']"));
		link.click();

		// 12. Wait for admin page
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[text()='Admin Page']"), 0));

		// 13. Select Data access mode as ' SOAP'

		selectDataAccessMode("restjson");

		// 14. Scroll-down till Loan provider
		WebElement loanproviderdropdown = driver.findElement(By.xpath("//select[@id='loanProvider']"));
		Select d = new Select(loanproviderdropdown);
		// 15. Select Loanprovider as 'Web Service'
		d.selectByVisibleText("JMS");

		// 16. Click on Submit button
		WebElement submitbtn = driver.findElement(By.xpath("//input[@value='Submit']"));
		String actual = submitbtn.getAttribute("value");
		String expected = "Submit";
		Assert.assertEquals(actual, expected);
		submitbtn.click();

		// 17.wait for Successful submission message
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//b[text()='Settings saved successfully.']"), 0));

		// 18.Click on Services Link

		WebElement servicelink = driver.findElement(By.xpath("//ul[@class='leftmenu']/li[3]/a[text()='Services']"));
		Assert.assertTrue(servicelink.isDisplayed());
		servicelink.click();

		// 19.Wait for Services page

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[text()='Bookstore services:']"), 0));

		// 20. Scroll down till bookstore services

		WebElement bookstoreServices = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView",bookstoreServices);

		// 21.Get total rows, columns in the bookstore service table

		List<WebElement> rows = driver.findElements(By.xpath("//span[text()='Bookstore services:']//following-sibling::table[1]//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//span[text()='Bookstore services:']//following-sibling::table[1]//tr[1]/td"));

		int totalrows = rows.size();
		int totalcolumn = columns.size();

		System.out.println("totalrows :"+totalrows);
		System.out.println("totalcolumn :"+totalcolumn);

		// 22.Get Column headers of book store services table
		System.out.println("Column headers are :");
		for(WebElement col:columns) {
			System.out.println(col.getText());
		}
		
//		System.out.println("Column rows are :");
//		for(WebElement row:rows) {
//			System.out.println(row.getText());
//		}

		// 23.Get all the data from book store service table
		
		for(int r=1;r<=totalrows;r++) {
			for(int c=1;c<=totalcolumn;c++) {
				WebElement cell = driver.findElement(By.xpath("//span[text()='Bookstore services:']//following-sibling::table[1]//tr["+r+"]//td["+c+"]"));
				System.out.println("Row "+r+" column "+c+ " value is : "+cell.getText());
			}
		}
		

		// 24.Close browser window
           driver.quit();
	}

	public static void selectDataAccessMode(String option) {
		// Static radio value use this line of method
		// WebElement datamode = driver.findElement(By.xpath("//input[@value='soap']"));
		WebElement datamode = driver.findElement(By.xpath("//input[@value='" + option + "']"));
		datamode.click();

	}

}
