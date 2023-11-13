package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.utility.UtilTest;

public class RegisterPage {
	
	public WebDriver driver;
	
	//Constructor to initialize webelement and driver
	public RegisterPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="h1")
	WebElement registerPageHeading;
	
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement emaill;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement cpassword;
	
	@FindBy(name="agree")
	WebElement privacyPolicy;
	
	@FindBy(css="[value='Continue']")
	WebElement continueBtn;
	
	public String checkHeading() {
		return registerPageHeading.getText();
	}
	
	public UserRegistrationConfirmationPage registerUser(String fname, String lname, String phone, String pass, String cpass) {
		String randomEmail = "testUser_"+UtilTest.generateRandom()+"@gmail.com";
		System.out.println(randomEmail);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		emaill.sendKeys(randomEmail);
		telephone.sendKeys(phone);
		password.sendKeys(pass);
		cpassword.sendKeys(cpass);
		privacyPolicy.click();
		continueBtn.click();	
		return new UserRegistrationConfirmationPage(driver);
	}

}
