package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@CacheLookup
	@FindBy(id="email")
	WebElement eMailAddress;


	@CacheLookup
	@FindBy(id="passwd")
	WebElement password;
	
	
	
	@CacheLookup
	@FindBy(id="SubmitLogin")
	WebElement btnSubmit;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seteMailAddress(String userName) {
		eMailAddress.sendKeys(userName);
	}
	
	public void setPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void accountLogin(String userName, String password) {
		seteMailAddress(userName);
		setPassword(password);
		btnSubmit.click();
	}
	
	
	
	
}
