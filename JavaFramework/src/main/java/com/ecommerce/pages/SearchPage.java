package com.ecommerce.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(css="h4 a")
	List<WebElement> productsName;
	
	@FindBy(css="button[type='button'] .hidden-xs.hidden-sm.hidden-md")
	List<WebElement> addToCart;
	
	public boolean checkSearchProductsName(String prod) {
		for(int i=0;i<productsName.size();i++) {
			System.out.println(productsName.get(i).getText());
			if(!productsName.get(i).getText().contains(prod)) {
				return false;
			}
			
		}
		return true;
	}
	
	public void addProductsToCart(String[] dprod) throws InterruptedException {
		for(int i=0;i<productsName.size();i++) {
			String prod = productsName.get(i).getText();
			List<String> li = Arrays.asList(dprod);
			if(li.contains(prod)) {
				addToCart.get(i).click();
				Thread.sleep(1000);
			}
			
		}
	}


}