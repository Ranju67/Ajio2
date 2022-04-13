package com.ajio.genericUtility;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.google.common.io.Files;


/**
 * This class is a collection of webdriver actions
 * @author SHASHI KUMAR
 *
 */
public class WebDriverUtility {

public static WebDriver launchBrowserWithMaximize(WebDriver driver,String url,String browser,long timeout) 
	{
		//notification popup
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifiations");

		//RunTime Polymorphism
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Browser is not specified Properly");
		}
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	/**
	 * This Method is used to wait implicit for specified time
	 * @param driver
	 * @param timeout
	 */
	public static void waitForPageLaoad(WebDriver driver,long timeout ) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait  until element visible
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	public static void waitUnitlElementVisible(WebDriver driver,long timeout,WebElement element ) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to wait  until element visible with specific polling time
	 * @param driver
	 * @param timeout
	 * @param element
	 * @param pollingTimeout
	 */
	public static void waitUnitlElementVisibleWithCustomPoll(WebDriver driver,long timeout,WebElement element,long pollingTimeout )  {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(Duration.ofSeconds(pollingTimeout));
		wait.ignoring(Throwable.class);
	}

	/**
	 * This method will maximize the browser window 
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	} 

	/**
	 * This method will used to open the application with maximize  
	 * @param driver
	 * @param url
	 * @param timeout
	 */
	public static void launchApplicationWithMaximize(WebDriver driver,String url,long timeout) {
		driver.get(url);
		maximizeBrowser(driver);
		waitForPageLaoad(driver, timeout); 
	}

	/**
	 * This method will used to open the application 
	 * @param driver
	 * @param url
	 * @param timeout
	 */
	public static void launchApplication(WebDriver driver,String url,long timeout) {
		driver.get(url);
		waitForPageLaoad(driver, timeout); 
	}
	/**
	 * This method is used to switch to the particular window
	 * @param driver
	 * @param partialTitleText
	 */
	public static void switchToWindow(WebDriver driver,String partialTitleText) {
		Set<String> winIDs2=driver.getWindowHandles();
		for (String id : winIDs2) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialTitleText)) {
				break;
			}
		}
	}
	/**
	 * This method is used to move to  the cursor on element 
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to right click on element
	 * @param driver
	 * @param element
	 */
	public static void rightClickonElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * Thia method is used to select the dropdown option by index
	 * @param element
	 * @param index
	 */
	public static void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * Thia method is used to select the dropdown option by visbleText
	 * @param element
	 * @param visble
	 */
	public static void select(WebElement element,String visbleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visbleText);
	}
	/**
	 * Thia method is used to select the dropdown option by value 
	 * @param value
	 * @param element
	 */
	public static void select(String value,WebElement element) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to quit the browser instance
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public static void frame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame by nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	public static void frame(WebDriver driver,String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to switch the frame by element
	 * @param driver
	 * @param element
	 */
	public static void frame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is created to oen the application through Javascript
	 * @param driver
	 * @param url
	 */
	public static void openApplicationThroughJS(WebDriver driver,String url) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.location='"+url+"'");
	}

	/**
	 * This method is created to send the data into perticular textfield through Javascript
	 * @param driver
	 * @param element
	 * @param input
	 */
	public static void javaScriptSendkeysThrough(WebDriver driver,WebElement element,String input) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+input+"'",element);
	}

	/**
	 * This method is created to click on the button/element through Javascript
	 * @param driver
	 * @param element
	 */
	public static void clickActionThroughJS(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",element);
	}

	/**
	 * This method is created to scroll the webpage until the element is present
	 * @param driver
	 * @param element
	 */
	public static void scrollTillElementTroughJS(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",element);
	}
	public static void scrollDownToPageThroughJS(WebDriver driver,String upOrDown) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,"+upOrDown+"document.body.scrollHeight)");
	}
	/**
	 * this method is used to return the poptext
	 * @param driver
	 * @return
	 */
	public static String getTextAlertPopup(WebDriver driver) {
		String popuptext=driver.switchTo().alert().getText();
		return popuptext;
	}
	/**
	 * This method is used to dimiss the alert
	 * @param driver
	 */
	public static void dismissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to getthe  text 
	 * @param driver
	 */
	public static void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

}