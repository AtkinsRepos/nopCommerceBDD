package TestUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import baseClass.BaseTest;

public class Uioperations extends BaseTest {
	
//	public static String  takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
//		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
//        Date date = new Date();
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String ScreenShotPath = System.getProperty("user.dir")+"//screenshots//"+dateFormat.format(date)+".png";
//		//System.currentTimeMillis
//		try {
//			FileUtils.copyFile(src, new File(ScreenShotPath));
//			System.out.println("ScreenShot Captured");
//			
//		} catch (IOException e) {
//			System.out.println("Failed to capture screenshots "
//					+ e.getMessage());
//		}
//
//		return ScreenShotPath;
//	}
	
	public static String  takeScreenShotOnTestFailure(WebDriver driver) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenShotPath = System.getProperty("user.dir")+"//screenshots//"+dateFormat.format(date)+".png";
		//System.currentTimeMillis
		try {
			FileUtils.copyFile(src, new File(ScreenShotPath));
			System.out.println("ScreenShot Captured");
			
		} catch (IOException e) {

			System.out.println("Failed to capture screenshots "
					+ e.getMessage());
		}

		return ScreenShotPath;
	}

	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 
		 Date currentDate = new Date();
		 
		 return customFormat.format(currentDate);
	}
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}

  public void switchToFrameIndex() {
		driver.switchTo().frame(0);
		
	}

}
