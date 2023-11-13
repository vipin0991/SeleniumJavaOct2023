package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadersPage {
	
	WebDriver driver;
	
	public HeadersPage(WebDriver driv){
		driver=driv;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a")
	List<WebElement> links;
	
	@FindBy(css="[placeholder='Search']")
	WebElement searchField;
	
	@FindBy(css="span.input-group-btn")
	WebElement searchBtn;
	
	@FindBy(css="#cart-total")
	WebElement cartTotalIcon;
	
	@FindBy(css="strong .fa.fa-share")
	WebElement checkoutIcon;
	
	public List<WebElement> headerlinks() {
		return links;
	}
	
	public SearchPage searchRecords(String prod) {
		searchField.sendKeys(prod);
		searchBtn.click();
		return new SearchPage(driver);
	}
	
	public CheckoutPage navigateToCheckout() {
		cartTotalIcon.click();
		checkoutIcon.click();
		return new CheckoutPage(driver);
		
		
	}

}
