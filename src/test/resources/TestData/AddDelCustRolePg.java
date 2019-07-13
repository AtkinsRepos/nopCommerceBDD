package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import TestUtils.Utils;
import baseClass.BaseTest;

public class AddDelCustRolePg extends BaseTest {

	// Constructor for the class
	public AddDelCustRolePg(WebDriver driver) {
		BaseTest.driver = driver;
	}

	// webelements and action methods
	public void setCustomersRolesLink() {
		WebElement customersRoles= driver.findElement(By.xpath("//span[contains(.,'Customer roles')]"));
		customersRoles.click();
		}

	public void setAddnewCustomerRole() {
		WebElement addNewRole = driver.findElement(By.linkText("Add new"));
		addNewRole.click();
		Utils.WaitForWebElement(driver.findElement(By.linkText("Add new")), 2);
		
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
//	 js.executeScript("arguments[0].click();", addNewRole);

	}

	public void setNameofCustomerRole(String Name) {
		WebElement EnterNameOfRole = driver
				.findElement(By.xpath("//input[@data-val-required='Please provide a name.']"));
		EnterNameOfRole.sendKeys(Name);
	}

	public void setFreeShippingoption() {
		WebElement CheckFressShipping = driver.findElement(By.xpath("//input[@id='FreeShipping']"));
		CheckFressShipping.click();
	}

	public void settaxExempt() {
		WebElement checktaxExempt = driver.findElement(By.xpath("//input[@id='TaxExempt']"));

		checktaxExempt.click();
	}

	public void setoverrridetaxDisplay() {
		WebElement checkOverrrideTaxDisplayOption = driver.findElement(By.xpath(""));
		checkOverrrideTaxDisplayOption.click();
		Select select = new Select(checkOverrrideTaxDisplayOption);
		select.selectByIndex(0);
	}

	public void setlifetimePassword() {
		WebElement checkLifeTimePassword = driver.findElement(By.xpath("//input[@id='EnablePasswordLifetime']"));
		checkLifeTimePassword.click();

	}

	public void setsystemNameOption() {
		WebElement EntersystemName = driver.findElement(By.xpath("//input[@name='SystemName']"));

	}

	public void setSaveAndEditbutton() {
		WebElement clickSaveAndEditbutton = driver
				.findElement(By.xpath("//button[contains(.,'Save and Continue Edit')]"));
		clickSaveAndEditbutton.click();
	}

	public void verifyRoleAddtion() {
		String ExpectedsuccessAdditionMsg = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		String ActualsuccessAdditionMsg = "The new customer role has been added successfully.";
		Assert.assertEquals(ActualsuccessAdditionMsg, ExpectedsuccessAdditionMsg, "They  do not match");

	}

	public void DeleteAdddedrole() {
		WebElement DeleteRole = driver.findElement(By.xpath("//span[@id='customerrole-delete']"));
		DeleteRole.click();
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			WebElement Alertext = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
			Alertext.click();
		} finally {
		}

	}

	public void Deletedrolemsg() {
		String ExpectedDeletesuccessmsg = driver
				.findElement(By
						.xpath("(//div[contains(.,'×\r\n" + "The customer role has been deleted successfully.')])[3]"))
				.getText();
		String ActualDeletesuccessMsg = "The customer role has been deleted successfully.";
		Assert.assertEquals(ActualDeletesuccessMsg, ExpectedDeletesuccessmsg, "They do not match");
	}

	public void closebrowser() {
		driver.close();

	}
}
