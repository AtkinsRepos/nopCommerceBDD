package stepDefinitions;

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
import pageObjects.AddDelCustRolePg;
import pageObjects.LoginPg;

public class AddnewRoleStepsDefxxxx extends BaseTest {
	LoginPg loginpage;
	Constants constants;

	@When("^clicks on customers roles Item$")
	public void clicks_on_customers_roles_Item() {
		AddDelCustRolePg addDeleteCustRolePg = new AddDelCustRolePg(driver);
		Utils.WebDriverWaitForAlert();
		addDeleteCustRolePg.setCustomersRolesLink();
	}

	@Then("^User can view Add new customer role$")
	public void user_can_view_Add_new_customer_role() {

		WebElement addRole = driver.findElement(By.linkText("Add new"));
		addRole.click();
	}

	@When("^User enter customer role info$")
	public void user_enter_customer_role_info() {
		WebElement addrolename = driver.findElement(By.id("Name"));
		addrolename.sendKeys("marketing");
		Utils.WebDriverWaitForAlert();
		WebElement FreeShipping = driver.findElement(By.id("FreeShipping"));
		FreeShipping.click();
		WebElement settaxExempt = driver.findElement(By.id("TaxExempt"));
		settaxExempt.click();
		WebElement OverrideTaxDisplayType = driver.findElement(By.id("OverrideTaxDisplayType"));
		OverrideTaxDisplayType.click();
		WebElement DefaultTaxDisplayTypeId = driver.findElement(By.id("DefaultTaxDisplayTypeId"));
		DefaultTaxDisplayTypeId.click();
		Utils.WebDriverWaitForAlert();
		WebElement dropdown = driver.findElement(By.id("DefaultTaxDisplayTypeId"));
		dropdown.findElement(By.xpath("//option[. = 'Excluding tax']"));
		dropdown.click();
		WebElement SystemName = driver.findElement(By.id("SystemName"));
		SystemName.sendKeys("Yes");
		WebElement element = driver.findElement(By.name("save-continue"));
		element.click();
	}

//	@Then("^successfully role addition message should be \"([^\"]*)\"$")
//	public void successfully_role_addition_message_should_be(String msgs) {
////		String ExpectedMsg = "The customer role has been updated successfully.";
////		String  ActualMsg= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
////		Assert.assertEquals(ActualMsg, ExpectedMsg, "They do not match");
////		System.out.println("The EXPECTED MESSAGE IS:***********" + ExpectedMsg);
////		System.out.println("The Actual MESSAGE IS:***********" + ActualMsg);
//		
//		
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissable')]")).getText().contains("The new customer role has been added successfully."));
//
//	}

	@When("^user then delete the customer role just added$")
	public void user_then_delete_the_customer_role_just_added() {
		driver.findElement(By.id("customerrole-delete")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No, cancel'])[1]/following::button[1]")).click();
	}

	@Then("^User can view delete confirmation message \"([^\"]*)\"$")
	public void user_can_view_delete_confirmation_message(String msg) {
		String ExpectedDeletesuccessmsg = driver.findElement(By.xpath("(//div[contains(.,'×\r\n" + "The customer role has been deleted successfully.')])[3]")).getText();
		String ActualDeletesuccessMsg = "The customer role has been deleted successfully.";
		Assert.assertEquals(ActualDeletesuccessMsg, ExpectedDeletesuccessmsg, "They do not match");
	}

}
