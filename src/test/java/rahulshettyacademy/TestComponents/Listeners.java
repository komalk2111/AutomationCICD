package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();   //thread safe
	
	public void onTestStart(ITestResult result)
	{
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//uniqe thread id (ErrorValidationTest)--->test
	}

	
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS,"Test passed");
	}

	
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		String filepath = null ;
		try {
			  filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		   extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
		//screenshot ,Attach to report
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
