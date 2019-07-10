package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.BaseTest;
import configFiles.Constants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPg;

public class LoginPageStepDef extends BaseTest {
	LoginPg loginpage;
	Constants constants;

	@Before
	@Given("^User Launches the Web browser$")
	public void user_Launches_the_Web_browser() {
		BaseTest.initBrowser();
		logger.info("******Initializing the web browser********");
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String ApplicationURL) {
		logger.info("*****Opening the URL******");
		String URL = prop.getProperty("ApplicationURL");
		driver.get(URL);

	}

	@When("^User enters LoginEmail as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_LoginEmail_as_and_Password_as(String Email, String password) {
		logger.info("*****Entering The UserEmail and Password******");
		loginpage = new LoginPg(driver);
		loginpage.setUserEmail(Email);
		loginpage.setpassword(password);

	}

	@When("^Clicks on the Login button$")
	public void clicks_on_the_Login_button() {
		logger.info("*****clicking on the login button******");
		loginpage.ClickOnLoginBtn();
	}

	@Then("^The Page Title displayed should be \"([^\"]*)\"$")
	public void the_Page_Title_displayed_should_be(String title) {
		logger.info("*****Validating dashboard page Title******");
		title=loginpage.validateDashboardPageTitle();
		//Assert.assertTrue(false);
		Assert.assertEquals(title, "Dashboard / nopCommerce administration");

	}

	@When("^User clicks on Log out link$")
	public void user_clicks_on_Log_out_link() {
		logger.info("*****Logging out of the application******");
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        //exception handling
	    }
		loginpage.userLogsOut();
		logger.info("*****successfully logged out******");

	}

	@Then("^The Page Title should be \"([^\"]*)\"$")
	public void the_Page_Title_should_be(String title) {
		logger.info("*****Verifying return to login page******");
		title = loginpage.validateLoginPageTitle();
		//Assert.assertTrue(false);
		Assert.assertEquals(title, "Your store. Login");
		//Assert.assertEquals(title, "Dashboard / nopCommerce administration");
		
	}
	
	
	@After
	@Then("^close the browser$")
	public void close_the_browser() {
		logger.info("*****Closing the Browser******");
		driver.quit();

	}

}
