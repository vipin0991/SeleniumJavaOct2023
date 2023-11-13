package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookListPage {
	
	WebDriver driver;
	
	public AddressBookListPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement newAddress;
	
	@FindBy(css=".alert.alert-success.alert-dismissible")
	WebElement recordAddedMsg;
	
	@FindBy(xpath="//tbody/tr/td[@class='text-left']")
	List<WebElement> addressDetails;
	
	@FindBy(css="[data-original-title='Delete']")
	List<WebElement> deleteBtn;
	
	public AddAddressPage navigateToAddAddress() {
		newAddress.click();
		return new AddAddressPage(driver);
	}
	
	public String validateAddressAdded() {
		return recordAddedMsg.getText();
	}
	
	public void clickDelete(String record) throws InterruptedException {
		for(int i=0;i<addressDetails.size();i++) {
			if(addressDetails.get(i).getText().contains(record)) {
//				System.out.println(addressDetails.get(i).getText());
				deleteBtn.get(i).click();
				driver.switchTo().alert().accept();
				Thread.sleep(4000);
				break;
			}
		}
	}
	
	//Your address has been successfully deleted


}
