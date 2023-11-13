package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorPage {
	
	WebDriver driver;
	
	public MonitorPage(WebDriver d){
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="h2")
	WebElement monitor;
	
	@FindBy(xpath="//h4/a")
	List<WebElement> monitorProdcuts;
	
	public String checkMonitorPage() {
		return monitor.getText();
	}

	
	public int checkMonitorsProduct(){
		return monitorProdcuts.size();
	}
}
