package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("*****Starting TC002_LoginTest********");
		try {
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		//MyAccount
		MyAccount john=new MyAccount(driver);
		boolean targetPage=john.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login Failed");
		}catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("*******Finished TC002_LoginTest**********");
		
		
		
		
	}

}
