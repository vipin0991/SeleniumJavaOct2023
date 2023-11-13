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
import com.ecommerce.pages.AddAddressPage;
import com.ecommerce.pages.AddressBookListPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.UserPage;
import com.ecommerce.utility.UtilTest;

public class TC_AddAddress_005 extends Base {
	
	LoginPage lp;
	UserPage up;
	AddressBookListPage ablp;
	AddAddressPage aap;
	
	public TC_AddAddress_005() throws IOException {
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
	public void userNavigationAddAddressPage() throws InterruptedException {
		up.addressBookLinkAvailability();
		ablp = new AddressBookListPage(driver);
		aap = ablp.navigateToAddAddress();
		Assert.assertEquals(aap.checkAddAddressPageLoad(), "Add Address");
//		Thread.sleep(5000);
		
	}
	
	//Dataprovider to fetch data from excel
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		System.out.println(p.getProperty("sheet"));
		Object[][] data = UtilTest.getTestData(p.getProperty("sheet"));
		return data;
	}
	
	@Test(dataProvider="getData")
	public void addAddressFields(String fname, String lname, String address1, String city, String pinCode, String regn ) throws InterruptedException {
		up.addressBookLinkAvailability();
		ablp = new AddressBookListPage(driver);
		aap = ablp.navigateToAddAddress();
		aap.enterAddress(fname, lname, address1, city, pinCode, regn);
		Assert.assertEquals(ablp.validateAddressAdded(), "Your address has been successfully added");
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
