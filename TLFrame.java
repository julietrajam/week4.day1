package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TLFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		
		//Switching to first frame
		driver.switchTo().frame(0);
		
		//Click Click Me button inside the frame
		WebElement button1=driver.findElement(By.id("Click"));
		button1.click();
		System.out.println("Text inside Button1:"+button1.getText());
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5);
		//Navigating to next frame
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		
		//Click Button inside the frame 2
		WebElement button2=driver.findElement(By.id("Click1"));
		button2.click();
		System.out.println("Text inside BUtton2:"+button2.getText()); 
		
		driver.switchTo().defaultContent();
		
		
		List<WebElement> frameCount=driver.findElements(By.tagName("iframe"));
		System.out.println("No of Frames in a webpage: "+frameCount.size());
				
	}

}
