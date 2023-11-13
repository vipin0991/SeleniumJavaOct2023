package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {

	WebDriver driver;
	
	PlaceOrderPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#content h1")
	WebElement placeOrderText;
	
	public String confirmPlaceOrder() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println(placeOrderText.getText());
		return placeOrderText.getText();
	}
	
}
