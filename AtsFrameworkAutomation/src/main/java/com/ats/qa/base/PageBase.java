package com.ats.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends TestBase {
	
	public PageBase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	protected static WebDriver driver;

	public WebElement waitForElement(String element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty(element)))));
		return element1;
		
	}
	public WebElement sendElement(String xpath,String text, int sec) {
		
		WebDriverWait wait = new WebDriverWait(driver, sec);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty(xpath)))));
		element.sendKeys(text);
		return element; 
	}
	
	public static WebElement getElement(String element) {
		
		WebElement ele = driver.findElement(By.xpath(prop.getProperty(element)));
		return ele;
	}

}
