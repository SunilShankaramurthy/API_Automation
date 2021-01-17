package com.baseTest;

import com.aventstack.extentreports.Status;
import utils.PropertyFile;
import utils.ReportListener;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ReportListener.class)
public class BaseTest  extends ReportListener {

    @BeforeClass
    public void baseTest(){
       // test.get().log(Status.INFO,"Test started");
        RestAssured.baseURI="http://api.intigral-ott.net";
      //  RestAssured.baseURI=PropertyFile.envFile().get("ServerUrl");
    }
}
