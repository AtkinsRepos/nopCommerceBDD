package TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClass.BaseTest;

public class TestNGListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase Started and TestCase Details are:" + result.getName());
		Reporter.log("Testcases started ");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("TestCase SUCCESSFUL, Hurray!  TestCase Details are:" + result.getMethod().getMethodName().toUpperCase());
		Reporter.log("All Tescases successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		System.out.println("TestCase FAILED and TestCase Details are:"+result.getName());
	 
		 try {
			Uioperations.takeScreenShotOnTestFailure(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 }

	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("**TestCase SKIPPED and TestCase Details are:" + result.getName());
		Reporter.log("Test case skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("**End of Test*****");

	}

}
