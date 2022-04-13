package com.ajio.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 
	@FindBy(linkText="KIDS")
  private WebElement kidsLink;

	
	@FindBy(xpath="//div[@class='delete-btn']")
	private WebElement deletButton;
	
	//3
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getter
	public WebElement getKidsLink() {
		return kidsLink;
	}
	
	public WebElement getDeletButton() {
		return deletButton;
	}

	//2
	public void kidslink() {
		kidsLink.click();
	}
	public void deleteClick() {
		deletButton.click();
	}
	

}
