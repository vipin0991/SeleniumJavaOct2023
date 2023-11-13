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
import com.ecommerce.pages.AddressBookListPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.UserPage;
import com.ecommerce.utility.UtilTest;

public class TC_DeleteAddress_006 extends Base {
	
	LoginPage lp;
	UserPage up;
	AddressBookListPage ablp;

	public TC_DeleteAddress_006() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws IOException {
		initialize(br);
		lp = new LoginPage(driver);
		up = lp.login(p.getProperty("username"), p.getProperty("password"));
		up.addressBookLinkAvailability();
		ablp = new AddressBookListPage(driver);
	}
	
	@DataProvider
	public Object[][] getRecords() throws EncryptedDocumentException, IOException{
		Object[][] obj = UtilTest.getTestData(p.getProperty("deleteRecordSheet"));
		return obj;
	}
	
	//This test should be executed after adding data.
	//To delete records using dataProvider. First record will be added using same excel workbook dataProvider
	@Test(dataProvider="getRecords")
	public void deleteAddressRecord(String record) throws InterruptedException {
		ablp.clickDelete(record);
		Assert.assertEquals(ablp.validateAddressAdded(),"Your address has been successfully deleted");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	

}
