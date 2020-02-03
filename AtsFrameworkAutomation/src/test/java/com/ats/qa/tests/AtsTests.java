package com.ats.qa.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.HomePage;
import com.ats.qa.pages.LoginPage;
import com.ats.qa.pages.NewProjectPage;

public class AtsTests extends TestBase{
	
	public AtsTests() throws IOException {
		super();
	}
	
	@Test(priority=1)
	public void loginPageTest() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(super.driver);
		HomePage hp=new HomePage(super.driver);
		lp.loginPage("dovini5510@one-mail.top","Ats123456")
		.clikonNewProject();
       NewProjectPage np=new NewProjectPage(super.driver);
       np.enterBasicProjectDetails("MyProject", "Canada", "Ontario", "Milton", "155 Ontario st", "2020-01-31", "10000");
       np.enterBuildingClasses();
       np.enterCollaborators();
       
      //Calling method from NewProjectPage 
       NewProjectPage.validateProjectCreation();
	}
	
}
