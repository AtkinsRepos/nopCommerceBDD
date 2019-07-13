package TestUtils;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseTest;

public class Utils extends BaseTest{

	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	 //generating random string for fields that must change value at the point of data entry eg username, emails, pwd, DOB etc. a very useful utility.
	  public static String randomestring() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(8);
			return (generatedString1);
		}
	  public static String randomestringForNames() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(4);
			return (generatedString1);
		}
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(2);
			return (generatedString2);
		}
		
		public static String randomeAlphaNumeral() {
			String randomeAlphaNumera = RandomStringUtils.randomAlphanumeric(8);
			return (randomeAlphaNumera);
		}
		
		public static void WaitForWebElement(WebElement element, long timeOutInSeconds) {
		        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		        wait.until(ExpectedConditions.visibilityOf(element));
		        
			}
		
//		public void WebElentsWaitAction(WebElement element,long timeOutInSeconds){
//			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//			wait.until(ExpectedConditions.visibilityOf(element));
//			}
		
		public static void WebDriverWaitForAlert() {
			try {
		        WebDriverWait wait = new WebDriverWait(driver, 4);
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    } catch (Exception e) {
		        //exception handling
		    }
			
		}
}
