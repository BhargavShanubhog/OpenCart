package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtUsername;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement useremail;
	@FindBy(xpath="//input[@id='input-password']") WebElement userpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement agreeicon;
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement contBut;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement mdgConfirm;
	
	
	public void setFN(String fname) {
		txtUsername.sendKeys(fname);
	}
	
	public void setLN(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		useremail.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		userpassword.sendKeys(pass);
	}
	
	public void setAgreeicon() {
		agreeicon.click();
	}
	
	public void setContButton() {
		contBut.click();
	}
	
	public String msg() {
		try {
			return(mdgConfirm.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
		
	}
	
	

}
