package com.ajio.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.genericUtility.WebDriverUtility;

public class ShoppingBagPage {

	@FindBy(xpath="//div[@class='ic-cart ']")
	private WebElement cart;
	
	@FindBy(xpath="//div[@class='mini-cart-btn']")
	private WebElement cartBag;

	@FindBy(xpath="//div[@class='delete-btn']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//div[text()='DELETE']")
private WebElement deletConfirm;
	
	//3
	public ShoppingBagPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//getter utilization
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public WebElement getCart() {
		return cart;
	}
	public WebElement getCartBag() {
		return cartBag;
	}
	public WebElement getDeletConfirm() {
		return deletConfirm;
	}
	//business library
	public void deleteButton() {
		deleteButton.click();
	}
	public void cart(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, cart);
	}
	public void cartBag() {
		cartBag.click();
	}
public void deletConfirm() {
	deletConfirm.click();
}
}
