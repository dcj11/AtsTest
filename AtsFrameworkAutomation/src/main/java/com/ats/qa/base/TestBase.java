package com.ats.qa.base;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ats.qa.utils.TestUtil;

public class TestBase {
	protected WebDriver driver;
	public static Properties prop;
	private String browserName;
	
	public TestBase() throws IOException {
		prop=new Properties();
		try {
			InputStream propertiesStream = getClass().getResourceAsStream("/com/ats/qa/config/config.properties");
			if(propertiesStream != null) {
				prop.load(propertiesStream);
			} else {
				System.out.println("properties file not found");
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void beforeSuite() {
		browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/geckodriver.exe");	
		}
		
		
	}
	@BeforeMethod
	public void initialization() {

		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
}