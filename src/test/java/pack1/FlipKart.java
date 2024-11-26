package pack1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.testing.framework.EmailUtils;

public class FlipKart {
	@Test
	public void fun() throws Exception {
		String OTP;
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
//		WebElement Login_btn=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
//		Login_btn.click();
//		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("automationframeworks1@gmail.com");
//		driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
//		Thread.sleep(50000);
//		driver.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
//		Thread.sleep(5000);

	/*	WebElement Login_btn=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
		Login_btn.click();
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("automationframeworks1@gmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
		EmailUtils email=new EmailUtils();
		Properties prop=new Properties();
		prop.setProperty("gmail_username", "automationframeworks1@gmail.");
		prop.setProperty("gmail_password","kwlmrcbkzjeyffwx");
		prop.setProperty("gmail_port", "587");
		//email.connectToGmail(prop);
		@SuppressWarnings("unchecked")
		List<String>emailtext=email.getMessageByFromEmail(email.connectToGmail(prop), "Inbox","noreply@ncb.flipkart.com","Flipkart Account");
		if(emailtext.size()<1) {
			throw new Exception("No Otp Received");
		}
		else {
			String regex="[^\\d]+";
			String[] arrotp=emailtext.get(0).split(regex);
			OTP=arrotp[1];
			System.out.println("OTP is"+OTP);
		}*/
		Actions act =new Actions(driver);
		WebElement search_box=driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
		act.click(search_box).sendKeys("SAMSUNG Galaxy S24+ 5G Cobalt Violet, 256 GB").keyUp(Keys.ENTER).keyDown(Keys.ENTER).perform();
	    WebElement clickMobile=driver.findElement(By.xpath("//div[normalize-space()='SAMSUNG Galaxy S24+ 5G (Cobalt Violet, 256 GB)']"));
	    act.moveToElement(clickMobile).click().perform();
		Set<String>WindowIds=driver.getWindowHandles();
		Iterator it=WindowIds.iterator();
		  String parentid=(String) it.next();
		 
		  String childid=(String) it.next();
		  driver.switchTo().window(childid);
	System.out.println(	driver.getTitle());
	WebElement BuyNow=driver.findElement(By.xpath("//button[normalize-space()='Buy Now']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()", BuyNow);
	js.executeScript("arguments[0].click()", BuyNow);
	act.moveToElement(BuyNow).click().perform();
	
	//driver.switchTo().window()
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']")).click()
	;
	WebElement email=driver.findElement(By.xpath("(//div//input[@type='text'])"));
	act.click(email).sendKeys("ratnanaru06@gmail.com").perform();
	
	driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']")).click();
	Thread.sleep(50000);
//	WebElement submit_btn=driver.findElement(By.xpath("//button[@type='submit' or @type='Login']"));
//	act.click(submit_btn);
	act.keyUp(Keys.ENTER).keyDown(Keys.ENTER).perform();
	
         WebElement OrderSummery=driver.findElement(By.xpath("//span[normalize-space()='Order Summary']"));
            OrderSummery.click();
          WebElement continue_btn=driver.findElement(By.xpath("//button[normalize-space()='CONTINUE']"));
	         continue_btn.click();
	         
	       WebElement Accept_btn= driver.findElement(By.xpath("//button[normalize-space()='Accept & Continue']"));
	       Accept_btn.click();
	       Thread.sleep(3000);
	       WebElement payment_method=driver.findElement(By.xpath("//input[@id='PHONEPE']"));
	     //  if(!payment_method.isSelected()) {
	    	//   payment_method.click();
	       js.executeScript("arguments[0].click()", payment_method);
	    	   
	     //  }
	      WebElement continue_btn2= driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']"));
	    //  continue_btn.click();
	       js.executeScript("arguments[0].click()", continue_btn2);
	       
	       Thread.sleep(3000);
	      WebElement payment_otp=driver.findElement(By.xpath("//button[@id='onboardingFormSubmitBtn']"));
	       js.executeScript("arguments[0].scrollIntoView()", continue_btn2);

	       js.executeScript("arguments[0].click()", continue_btn2);


	
	}
	
	

}
