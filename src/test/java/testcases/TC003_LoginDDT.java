package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")//getting data provider from different package
	public void verify_loginDDT(String email, String pwd, String exp) {
		try {
		logger.info("********Starting TC003_LoginDDT**********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		
		lp.setPassword(pwd);
		lp.clickLogin();
		//MyAccount
		MyAccount john=new MyAccount(driver);
		boolean targetPage=john.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				john.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				john.clickLogout();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
				
			}
			
			
			
		}
		}catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("********Finished TC003_LoginDDT**********");
		
	
	}
	
	
	
	

}
