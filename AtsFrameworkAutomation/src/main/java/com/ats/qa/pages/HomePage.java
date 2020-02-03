package com.ats.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.qa.base.PageBase;

public class HomePage extends PageBase{
	
	/* example usage of  @FindBy and PageFactory here
	 */
	
	@FindBy(xpath="//span[contains(text(),'New Project')]")
	WebElement newproject;
	
	public HomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
}
	public void clikonNewProject() {
		newproject.click();
	}
}
