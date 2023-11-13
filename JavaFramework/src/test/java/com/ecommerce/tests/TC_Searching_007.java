package com.ecommerce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HeadersPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.SearchPage;
import com.ecommerce.pages.UserPage;

public class TC_Searching_007 extends Base {

	LoginPage lp;
	UserPage up;
	HeadersPage hp;
	SearchPage sp;
	
	public TC_Searching_007() throws IOException {
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
	
	@Test
	public void validateSearchedProductsName() {
		//Passed static value to search  a product. We can pass via dataloader sheet as well.
		String productToSearch = "Mac";
		hp = new HeadersPage(driver);
		sp = hp.searchRecords(productToSearch);
		boolean bl = sp.checkSearchProductsName(productToSearch);
		Assert.assertEquals(bl, true);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}
