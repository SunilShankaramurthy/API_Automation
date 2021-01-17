package com.testcases;

import apiConfigs.APIPath;
import com.baseTest.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.ErrorResponse;
import utils.PropertyFile;

public class Intigral_Ott_Promotions_API_ErrorHandling extends BaseTest {
    private static RequestSpecification requestSpecification;
    private static Response response;


    ObjectMapper objectMapper = new ObjectMapper();
    ErrorResponse errorResponse;

    @BeforeClass(dependsOnMethods = "baseTest")
    public void invalidAPIKeyValidation () throws JsonProcessingException {
        requestSpecification = RestAssured.given();
        response = requestSpecification.request(Method.GET, APIPath.apiPath.INVALID_APIKEY);
        errorResponse  = objectMapper.readValue(new JSONObject(response.getBody().asString()).toString(), ErrorResponse.class);
    }

    @Test(priority = 0)
    public void get_Promotions_InvalidAPIKey_StatusCode(){
        Assert.assertEquals(response.getStatusCode(),403
                ,"Invalid API Get Request Response code Mismatch -->");
    }

    @Test
    public void invalid_APIKey_ResponseValidation(){
        Assert.assertNotNull(errorResponse.getError().getRequestId().toString());

        Assert.assertEquals(errorResponse.getError().getCode()
                ,"8001","Invalid APIKey response code mismatch. It should be 8001");

        Assert.assertEquals(errorResponse.getError().getMessage()
                ,"invalid api key", "Invalid APIKey response message mismatch");
    }

}
