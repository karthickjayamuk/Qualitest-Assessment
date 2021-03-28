package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	@CacheLookup
	@FindBy(linkText="Proceed to checkout")
	WebElement btnProceedtoCheckOut;
	
	@FindBy(xpath= "//*[contains(@name,'processAddress')]")
	WebElement btnAddressCheckOut;
	
	@FindBy(xpath= "//*[contains(@name,'processCarrier')]")
	WebElement btnShippingCheckOut;
	
	@CacheLookup
	@FindBy(id="cgv")
	WebElement checkBoxTermsOfService;
	

	@CacheLookup
	@FindBy(xpath= "//*[contains(@title,'Pay by bank wire')]")
	WebElement payByBankWire;
	
	@CacheLookup
	@FindBy(xpath= "//*[contains(@title,'Pay by check.')]")
	WebElement payByCheck;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement confirmOrder;
	
	
	
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void proceed_to_checkout() {
		btnProceedtoCheckOut.click();
	}
	
	public void proceed_to_address_checkout() {
		btnAddressCheckOut.click();
	}
	public void proceed_to_shipping_checkout() {
		btnShippingCheckOut.click();
	}
	
	
	
	public void checkTerms_of_service() {
		checkBoxTermsOfService.click();
	}
	
	public void CompletePayment(String paymentMode) {
		if(paymentMode.equals("Pay by Bank wire")) {
			payByBankWire.click();
		}else if(paymentMode.equals("Pay by check")) {
			payByCheck.click();
		}
	}
	
	public void confirmOrder() {
		confirmOrder.click();
	}
}
