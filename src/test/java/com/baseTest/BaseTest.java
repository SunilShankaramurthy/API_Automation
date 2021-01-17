package com.baseTest;

import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.PropertyFile;
import utils.ReportListener;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ReportListener.class)
public class BaseTest  extends ReportListener {


    @BeforeClass
    public void testRun(){
        System.out.println("***********************************************");
        System.out.println();
        System.out.println("Intigral-Ott Promotions API test Started!!!");
        System.out.println();
        System.out.println("***********************************************");

    }
    @BeforeClass(dependsOnMethods = "testRun")
    public void baseTest(){

        RestAssured.baseURI=PropertyFile.envFile().get("ServerUrl");
    }
}
