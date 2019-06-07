package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App {
	WebDriver driver;
  @BeforeMethod
  public void launch() {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://18.220.161.194:8889/");
  }
  
  @Test
  public void verify() {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("About Us")).click();

	  if(driver.getPageSource().contains("This is"))
	  {
	  System.out.println("Text is Present");
	  }
	  else
	  {
	  System.out.println("Text is not Present");
	  }
  }
  
  @AfterMethod
  public void close() {
	  driver.close();
  }
}
