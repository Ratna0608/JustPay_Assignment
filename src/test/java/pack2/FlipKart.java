package pack2;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testing.framework.EmailUtils;

public class FlipKart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method 
		String OTP;
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement Login_btn=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
		Login_btn.click();
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("automationframeworks1@gmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
		EmailUtils email=new EmailUtils();
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\JustPay_Assignment\\src\\test\\java\\utilities\\config.properties");
		prop.load(file);
		//email.connectToGmail(prop);
		List<String>emailtext=email.getMessageByFromEmail(email.connectToGmail(prop), "Inbox","noreply@ncb.flipkart.com","Flipkart Account");
		if(emailtext.size()<1) {
			throw new Exception("No Otp Received");
		}
		else {
			String regex="[^\\d]+";
			String[] arrotp=emailtext.get(0).split(regex);
			OTP=arrotp[1];
			System.out.println("OTP is"+OTP);
		}
	}


	}



