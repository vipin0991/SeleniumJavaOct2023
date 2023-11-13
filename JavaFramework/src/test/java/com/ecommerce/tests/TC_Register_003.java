package com.ecommerce.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.pages.UserRegistrationConfirmationPage;
import com.ecommerce.utility.UtilTest;

public class TC_Register_003 extends Base {
	
	LoginPage lp;
	RegisterPage rp;
	UserRegistrationConfirmationPage urcp;

	public TC_Register_003() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws IOException {
		initialize(br);
		lp = new LoginPage(driver);
		rp = lp.navigateToRegisterPage();
//		up = lp.login(p.getProperty("username"), p.getProperty("password"))
	}
	
	//Verify that use is successfully landed on Register page
	@Test
	public void checkRegisterUserNavigation() {
		Assert.assertEquals(rp.checkHeading(), "Register Account");	
	}
	

	
	
	//verify that user is able to register an account successfully after fetching email from random generator utility
	@Test
	public void validateUserRegisteration() {
		urcp = rp.registerUser("testuser", "testuser_l", "9876543210", "sampletest", "sampletest");
		Assert.assertEquals(urcp.checkheading(), "Your Account Has Been Created!");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
