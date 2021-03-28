package Com.Test.KarthickSrinivasan.stepDefinitions;

import java.util.HashMap;

import Com.Test.KarthickSrinivasan.util.SessionData;
import Com.Test.KarthickSrinivasan.util.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookSteps extends WebDriverUtil{

	@Before
	public void beforeTest(Scenario scenario) {		
	this.setWebDriver("Chrome");
	SessionData.setSessionData(new HashMap<String,String>());
	}
	
	@After
	public void afterTest(Scenario scenario) {
		WebDriverUtil.getWebdriver().close();
	}
	
	@AfterStep
	public void afterTestStep( ) {
		
	}
	
	
}
