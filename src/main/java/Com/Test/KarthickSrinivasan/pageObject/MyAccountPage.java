package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	@CacheLookup
	@FindBy(xpath= "//*[contains(@class,'account')]")
	WebElement myAccount;
	
	@CacheLookup
	@FindBy(xpath= "//*[contains(@title,'Orders')]")
	WebElement orderHistory;
	
	
	@CacheLookup
	@FindBy(xpath= "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]")
	WebElement latestOrderDetail;
	
	@CacheLookup
	@FindBy(xpath= "//*[contains(@title,'Information')]")
	WebElement personalInformation;
	
	
	
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_myAccount() {
		myAccount.click();
	}
	
	public void navigate_to_order_history() {
		orderHistory.click();
	}
	
	public String getCurrentOrderRefNumber() {
		return latestOrderDetail.getText();
	}
	
	public void navigate_to_PersonalDetails() {
		personalInformation.click();
	}
	
}
