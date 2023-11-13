package com.ecommerce.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HeadersPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.UserPage;

public class TC_UserPage_002 extends Base {

	public LoginPage lp;
	UserPage up;
	HeadersPage hp;

	public TC_UserPage_002() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws IOException {
		initialize(br);
		lp = new LoginPage(driver);
		up = lp.login(p.getProperty("username"), p.getProperty("password"));
	}

	//Test to check is Address Book link is available on user page.
	@Test
	public void checkUserPageLinks() {
		boolean av = up.addressBookLinkAvailability();
//		Assert.assertTrue(av);
		Assert.assertTrue(false);
	}
	
	//Test to check if header links are same once user login into the application.
	@Test
	public void validateHeaderLinks() {
		boolean val = up.validateTopNavigationLinks();
		 Assert.assertTrue(val);
		 
	}
	
	//Test to check if logo is appeared after login into the application.
	@Test
	public void validateLogo() {
		boolean val = up.logoDisplay();
		Assert.assertTrue(val);
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
