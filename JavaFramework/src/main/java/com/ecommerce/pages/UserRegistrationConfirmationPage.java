package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationConfirmationPage {
	
	WebDriver driver;
	
	UserRegistrationConfirmationPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.TAG_NAME, using="h1")
	WebElement heading;
	
	public String checkheading() {
		return heading.getText();
	}

}
