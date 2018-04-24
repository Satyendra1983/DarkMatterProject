package sampleDMProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sampleDarkMatter extends utilities {
	
		ChromeDriver driver;
		
		String URL = "http://todomvc.com/examples/troopjs_require/";
		
		
	@BeforeClass
	public void killProcessa( ) 
	{
	       this.killProcess();
	}
	
	@Test (priority = 1)
	public void openBrowser()
	{
//launch chrome browser and open the URL
		driver = this.driver();
		driver.get(URL);
//maximize the browser window
		driver.manage().window().maximize();
//validate if the browser title is as expected
		String newtodo = driver.getTitle();
		AssertJUnit.assertEquals(newtodo,"TroopJS • TodoMVC");
			
		
	}
	
	@Test (priority = 2)
	public void addEntry() throws AWTException
	{
		WebElement placeholder = driver.findElement(By.className("new-todo"));
		this.highlightElement(driver, placeholder);
//Array of String 
		ArrayList <String> list = new ArrayList<String>();
		list.add("\n");
		list.add("\n");
		list.add("\n");
		list.add("Creation of");
		list.add("Automation Framework");
		list.add("Using Java");
		list.add("With Selenium");
		list.add("and TestNG");
		list.add("and Maven Build tool");
		
		WebElement frame= driver.findElement(By.className("learn"));
		this.highlightElement(driver, frame);
			
		for  (String item : list)
			
		{
			
			placeholder.sendKeys("\n");
			placeholder.sendKeys(item);
			placeholder.sendKeys("\n");
						
			this.highlightElement(driver, frame);
			
			
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			
			placeholder.sendKeys(Keys.ENTER);
			
			Robot enter = new Robot();
			enter.keyPress(KeyEvent.VK_ENTER);
			enter.keyRelease(KeyEvent.VK_ENTER);
			
						
							
		}
		
	

		
	}
	
	@Test (priority =3)
	public void selectEntry() 
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement selectEntry = driver.findElements(By.xpath("//input[@class='toggle']")).get(1);
		this.highlightElement(driver, selectEntry);
		action.doubleClick(selectEntry).perform();
		
	}
	
	@Test (priority = 4)
	public void switchStatus() {
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement active = driver.findElement(By.xpath("//a[@href='#/active']"));
		this.highlightElement(driver, active);
		active.click();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement complete = driver.findElement(By.xpath("//a[@href='#/completed']"));
		this.highlightElement(driver, complete);
		complete.click();
		
		
	}
	
	@Test (priority = 5)
		public void clearEntry() {
		
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement all = driver.findElement(By.xpath("//a[@href='#/']"));
		this.highlightElement(driver, all);
		all.click();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement checkbox = driver.findElement(By.className("toggle"));
		this.highlightElement(driver, checkbox);
		checkbox.click();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement clear = driver.findElement(By.className("destroy"));
		this.highlightElement(driver, clear);
		clear.click();
	}
	
	
	@Test (priority =6)
	
	public void editEntry() throws AWTException {
		
		WebElement editText = driver.findElements(By.xpath("//label")).get(3);
		this.highlightElement(driver, editText);
		Actions action = new Actions(driver).doubleClick(editText).sendKeys(" and Appium");
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		Robot enteragain = new Robot();
		enteragain.keyPress(KeyEvent.VK_ENTER);
		enteragain.keyRelease(KeyEvent.VK_ENTER);
		
	
	}
	
	@Test (priority =7 )
//close the browser
	public void closeBrowser() {
		
		WebElement todoapp = driver.findElement(By.className("todoapp"));
		this.highlightElement(driver, todoapp);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.close();
		
	}
	
	

}
