package com.ecommerce.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.base.Base;

public class LoginPage{
	
	WebDriver drive;
	
	//this Constructor will initialize all defined elements
	public LoginPage(WebDriver driver) throws IOException{
		drive = driver;
		PageFactory.initElements(drive, this);
	}
	
	
	@FindBy(name="email")
	WebElement email; //driver.findElement(By.name="")
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="[value=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//strong[contains(text(),\"Register Account\")]")
	WebElement registerAccount;	
	
	@FindBy(css=".alert.alert-danger.alert-dismissible")
	WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='well']/a")
	WebElement navigateToRegister;
	
	
	public UserPage login(String uname, String pass) throws IOException {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		return new UserPage(drive);		
	}
	
	public String checksection() {
		return registerAccount.getText();
	}
	
	public String invalidLogin(String uname, String pass) {
		email.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		return errorMsg.getText();
	}
	
	public RegisterPage navigateToRegisterPage() {
		navigateToRegister.click();
		return new RegisterPage(drive);
	}
	

}


