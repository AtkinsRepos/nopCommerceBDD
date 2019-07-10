package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.BaseTest;

public class LoginPg extends BaseTest {

	public LoginPg(WebDriver driver) {
		BaseTest.driver = driver;
	}

	public void setUserEmail(String Email) {
		WebElement enterEmail = driver.findElement(By.xpath("//input[@name='Email']"));
		enterEmail.clear();
		enterEmail.sendKeys(Email);
	}

	public void setpassword(String pwd) {
		WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
		password.clear();
		password.sendKeys(pwd);

	}

	public void ClickOnLoginBtn() {
	WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	loginBtn.click();
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
//	 js.executeScript("arguments[0].click();", loginBtn);
 }

	public String validateDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public void userLogsOut() {
		WebElement LogOut = driver.findElement(By.xpath("//a[contains(.,'Logout')]"));
		LogOut.click();		
		
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	//INvalid Login Test Cases webelements
	
	
		// 1. Correct UserEmail  and blank pwd error message:
			// Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect
		
		/*2. Empty Email field: and correct pwd:
			 1. Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect
			 2.Please enter your email
			 
			 Same error message above for email field and pwd fields  both empty
	       */
		
	
	
	
}
