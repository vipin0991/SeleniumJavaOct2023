package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage {
	
	WebDriver driver;
	
	AddAddressPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="h2")
	WebElement addAddressPageHeading;
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-address-1")
	WebElement address1;
	
	@FindBy(id="input-city")
	WebElement city;
	
	@FindBy(id="input-postcode")
	WebElement postCode;
	
	@FindBy(id="input-country")
	WebElement country;
	
	@FindBy(id="input-zone")
	WebElement regionState;
	
	@FindBy(css="[value='Continue']")
	WebElement continueBtn;
	
	
	public String checkAddAddressPageLoad() {
		return addAddressPageHeading.getText(); 
	}
	
	public AddressBookListPage enterAddress(String fname, String lname, String address, String cy,String pcode, String regn) throws InterruptedException {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address1.sendKeys(address);
		city.sendKeys(cy);
		postCode.sendKeys(pcode);
		Select count = new Select(country);
		count.selectByValue("2");
		Select reg = new Select(regionState);
		reg.selectByVisibleText(regn);		
		continueBtn.click();		
		return new AddressBookListPage(driver);
		
		
	}
	
	
	
	
}
