package sampleDMProject;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class utilities {
	
	  ChromeDriver drivers;
	 
	  
public ChromeDriver driver() {
		
		//replace <PathofthechromeDriver> to exact location of the chromedriver
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\BD_satyendra.mani\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
				
	}
	
	public void killProcess( ) 
    {
        try
        {
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
           
        } 
        catch (Exception e) 
        {

            e.printStackTrace();
        }
    }
	
	public  void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid blue;');", element);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
		 System.out.println(e.getMessage());
		} 
		 js.executeScript("arguments[0].setAttribute('style','border: solid 2px black');", element);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", element);
	
}
	
	
	}
	
	
	
	 
	
	
	


