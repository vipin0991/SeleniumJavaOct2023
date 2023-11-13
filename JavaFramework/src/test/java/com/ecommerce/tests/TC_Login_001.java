package com.ecommerce.tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.UserPage;
import com.ecommerce.utility.MyRetry;


public class TC_Login_001 extends Base {
	
	LoginPage lp;
	UserPage up;
	
	TC_Login_001() throws IOException{
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws IOException {		
		initialize(br);
		lp = new LoginPage(driver);
	}
	
	//Test to login into application with valid credentials.
	@Test(priority=1)
	public void loginIntoApplicationTest() throws IOException {
		logger.info("loginIntoApplicationTest : login page is displayed");
		up = lp.login(p.getProperty("username"), p.getProperty("password"));
		boolean link = up.accountLinkAvailability();
		logger.info("loginIntoApplicationTest : User is successfully able to login");
		Assert.assertTrue(link);
	}
	
	//Test to check if register section is displayed on login page
	@Test(priority=2,retryAnalyzer = MyRetry.class)
	public void checkRegisterationSection() {
		logger.info("checkRegisterationSection : login page is displayed");
		String str = lp.checksection();
		logger.info("checkRegisterationSection : Register Account section is displayed");
		Assert.assertEquals(str, "Register Account");	
	}
	
	//Test to check if user is getting error message for invalid login
	@Test(priority=3)
	public void invalid() throws IOException {
		logger.info("Invalid : login page is displayed");
		String str  = lp.invalidLogin(p.getProperty("username"), p.getProperty("ipassword"));
		logger.info("Invalid : Error Message is displayed for invalid login");
		Assert.assertEquals(str, "Warning: No match for E-Mail Address and/or Password.");
	}
	

	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
