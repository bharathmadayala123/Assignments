package selenium.webaction1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Webactionpagepractise2 {
	
	      static WebDriver driver;

	public static void main(String[] args) {
		
//		 1. Launch browser window(Chrome)
		 driver = new EdgeDriver();
	       
//       2. Maximize the browser window
		driver.manage().window().maximize();

//       3. Delete all the cookies
		driver.manage().deleteAllCookies();
      
//       4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
		driver.get("https://demoqa.com/automation-practice-form");
      
//       5. Wait for Page-load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
//       6. Enter First name and Last name
         WebElement fname = driver.findElement(By.xpath("//input[@id='firstName']"));
         WebElement Lname = driver.findElement(By.xpath("//input[@id='lastName']"));
         
         fname.sendKeys("bharath");
         Lname.sendKeys("Murali");
         
         Assert.assertTrue(fname.isDisplayed());
         Assert.assertTrue(fname.isEnabled());

         Assert.assertTrue(Lname.isDisplayed());
         Assert.assertTrue(Lname.isEnabled());        
          
//       7. Enter Email
         
         WebElement email = driver.findElement(By.xpath("//div[@id='userEmail-wrapper']/div[2]/input[@type='text']"));
         email.sendKeys("madayalabharath@gmail.com");
         
         Assert.assertTrue(email.isDisplayed());
         Assert.assertTrue(email.isEnabled());
              
//       8. Select Gender (Female)
         selectGender("Female");
//       9. Enter mobile number
              
         WebElement mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
         mobile.sendKeys("911111111");
         Assert.assertTrue(mobile.isDisplayed());
         Assert.assertTrue(mobile.isEnabled());
         
//       10.Select DOB (1-Feb-1991)
         calander("1","febrauary","1991");
              
//       11.Search and Select Computer Science
         selectssubject("Computer Science");
              
//       12.Select Hobbies as Sports and Reading
         String [] hobbies = {"Sports","Reading"};
         selecthobbies(hobbies);
              
//       13.Upload photo
         uploadphoto("C:\\Users\\Bharath\\Downloads\\Capture");
              
//       14. Dropdown State
         scdropdown("NCR");
//        14.1, Dropdown city
         cdropdown();              
//       15. Upload file
              
//       16. Wait till file upload
              
//       17.Submit Details
              
//       18. Close browser window

	}
	
	
	//Create method for the calender
	//Open calender
	public static void calander(String date,String month,String year) {
     WebElement calbox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
     calbox.click();
    //Wait for the calendar 
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'month-container')]"),0));
    //Select the month 
     WebElement monthdropdown = driver.findElement(By.xpath("//select[contains(@class,'month-select')]"));
     Select selectmonth = new Select(monthdropdown);
     selectmonth.selectByVisibleText(month);
    //Select the year
     WebElement yeardropdown = driver.findElement(By.xpath("//select[contains(@class,'year-select')]"));
     Select selectyear = new Select(yeardropdown);
     selectyear.selectByVisibleText(year);
     //Select date
     WebElement datepick = driver.findElement(By.xpath("//div[contains(@aria-label,'"+month+"')  and text()='"+date+"']"));
     datepick.click();     
   
     
     
     
     
     
	}
	
	
	//Dynamic dropdown values
	
	public static void selectssubject(String subjectname) {
		WebElement subjects = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__value-container')]"));
	
		//Scroll down to subjects element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",subjects);
		
		//Enter Subject name
		Actions actions = new Actions(driver);
		actions.sendKeys(subjects,subjectname).perform();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'option') and text()='"+subjectname+"']"), 0));
		
	   //Select the subject from suggestion
		
		WebElement subject = driver.findElement(By.xpath("\"//div[contains(@class,'option') and text()='\"+subjectname+\"']"));
         subject.click();	
	}

	// Radio buttons
	public static void selectGender(String option) {
		WebElement radiobtn = driver.findElement(By.xpath("//label[text()='" +option+" ']"));
		radiobtn.click();
	
	}
	//Select checkbox
     public static void selecthobbies(String [] options) {
    	 for(String option : options) {
    		 WebElement hobbie = driver.findElement(By.xpath("//label[text()='"+option+"']"));
    		 if(!hobbie.isSelected()) {
    			 hobbie.click();
    			 
    		 }
    		 
    	 }
    	

     }
     //Upload photo
     public static void uploadphoto(String filepath) {
    	 WebElement uploadbtn = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
    	 uploadbtn.sendKeys(filepath);
     }
     
//     WebElement loanproviderdropdown = driver.findElement(By.xpath("//select[@id='loanProvider']"));
//		Select d = new Select(loanproviderdropdown);
//		// 15. Select Loanprovider as 'Web Service'
//		d.selectByVisibleText("JMS");
     
     public static void scdropdown(String option) {
    	 WebElement Statedp = driver.findElement(By.xpath("//div[@id='state' and text()='NCR']"));
    	 Select dp = new Select(Statedp);
    	 dp.selectByVisibleText(option);
     }
     
     public static void cdropdown(String option) {
    	 WebElement citydp = driver.findElement(By.xpath("//div[@id='"+option+"']"));
    	 Select d = new Select(citydp);
    	 d.selectByVisibleText(option);
}

