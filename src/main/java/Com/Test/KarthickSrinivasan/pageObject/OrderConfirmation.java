package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {
	//	@FindBy(xpath= "//*[@id='center_column']/div/text()[6]")

	@CacheLookup	
	@FindBy(xpath="//*[@id=\"center_column\"]/div")
	WebElement confirmationRefNumber;
	
	
	public OrderConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmationRefNumber() {
		String confirmationBox=confirmationRefNumber.getText();
		int refNoStartIndex=confirmationBox.indexOf("order reference", 0);
		int refNoEndIndex=confirmationBox.indexOf("in the subject of your bank wire", 0);
		return confirmationBox.substring(refNoStartIndex, refNoEndIndex).replace("order reference", "").trim();		
	}
	
	
}
