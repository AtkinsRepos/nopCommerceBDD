package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import TestUtils.Utils;
import baseClass.BaseTest;
import configFiles.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomersPg;
import pageObjects.LoginPg;

public class AddCustomersStepsDef extends BaseTest {

	LoginPg loginpage;
	Constants constants;

@When("^User clicks on customers Menu$")
public void user_click_on_customers_Menu() {
	Utils.WebDriverWaitForAlert();
	addcustomersPg = new AddCustomersPg(driver);
	addcustomersPg.clickoncustmenulink();
 
}
	@When("^clicks on customers Menu Item$")
	public void click_on_customers_Menu_Item() {
		Utils.WebDriverWaitForAlert();
		addcustomersPg.clickoncustmenuItem();
	}
	
	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() {
		Utils.WebDriverWaitForAlert();
		String pagetitle = addcustomersPg.getPageTitle();
		String expectedpagetitle = "Customers / nopCommerce administration";
		Assert.assertEquals(pagetitle, expectedpagetitle, "Page title do not match");
		Utils.WebDriverWaitForAlert();
		addcustomersPg.clickOnAddNewCustomerBtn();

	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() {
		addcustomersPg.setCustEmailRandom();
		addcustomersPg.setCustPassword("Tergu765");
		addcustomersPg.setCustFirstName();
		addcustomersPg.setLastName();
		addcustomersPg.setGenderMale();
		addcustomersPg.setDateOfBirth("12/06/1980");
		addcustomersPg.setCompanyName("KekeNap");
		addcustomersPg.tickIstaxExempt();
		addcustomersPg.tickYourstoreNameforSubscription();
		addcustomersPg.tickSubscribeTestStore2();
		
		//addcustomersPg.selectCustomerroleSelectmenu();
		addcustomersPg.selectRegisteredRole();
//		//Utils.WebDriverWait();
//		addcustomersPg.selectCustomerroleSelectmenu();
//		Utils.WebDriverWait();
//		addcustomersPg.selectForumModeratorOutter();
//		Utils.WebDriverWait();
//		//addcustomersPg.selectCustomerroleSelectmenu();
//		//addcustomersPg.selectGuestRoleOutter();
//		Utils.WebDriverWait();
//		//addcustomersPg.selectCustomerroleSelectmenu();
//		addcustomersPg.selectAdminRoleInner();
//		Utils.WebDriverWait();
		addcustomersPg.selectManagerOfVendorBox();
		//Utils.WebDriverWait();
		//addcustomersPg.tickActiveCheckBox();
		addcustomersPg.setAdminComment("Not a bad idea, after all");

	}

	@When("^click on Save button$")
	public void click_on_Save_button() {
		addcustomersPg.ClickOnSaveBtn();

	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}

	@Then("^close browser$")
	public void close_browser() {
		driver.quit();

	}
		
	
}
