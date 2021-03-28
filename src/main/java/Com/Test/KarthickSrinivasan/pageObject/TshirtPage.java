package Com.Test.KarthickSrinivasan.pageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage {


@CacheLookup
@FindAll(@FindBy(xpath= "//*[contains(@class,'product-name')]"))    
List<WebElement> tShirtProductsList;
	
public TshirtPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void selectProduct(String productName) {
	WebElement myProduct = null;
	for(WebElement tShirt:tShirtProductsList) {
		if(tShirt.getText().equals(productName)) {
			myProduct=tShirt;
			break;
		}
		
	}
	if(myProduct!=null) {
	myProduct.click();
	}else {
		Assert.fail("Product Not Found: " +productName);
	}

}


}
