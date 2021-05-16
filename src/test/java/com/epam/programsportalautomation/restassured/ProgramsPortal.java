package com.epam.programsportalautomation.restassured;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgramsPortal {

//    @Test
//    public void getCollegeByID() {
//        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
//        RequestSpecification requestSpecification = RestAssured.given();
//        Response response = requestSpecification.get("colleges/485");
//        System.out.println(response.getStatusLine()+"----->"+response.getStatusCode());
//        System.out.println(response.asString());
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode,200);
//    }


    @Test(priority = 1)
    public void testPostCollege(){
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-type","application/json");
        JSONObject body = new JSONObject();
        body.put("city","kentucky");
        body.put("collegeId","2345");
        body.put("collegeName","hollywood Arts");
        body.put("group","literature");
        body.put("ptoEmail","cat@valentine.com");
        body.put("ptoMobile","9947562891");
        body.put("ptoName","Ariana");
        body.put("status","Active");
        requestSpecification.body(body.toString());
        Response response = requestSpecification.request(Method.POST,"colleges");
        System.out.println(response.asString());

    }
    @Test(priority = 2)
    public void testGetCollegeByID() {
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification.request(Method.GET,"colleges/2345");
        System.out.println(response.getStatusLine()+"----->"+response.getStatusCode());
        System.out.println(response.asString());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test(priority = 4)
    public void editCollegeByPut(){
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-type","application/json");
        JSONObject body = new JSONObject();
        body.put("city","kentucky");
        body.put("collegeId","2345");
        body.put("collegeName","hollywood Arts");
        body.put("group","literature");
        body.put("ptoEmail","Kat@valentine.in");
        body.put("ptoMobile","9947562891");
        body.put("ptoName","Ariana");
        body.put("status","Active");
        requestSpecification.body(body.toString());
        Response response = requestSpecification.request(Method.PUT,"colleges/2345");
        System.out.println(response.asString());
        testGetCollegeByID();
    }
    @Test(priority = 5)
    public void deleteCollegeByDisabling(){
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.DELETE,"colleges/2345");
        System.out.println(response.asString());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }
}
