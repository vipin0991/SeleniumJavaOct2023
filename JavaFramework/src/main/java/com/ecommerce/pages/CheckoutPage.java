package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	CheckoutPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-payment-address")
	WebElement paymentAddress;

	@FindBy(id="button-shipping-address")
	WebElement shippingAddress;
	
	@FindBy(id="button-shipping-method")
	WebElement shippingMethod;
	
	@FindBy(css="[name='agree']")
	WebElement termsCondition;
	
	@FindBy(id="button-payment-method")
	WebElement paymentMethod;	
	
	@FindBy(id="button-confirm")
	WebElement confirmOrder;	
	
	public PlaceOrderPage confirmOrder() {
		paymentAddress.click();
		shippingAddress.click();
		shippingMethod.click();
		termsCondition.click();
		paymentMethod.click();
		confirmOrder.click();
		return new PlaceOrderPage(driver);		
		
	}
	

}
