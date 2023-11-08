package Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void login_Functionality() throws Throwable {
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://katalon-demo-cura.herokuapp.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.findElement(By.id("menu-toggle")).click();
	
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	
	WebElement username=driver.findElement(By.id("txt-username"));
	username.sendKeys("John Doe");
	
	WebElement password=driver.findElement(By.id("txt-password"));
	password.sendKeys("ThisIsNotAPassword");
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	String url=driver.getCurrentUrl();
	
	//Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", url);
	
	
	
	WebElement checkbox=driver.findElement(By.id("chk_hospotal_readmission"));
	checkbox.click();
	System.out.println(checkbox.isSelected());
	
	
	driver.findElement(By.id("txt_visit_date")).sendKeys("12082023");
	
	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("NA");
	
	driver.findElement(By.id("btn-book-appointment")).click();
	
	String conurl=driver.getCurrentUrl();
	Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", conurl);
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	File target=new File("./target/test.png");
	
	FileUtils.copyFile(src, target);
	
	}
	
}
