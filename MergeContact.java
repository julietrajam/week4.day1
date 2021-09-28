package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 2. Enter UserName and Password Using Id Locator
		// Type Username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("demosalesmanager");

		// Type Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		WebElement login = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		login.click();

		// 4. Click on CRM/SFA Link
		// WebElement crmSfalink=driver.findElement(By.tagName("a"));
		WebElement crmSfalink = driver.findElement(By.linkText("CRM/SFA"));
		crmSfalink.click();

		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		Set<String> winSet = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(winSet);

		// Switching to child window
		driver.switchTo().window(list.get(1));

		Thread.sleep(3000);

		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		// driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner
		// x-grid3-col-firstName']/a)[1]")).click();

		// Switching to Parent Window
		driver.switchTo().window(list.get(0));

		Thread.sleep(3000);

		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		Set<String> winSet2 = driver.getWindowHandles();

		List<String> list2 = new ArrayList<String>(winSet2);

		// Switching to Child window

		driver.switchTo().window(list2.get(1));

		Thread.sleep(3000);

		// 10. Click on Second Resulting Contact
		// driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner
		// x-grid3-col-firstName']/a)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

		// Switching to Parent Window
		driver.switchTo().window(list2.get(0));

		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();

		// 12. Accept the Alert
		Alert a1 = driver.switchTo().alert();
		a1.accept();

		// 13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page is:" + title);

	}

}
