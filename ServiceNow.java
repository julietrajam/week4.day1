package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://dev99100.service-now.com/navpage.do");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		
		//Login Page
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2AGRIiJuks3f");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		//Type Incident in Search Box
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident",Keys.ENTER);
		
		//Click Incidents
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		driver.switchTo().frame("gsft_main");
		//Click New
		driver.findElement(By.id("sysverb_new")).click();
		
		//Getting text of Incident Number
		WebElement incident=driver.findElement(By.name("incident.number"));
		String incNo=incident.getAttribute("value");
		System.out.println("Incident Number:"+incNo);
		
		//Click Search in Caller
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> winSet=driver.getWindowHandles();
		
		List<String> list=new ArrayList<String>(winSet);
		
		driver.switchTo().window(list.get(1));
		
		//Clicke Search
		driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys("Junior",Keys.ENTER);
				
		driver.findElement(By.xpath("//a[text()='Junior Wadlinger']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().window(list.get(0));
		
		driver.switchTo().frame("gsft_main");
		
		
		/*
		 * Set<String> winSet2=driver.getWindowHandles();
		 * 
		 * List<String> list2=new ArrayList<String>(winSet2);
		 * 
		 * driver.switchTo().window(list2.get(1));
		 */
		
		driver.findElement(By.id("sys_display.incident.caller_id")).click();
		
		//Entering Short Description
		driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();
		
		
		  Set<String> winSet3=driver.getWindowHandles();
		  
		  List<String> list3=new ArrayList<String>(winSet3);
		  
		  driver.switchTo().window(list3.get(1));
		 
		
		driver.findElement(By.xpath("//a[contains(text(),'Issue with email')]")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().window(list.get(0));
		
		driver.switchTo().frame("gsft_main");
		
		//Click Submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.sendKeys(incNo);
		
		

	}

}
