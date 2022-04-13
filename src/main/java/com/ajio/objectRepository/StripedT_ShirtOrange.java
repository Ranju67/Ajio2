package com.ajio.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.genericUtility.WebDriverUtility;

public class StripedT_ShirtOrange {

	  @FindBy(xpath="//div[text()='Select Size']/..//span[text()='7-8Y']")
	  private WebElement selectSize;
	  
	  @FindBy(xpath="//span[text()='ADD TO BAG']")
	  private WebElement addtoBagButton;

	 //intialization 
	public  StripedT_ShirtOrange(WebDriver driver){
		PageFactory.initElements(driver, this); 
	  }
	  //getter  
	public WebElement getSelectSize() {
		return selectSize;
	}
	  
	 public WebElement getAddtoBagButton() {
		return addtoBagButton;
	}
	public void selectSizeClick() {
		 selectSize.click();
		 addtoBagButton.click();
	 } 
	  
}
