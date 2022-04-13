package com.ajio.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KidsPage {
  @FindBy(xpath="//a[@href='/s/starting-at-rs-199-4625-8751']")
  private WebElement topsAndTess;
  
//3
 public KidsPage(WebDriver driver){
	  PageFactory.initElements(driver, this);
  }
//4
public WebElement getTopsAndTess() {
	return topsAndTess;
}
public void clicktopsAndTess() {
	topsAndTess.click();
}
  
}
