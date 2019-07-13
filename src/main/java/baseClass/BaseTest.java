package baseClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;

import TestUtils.WebEventListener;
import configFiles.Constants;
import pageObjects.AddCustomersPg;
import pageObjects.AddNewRolesPg;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger;
	public static AddCustomersPg addcustomersPg;
	public static AddNewRolesPg addnewrolespg;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(Constants.CONFIG_PROPERTIES_DIRECTORY);

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public static void initBrowser() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_DIRECTORY);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();

		} else if (browserName.equals("ie")) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_DIRECTORY);

			caps.setCapability("ignoreZoomSetting", true);
//			driver = new InternetExplorerDriver(caps);
			driver = new InternetExplorerDriver();

		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		String URL = prop.getProperty("ApplicationURL");
		driver.get(URL);
		 logger=Logger.getLogger("nopCommerceBDD");
		 PropertyConfigurator.configure("Log4j.properties");
	}
//	@AfterSuite
//	public void teardown() {
//		driver.quit();
//		
//	}
}
