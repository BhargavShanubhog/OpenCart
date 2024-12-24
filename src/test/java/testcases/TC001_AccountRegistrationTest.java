package testcases;

import org.apache.commons.lang3.RandomStringUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("*****Starting TC001_AccountRegistrationTest *****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage rpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		rpage.setFN(randomeString().toUpperCase());
		rpage.setLN(randomeString().toUpperCase());
		rpage.setEmail(randomeString()+"@gmail.com");
		rpage.setPassword(randomePassword());
		rpage.setAgreeicon();
		rpage.setContButton();
		
		logger.info("Validating expected message......");
		String h=rpage.msg();
		if(h.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			
		}
		
		
		}catch(Exception e) {
			
			Assert.fail();
		}
		
	}
	
	

}
