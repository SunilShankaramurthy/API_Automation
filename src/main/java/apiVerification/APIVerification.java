package apiVerification;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ReportListener;

public class APIVerification extends ReportListener {

    public static void responseCodeValidation(Response response, int statusCode) {
        try {
            Assert.assertEquals(statusCode, response.getStatusCode());
            test.get().pass(MarkupHelper.createLabel("Status Code Test Passed : " + response.getStatusCode(), ExtentColor.GREEN));
        } catch (AssertionError e) {
            String errorMessage = "Response Status Code Fail " +
                    ":: Expected is : " + statusCode + " but actual code is :" + response.getStatusCode() +
                    " Please find the error details below";
            test.get().fail(MarkupHelper.createLabel(errorMessage, ExtentColor.RED));
            test.get().log(Status.INFO, e.fillInStackTrace());
        }

    }

    public static void responseTimeValidation(Response response) {
        try {
            long time = response.time();
           // test.get().pass(MarkupHelper.createLabel("Api Response time is under expected range ::" + time, ExtentColor.GREEN));
        } catch (AssertionError e) {
            test.get().fail(MarkupHelper.createLabel("Response time is not in the expected range :-->  " + e.fillInStackTrace(), ExtentColor.RED));
        }
    }


    public static void validation(Object value, String key, String matcher) {
        try {
            Assert.assertEquals(value.getClass().getSimpleName(),"matcher");
            // test.get().pass(MarkupHelper.createLabel(key + " value is present in the response body ", ExtentColor.GREEN));
        } catch (AssertionError e) {
            test.get().fail(MarkupHelper.createLabel(key + " doesn't have "+matcher+"value --> " + e.fillInStackTrace(), ExtentColor.RED));

        }
    }

    public static void validation(String key, Object value) {
        try {
            Assert.assertEquals(key.getClass().getSimpleName(),"value");
           // test.get().pass(MarkupHelper.createLabel(key + " value is present in the response body ", ExtentColor.GREEN));
        } catch (AssertionError e) {
            test.get().fail(MarkupHelper.createLabel(key + " doesn't have "+value+"value --> " + e.fillInStackTrace(), ExtentColor.RED));

        }
    }


}
