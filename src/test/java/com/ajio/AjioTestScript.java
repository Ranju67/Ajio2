package com.ajio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ajio.genericUtility.ConstantPath;
import com.ajio.genericUtility.FileUtility;
import com.ajio.genericUtility.WebDriverUtility;
import com.ajio.objectRepository.HomePage;
import com.ajio.objectRepository.KidsPage;
import com.ajio.objectRepository.ShoppingBagPage;
import com.ajio.objectRepository.StartingAtRs199;
import com.ajio.objectRepository.StripedT_ShirtOrange;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioTestScript {  

	public static void main(String[] args) throws Throwable {

		FileUtility.intiallizePropertyFile(ConstantPath.propertyFilePath);
		String url = FileUtility.fetchDataFromProperty("url");
		String browser=FileUtility.fetchDataFromProperty("browser");
		String timeouts = FileUtility.fetchDataFromProperty("timeouts");
		long timeoutsLong=Long.parseLong(timeouts);




		//notification popup
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifiations");
		
		WebDriver driver=null;
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

		//configure the browser
		WebDriverUtility wu=new WebDriverUtility();

		wu.maximizeBrowser(driver);
		wu.waitForPageLaoad(driver, timeoutsLong);
		wu.launchApplication(driver, url, timeoutsLong);

		HomePage hmpg=new HomePage(driver);
		hmpg.kidslink();

		//Kids
		KidsPage kpg=new KidsPage(driver);
		kpg.clicktopsAndTess();

		//priceDrpDwn
		StartingAtRs199 stpg=new StartingAtRs199(driver);
		stpg.SortByDrpDwnClick();
		stpg.switchToWindow(driver, browser);

		//
		StripedT_ShirtOrange tso=new StripedT_ShirtOrange(driver);
		tso.selectSizeClick();
		
		//
		ShoppingBagPage sbpg=new ShoppingBagPage(driver);
		sbpg.cart(driver);
		sbpg.cartBag();
		sbpg.deleteButton();
		sbpg.deletConfirm();

	}
}