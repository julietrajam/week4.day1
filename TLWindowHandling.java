package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TLWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");

		// Click Open Home Page button
		WebElement button1 = driver.findElement(By.id("home"));
		button1.click();

		Set<String> winSet = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(winSet);

		driver.switchTo().window(list.get(1)).close();

		driver.switchTo().window(list.get(0));

		// Click Button Open Multiple Windows

		WebElement button2 = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		button2.click();

		Set<String> winSet1 = driver.getWindowHandles();

		List<String> list1 = new ArrayList<String>(winSet1);

		driver.switchTo().window(list1.get(1)).close();
		driver.switchTo().window(list1.get(2)).close();

		driver.switchTo().window(list1.get(0));
		
		WebElement button3 = driver.findElement(By.xpath("//button[text()='Do not close me ']"));
		button3.click();

		Set<String> winSet2 = driver.getWindowHandles();

		List<String> list2 = new ArrayList<String>(winSet2);

		driver.switchTo().window(list2.get(1)).close();
		driver.switchTo().window(list2.get(2)).close();

		driver.switchTo().window(list2.get(0));
		
		//Click wait for 5 seconds button
		WebElement button4 = driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']"));
		button4.click();
		
		Thread.sleep(5);
		
		Set<String> winSet3 = driver.getWindowHandles();

		List<String> list3 = new ArrayList<String>(winSet3);

		driver.switchTo().window(list3.get(1)).close();
		driver.switchTo().window(list3.get(2)).close();

		driver.switchTo().window(list3.get(0));
		
		
		

	}

}
