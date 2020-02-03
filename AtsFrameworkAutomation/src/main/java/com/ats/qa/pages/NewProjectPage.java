package com.ats.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ats.qa.base.PageBase;

public class NewProjectPage extends PageBase{
		
		
		public NewProjectPage(WebDriver driver) throws IOException {
			
			super.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void enterBasicProjectDetails(String project,String country, String province,String city,String address, String biddate, String area) throws InterruptedException {
			
			sendElement("projectName", project, 30);
			sendElement("country", country, 30);
			sendElement("province", province, 60);
			sendElement("city", city, 30);
			sendElement("address", address, 30);
			sendElement("bidDate", biddate, 30);
			sendElement("squareFoot", area, 30);
			getElement("nextButton").click();
			
		}
		public void enterBuildingClasses() {
			
			getElement("commercial").click();
			getElement("mall").click();
			getElement("nextButton").click();	
		}
		public void enterCollaborators() {
			
			getElement("briansCompany").click();
			getElement("viewOnly").click();
			getElement("editBox").click();
			getElement("finishButton").click();
			
		}
		public static void validateProjectCreation() {
			
			String actualText = getElement("productCategory").getText();
			Assert.assertEquals(actualText, "Select Product Category");
			System.out.println("All tests completed");
			
		}
		
	}
		
		

	