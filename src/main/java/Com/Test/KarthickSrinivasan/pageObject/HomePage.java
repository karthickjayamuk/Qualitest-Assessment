package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

@CacheLookup
@FindBy(linkText="Sign in")
WebElement signIn;

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void Navigate_to_SignPage() {
	signIn.click();
}

}
