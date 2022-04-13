package com.ajio.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ajio.genericUtility.WebDriverUtility;

public class StartingAtRs199 {

	@FindBy(xpath="//div[@class='filter-dropdown']/..//Select")
	private WebElement sortByDropDwn;

	@FindBy(xpath="//img[@src='https://assets.ajio.com/medias/sys_master/root/20210810/4Mj2/6112991eaeb269a2686e9eb6/diesel_kids_green_tjusta38_tie-dye_crew-neck_t-shirt_with_reflective_print.jpg']")
	private WebElement greenTshirt;
	//3
	public StartingAtRs199(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//4

	public WebElement getsortByDropDwn() {
		return sortByDropDwn;
	}
	public WebElement getOrangeTshirt() {
		return greenTshirt;
	}
	//2
	//using Select class
	public void SortByDrpDwnClick() {
		sortByDropDwn.click();
		WebDriverUtility.select(sortByDropDwn, 3);
		greenTshirt.click();
	}
	public static void switchToWindow(WebDriver driver,String partialText) {
		WebDriverUtility.switchToWindow(driver, partialText);
	}
	
}
