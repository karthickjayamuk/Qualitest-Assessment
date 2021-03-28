package Com.Test.KarthickSrinivasan.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPane {


@CacheLookup
@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
WebElement tShirts;

@CacheLookup
@FindBy(partialLinkText="Women")
WebElement women;


@CacheLookup
@FindBy(partialLinkText="Dresses")
WebElement dresses;

	
	public NavigationPane(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to(String pageName) {
		if(pageName.equals("T-SHIRTS")) {
			tShirts.click();
		}
		else if(pageName.equals("DRESSES")) {
			dresses.click();
		}else if(pageName.equals("WOMEN")) {
			women.click();
		}
	}
}
