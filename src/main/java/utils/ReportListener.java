package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    public static ExtentReports extentReporter=ExtentManager.createInstance();
    public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();

    public void onStart(ITestContext context){

    }
    public synchronized void onTestStart(ITestResult result){

        ExtentTest extentTest=extentReporter.createTest(result.getMethod().getMethodName(),result.getMethod().getMethodName());
        test.set(extentTest);
    }
    public void onTestSuccess(ITestResult result){
        test.get().pass(result.getMethod().getMethodName()+ " is successfully validated for all the assertions");
    }
    public void onTestSkipped(ITestResult result){
        test.get().skip( MarkupHelper.createLabel(result.getMethod().getMethodName()+ " is skipped", ExtentColor.GREY));

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }
    public void onFinish(ITestContext context){
        extentReporter.flush();
    }
    public void onTestFailure(ITestResult result){

      //  test.get().fail(result.getThrowable());
        test.get().fail( MarkupHelper.createLabel(result.getMethod().getMethodName()+ " test failed " , ExtentColor.RED));
        test.get().fail(result.getThrowable());

    }
}
