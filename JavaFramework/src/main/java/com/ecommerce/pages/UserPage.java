package com.ecommerce.pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.base.Base;

public class UserPage{

	WebDriver d;
	HeadersPage hp;
	
	public UserPage(WebDriver driver) throws IOException {
		d = driver;
		PageFactory.initElements(d, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	WebElement editAccountLink;
	
	@FindBy(xpath="//*[@class='list-group']/a[contains(@href,'address')]")
	WebElement addressBookLink;
	
	@FindBy(css="[title='naveenopencart']")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Components']")
	WebElement components;
	
	@FindBy(xpath="//a[contains(@href,'25_28')]")
	WebElement monitor;
	
	public boolean accountLinkAvailability() {
		return editAccountLink.isDisplayed();
	}
	
	public boolean addressBookLinkAvailability() {
		addressBookLink.click();
		return addressBookLink.isDisplayed();
	}
	
	public boolean logoDisplay() {
		return logo.isDisplayed();
	}
	
	public boolean validateTopNavigationLinks() {
		String[] l = {"Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"};
		 List li2 = Arrays.asList(l);
		
		 hp = new HeadersPage(d);
		 List<WebElement> li = hp.headerlinks();
		 System.out.println(li.size());
		 
		 for(int i=0;i<li.size();i++) {
			 
			 String actualLink = li.get(i).getText();
			 System.out.println(actualLink);
			 
			 if(!li2.contains(actualLink)) {
				return false;
			 }
		 }
		 return true;
	}
	
	public MonitorPage navigateToMonitor() {
		Actions a = new Actions(d);
		a.moveToElement(components).build().perform();
		monitor.click();
		return new MonitorPage(d);
	}

}
