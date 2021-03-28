package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {
	
	@CacheLookup
	@FindBy(id= "firstname")
	WebElement firstName;
	
	@CacheLookup
	@FindBy(xpath= "//*[contains(@name,'submitIdentity')]")
	WebElement btnSave;
	
	@CacheLookup
	@FindBy(id= "old_passwd")
	WebElement currentPassword;
	
	
	
	@CacheLookup
	@FindBy(xpath= "//*[@id=\"center_column\"]/div")
	WebElement confirmationInfo;
	
	
	public PersonalInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void updateFirstName(String newName) {
		firstName.clear();
		firstName.sendKeys(newName);
	}
	
	public void saveAccountUpdate() {
		btnSave.click();
	}
	
	public String getConifrmationMessage() {
		return confirmationInfo.getText();
	}
	
	public void enterCurrentPassword(String password) {
		currentPassword.sendKeys(password);
	}

}
