package Com.Test.KarthickSrinivasan.stepDefinitions;

import Com.Test.KarthickSrinivasan.pageObject.HomePage;
import Com.Test.KarthickSrinivasan.pageObject.LoginPage;
import Com.Test.KarthickSrinivasan.pageObject.MyAccountPage;
import Com.Test.KarthickSrinivasan.pageObject.NavigationPane;
import Com.Test.KarthickSrinivasan.pageObject.OrderConfirmation;
import Com.Test.KarthickSrinivasan.pageObject.OrderPage;
import Com.Test.KarthickSrinivasan.pageObject.PersonalInfo;
import Com.Test.KarthickSrinivasan.pageObject.ProductDetails;
import Com.Test.KarthickSrinivasan.pageObject.TshirtPage;
import Com.Test.KarthickSrinivasan.util.SessionData;
import Com.Test.KarthickSrinivasan.util.WebDriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;


public class Steps{
	
	
	@Given("I am at the ProductHomePage {string}")
	public void i_am_at_the_product_home_page(String pageUrl) {
		WebDriverUtil.getWebdriver().get(pageUrl);
	    
	}
	
	@Given("I click SignIn button")
	public void i_click_sign_in_button() {
	    HomePage homePage=new HomePage(WebDriverUtil.getWebdriver());
	    homePage.Navigate_to_SignPage();	    
	    assertThat(WebDriverUtil.getWebdriver().getTitle(), equalTo("Login - My Store"));
	}


	
	@Given("I Login with eMail {string} and password {string}")
	public void i_login_with_username_and_password(String usereMail, String password) {	   
	   LoginPage loginPage=new LoginPage(WebDriverUtil.getWebdriver());
	   loginPage.accountLogin(usereMail, password);		
		assertThat(WebDriverUtil.getWebdriver().getTitle(), equalTo("My account - My Store"));
	}
	
	
	
	@Given("I navigate to {string} page")
	public void i_navigate_to_page(String pageName) {
	    NavigationPane navigationPane=new NavigationPane(WebDriverUtil.getWebdriver());
	    navigationPane.navigate_to(pageName);
	    assertThat(WebDriverUtil.getWebdriver().getTitle(), equalToIgnoringCase(pageName+" - My Store"));
	}
	@When("I choose {string} tShirt product")
	public void i_choose_product(String productName) {
	    TshirtPage tshirtPage=new TshirtPage(WebDriverUtil.getWebdriver());
	    tshirtPage.selectProduct(productName);
	    assertThat(WebDriverUtil.getWebdriver().getTitle(), equalToIgnoringCase(productName+" - My Store"));
	}
	@When("Update productDetails")
	public void update_product_details(io.cucumber.datatable.DataTable dataTable) {
		ProductDetails productDetails = new ProductDetails(WebDriverUtil.getWebdriver());
	   List<List<String>> updateValuesList = dataTable.asLists();
	   for(int i=0;i<updateValuesList.size();i++) {
		  List<String> fieldName= updateValuesList.get(i);
		  productDetails.setProductDetails(fieldName.get(0), fieldName.get(1));		  
	   }
	}
	@When("add product into Cart")
	public void add_product_into_cart() {
		ProductDetails productDetails = new ProductDetails(WebDriverUtil.getWebdriver());
		   productDetails.addtoCart();
		   productDetails.proceed_to_checkOut();
		   assertThat(WebDriverUtil.getWebdriver().getTitle(), equalTo("Order - My Store"));			
	    
	}
	@When("complete the checkout and payment using {string}")
	public void complete_the_checkout(String paymentMode) {
	    OrderPage orderPage=new OrderPage(WebDriverUtil.getWebdriver());
	    orderPage.proceed_to_checkout();
	    orderPage.proceed_to_address_checkout();
	    orderPage.checkTerms_of_service();
	    orderPage.proceed_to_shipping_checkout();
	    orderPage.CompletePayment(paymentMode);
	    orderPage.confirmOrder();
	    assertThat(WebDriverUtil.getWebdriver().getTitle(), equalTo("Order confirmation - My Store"));
	}

	@Then("I get the order Reference number")
	public void i_get_the_order_reference_number() {
		OrderConfirmation orderConfirmation=new OrderConfirmation(WebDriverUtil.getWebdriver());		
		SessionData.addData("ReferenceNumber", orderConfirmation.getConfirmationRefNumber());
	    
	}
	@Then("verify order exist in Order History")
	public void verify_order_exist_in_order_history() {
	    
	    MyAccountPage myAccountPage=new MyAccountPage(WebDriverUtil.getWebdriver());
	    myAccountPage.navigate_to_myAccount();
	    myAccountPage.navigate_to_order_history();
	    assertThat(myAccountPage.getCurrentOrderRefNumber(), equalTo(SessionData.getData("ReferenceNumber")));
	}
	
	@Given("I click MyAccount")
	public void i_click_my_account() {
		MyAccountPage myAccountPage=new MyAccountPage(WebDriverUtil.getWebdriver());
	    myAccountPage.navigate_to_myAccount();	    
	}
	@Given("I click My Personal Information")
	public void i_click_my_personal_information() {
		MyAccountPage myAccountPage=new MyAccountPage(WebDriverUtil.getWebdriver());
		myAccountPage.navigate_to_PersonalDetails();	    	    
	}
	@When("I Update my firstName as {string}")
	public void i_update_my_first_name_as(String newName) {
		PersonalInfo personalInfo=new PersonalInfo(WebDriverUtil.getWebdriver());
		personalInfo.updateFirstName(newName);		
	}
	@When("enter account password {string}")
	public void enter_account_password(String passWord) {	    
		PersonalInfo personalInfo=new PersonalInfo(WebDriverUtil.getWebdriver());
		personalInfo.enterCurrentPassword(passWord);
	}
	@When("click on save")
	public void click_on_save() {
		PersonalInfo personalInfo=new PersonalInfo(WebDriverUtil.getWebdriver());
		personalInfo.saveAccountUpdate();
	}
	@Then("verify update confirmation {string} is displayed")
	public void verify_update_confirmation_is_displayed(String expectedConfirmation) {
		PersonalInfo personalInfo=new PersonalInfo(WebDriverUtil.getWebdriver());
		String confirmationMessage=personalInfo.getConifrmationMessage();
		assertThat(confirmationMessage, containsString(expectedConfirmation));
		
	    
	}




}
