package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestUtils.Utils;
import baseClass.BaseTest;

public class AddNewRolesPg extends BaseTest {

	// Constructor for the class
	public AddNewRolesPg(WebDriver driver) {
		BaseTest.driver = driver;
	}
	public void setCustomersRolesLink() {
		WebElement customersRoles = driver.findElement(By.xpath("//span[contains(.,'Customer roles')]"));
		customersRoles.click();
	}
	
	
	public void setAddnewCustomerRole() {
		Utils.WaitForWebElement(driver.findElement(By.linkText("Add new")), 4);
		WebElement addNewRole = driver.findElement(By.linkText("Add new"));
		addNewRole.click();
	}
	public void setRoleName(String marketing) {
		WebElement addrolename = driver.findElement(By.xpath("//input[@data-val-required='Please provide a name.']"));
		addrolename.sendKeys(marketing);
	}
	public void setFreeShipping() {
		WebElement FreeShipping = driver.findElement(By.id("FreeShipping"));
		FreeShipping.click();
	}
	public void settaxExempt() {
		WebElement taxExempt = driver.findElement(By.id("TaxExempt"));
		taxExempt.click();
	}
	public void setOverrideTaxDisplayType() {
		WebElement OverrideTaxDisplayType = driver.findElement(By.id("OverrideTaxDisplayType"));
		OverrideTaxDisplayType.click();
	}

	public void setDefaultTaxDisplayTypeId() {
		WebElement DefaultTaxDisplayTypeId = driver.findElement(By.id("DefaultTaxDisplayTypeId"));
		DefaultTaxDisplayTypeId.click();
		WebElement dropdown = driver.findElement(By.id("DefaultTaxDisplayTypeId"));
		dropdown.findElement(By.xpath("//option[. = 'Excluding tax']"));
		dropdown.click();
	}

	public void setSystemName(String Yes) {
		WebElement SystemName = driver.findElement(By.id("SystemName"));
		SystemName.sendKeys(Yes);
	}
	public void setSaveedit() {

		WebElement save = driver.findElement(By.xpath("//button[@name='save']"));
		save.click();
	}
public void closebrowser() {
	driver.close();
	
}

}
