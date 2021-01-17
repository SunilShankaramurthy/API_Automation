package com.testcases;

import apiConfigs.APIPath;
import apiVerification.APIVerification;
import com.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PopcornInvalidAPIKeyValidation extends BaseTest {
    private static RequestSpecification requestSpecification;
    private static Response response;
/*
    @Test
    public void invalidAPIKeyValidation() {
        requestSpecification=RestAssured.given();
        response=requestSpecification.request(Method.GET, APIPath.apiPath.INVALID_APIKEY);
        APIVerification.responseCodeValidation(response,403);
        APIVerification.responseKeyValidation(response,"requestId");
        APIVerification.ResponseDataValidation(response,"code","8001");
        APIVerification.ResponseDataValidation(response,"message","invalid api key");
    }

 */
}
