package pageObjects;

import java.security.PublicKey;

import javax.swing.table.TableColumn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table;

import TestUtils.Utils;
import baseClass.BaseTest;

public class AddCustomersPg extends BaseTest {

	// Constructor for the class
	public AddCustomersPg(WebDriver driver) {
		BaseTest.driver = driver;
	}

	// webelements and action methods

	public String getPageTitle() {
		return driver.getTitle();

	}
	// pagetitle=Customers / nopCommerce administration
	// pagetitle="Add a new customer / nopCommerce administration"

	public void clickoncustmenulink() {
		WebElement ClickonCustmainMenuLink = driver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'Customers')]"));
		ClickonCustmainMenuLink.click();
	}

	public void clickoncustmenuItem() {
		WebElement ClickOnCustomersMenuItem = driver
				.findElement(By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]"));
		ClickOnCustomersMenuItem.click();
	}

	public void clickOnAddNewCustomerBtn() {
		Utils.WebDriverWaitForAlert();
		WebElement clickAddNewCustomerBtn = driver.findElement(By.xpath("//a[contains(.,'Add new')]"));
		clickAddNewCustomerBtn.click();

	}

	public void setCustEmailRandom() {
		WebElement EnterCustEmail = driver.findElement(By.xpath("//input[@name='Email']"));
		String Email=Utils.randomestring()+ "@email.com";
		EnterCustEmail.clear();
		EnterCustEmail.sendKeys(Email);
	}

	public void setCustPassword(String password) {
		WebElement EnterCustPassword = driver.findElement(By.xpath("//input[@name='Password']"));
		EnterCustPassword.clear();
		EnterCustPassword.sendKeys(password);
	}

	public void setCustFirstName() {
		WebElement EnterFirstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		String Firstname=Utils.randomestringForNames()+"son";
		EnterFirstName.sendKeys(Firstname);

	}

	public void setLastName() {
		WebElement EnterLastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		String lastname=Utils.randomestringForNames()+"ton";
		EnterLastName.sendKeys(lastname);

		// Choose Gender
	}

	public void setGenderMale() {
		WebElement PickMale = driver.findElement(By.xpath("//input[contains(@id,'Male')]"));
		PickMale.click();
	}

	public void setGenderFemale() {
		WebElement PickFemale = driver.findElement(By.xpath("//input[contains(@id,'Female')]"));
		PickFemale.click();
	}

	// Choose Gender ends
	public void setDateOfBirth(String DOB) {
		WebElement EnterDateOfBirth = driver.findElement(By.xpath("//input[@id='DateOfBirth']"));
		EnterDateOfBirth.clear();
		EnterDateOfBirth.sendKeys(DOB);

	}

	public void setCompanyName(String CompName) {
		WebElement EnterCompanyName = driver.findElement(By.xpath("//input[@name='Company']"));
		EnterCompanyName.clear();
		EnterCompanyName.sendKeys(CompName);
	} 

	public void tickIstaxExempt() {
		WebElement Tick_IstaxExempt = driver.findElement(By.xpath("//input[@id='IsTaxExempt']"));
		Tick_IstaxExempt.click();
	}

	// Subscribe to Newsletter:
	public void tickYourstoreNameforSubscription() {
		WebElement TickSubscribeYourstoreName = driver.findElement(By.xpath("//input[@value='1']"));
		TickSubscribeYourstoreName.click();
	}

	public void tickSubscribeTestStore2() {
		WebElement TickTestStore2 = driver.findElement(By.xpath("//input[@value='2']"));
		TickTestStore2.click();
		// Customer Roles menu: Admin,forum moderator, guest,registered user, vendor
	}

	public void selectCustomerRolesMenu() {
		WebElement ChooseCustomerRolesMenu = driver.findElement(By.xpath("(//input[@role='listbox']"));
		Select Admin = new Select(ChooseCustomerRolesMenu);
		Admin.selectByIndex(2);
		//ChooseCustomerRolesMenu.click();

	}

	public void selectCustomerroleSelectmenu() {
		WebElement ChooseCustomerroleSelectmenu = driver
				.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']"));
		ChooseCustomerroleSelectmenu.click();

	}

	public void selectRegisteredRole() {
		WebElement clickonRegisteredRole = driver
				.findElement(By.xpath("//span[@unselectable='on'][contains(.,'Registered')]"));
		clickonRegisteredRole.click();
	}

	public void selectAdminRoleOutter() {
		WebElement ClickOnAdminRoleOutter = driver.findElement(By.xpath("//span[contains(.,'Administrators')]"));
		ClickOnAdminRoleOutter.click();
	}

	public void selectAdminRoleInner() {
		WebElement AdminRoleInner = driver.findElement(By.xpath("(//li[contains(@role,'option')])[1]"));
		AdminRoleInner.click();
	}

	public void selectGuestRoleOutter() {
		WebElement GuestRoleOutter = driver.findElement(By.xpath("(//li[contains(@role,'option')])[3]"));
		GuestRoleOutter.click();
	}

	public void selectGuestRoleInner() {
		WebElement GuestRoleInner = driver.findElement(By.xpath("//li[contains(.,'Guests')]"));
		GuestRoleInner.click();
	}

	public void selectForumModeratorOutter() {
		WebElement ForumModeratorOutter = driver.findElement(By.xpath("(//li[contains(@role,'option')])[2]"));
		//li[@tabindex='-1'][contains(.,'Forum Moderators')]
		ForumModeratorOutter.click();
	}

//Select use for the 2 options
	public void selectManagerOfVendorBox() {
		WebElement SelectManagerOfVendorBox = driver.findElement(By.xpath("//select[contains(@class,'form-control')]"));
		Select select = new Select(SelectManagerOfVendorBox);
		select.selectByIndex(0);
	}
	public void tickActiveCheckBox() {
		WebElement CheckActiveCheckBox = driver.findElement(By.xpath("//input[@id='Active']"));
		CheckActiveCheckBox.click();

	}

	public void setAdminComment(String CommentNotes) {
		WebElement EnterAdminComment = driver.findElement(By.xpath("//textarea[contains(@name,'AdminComment')]"));
		EnterAdminComment.clear();
		EnterAdminComment.sendKeys(CommentNotes);

	}

	public void ClickOnSaveBtn() {
		WebElement SaveBtn = driver.findElement(By.xpath("//button[@name='save']"));
		SaveBtn.click();
	}
	
	
}
