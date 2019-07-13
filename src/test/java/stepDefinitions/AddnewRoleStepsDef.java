package stepDefinitions;

import org.mockito.internal.verification.api.VerificationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import TestUtils.Utils;
import baseClass.BaseTest;
import configFiles.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.AddNewRolesPg;
import pageObjects.LoginPg;

public class AddnewRoleStepsDef extends BaseTest {
	LoginPg loginpage;
	Constants constants;

	@When("^clicks on customers roles Item$")
	public void clicks_on_customers_roles_Item() {
		addnewrolespg = new AddNewRolesPg(driver);
		Utils.WebDriverWaitForAlert();
		addnewrolespg.setCustomersRolesLink();
	}

	@Then("^User can view Add new customer role$")
	public void user_can_view_Add_new_customer_role() {
		addnewrolespg.setAddnewCustomerRole();
	}

	@When("^User enter customer role info$")
	public void user_enter_customer_role_info() {
		// addnewrolespg.setRoleName("marketing");
		WebElement addrolename = driver.findElement(By.xpath("//input[@data-val-required='Please provide a name.']"));
		addrolename.sendKeys("marketing");
		addnewrolespg.setFreeShipping();
		addnewrolespg.settaxExempt();
		addnewrolespg.setOverrideTaxDisplayType();
		addnewrolespg.setDefaultTaxDisplayTypeId();
		addnewrolespg.setSystemName("Yes");

	}

	@When("^user should click on Save button$")
	public void user_should_click_on_Save_button() {
		addnewrolespg.setSaveedit();
		addnewrolespg.closebrowser();
	}

}
