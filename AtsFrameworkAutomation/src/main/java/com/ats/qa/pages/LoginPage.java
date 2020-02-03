package com.ats.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ats.qa.base.PageBase;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver)throws IOException {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginPage(String username, String pass) throws IOException {
		getElement("userName").sendKeys(username);
		getElement("password").sendKeys(pass);
		getElement("buttonSubmit").click();
		return new HomePage(super.driver);
	}

}
