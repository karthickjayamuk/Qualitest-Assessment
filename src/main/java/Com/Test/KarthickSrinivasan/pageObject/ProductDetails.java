package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetails {
	
	@CacheLookup
	@FindBy(id="quantity_wanted")
	WebElement productQuantity;

	@CacheLookup
	@FindBy(id="group_1")
	WebElement productSize;

	@CacheLookup
	@FindBy(xpath="//*[@id=\"color_14\"]")
	WebElement productColor_Blue;

	@CacheLookup
	@FindBy(xpath="//*[@id=\"color_13\"]")
	WebElement productColor_Orange;

	@CacheLookup
	@FindBy(id="add_to_cart")
	WebElement btnAddtoCart;
	
	@CacheLookup
	@FindBy(linkText="Proceed to checkout")
	WebElement btnProceedtoCheckOut;
	

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setProductDetails(String fieldName,String value) {
		
		if(fieldName.equals("Quantity")) {
			productQuantity.clear();
			productQuantity.sendKeys(value);
		}else if(fieldName.equals("Size")) {
			Select sizeDropDown=new Select(productSize);
			sizeDropDown.selectByVisibleText(value);
		}else if(fieldName.equals("Color")) {
			
			if(value.equals("Blue")) {
				productColor_Blue.click();
			}else if(value.equals("Orange")) {
				productColor_Orange.click();
			}
		}
		
	}
	
	public void addtoCart() {
		btnAddtoCart.click();
	}
	
	public void proceed_to_checkOut() {
		btnProceedtoCheckOut.click();
	}
	
}
