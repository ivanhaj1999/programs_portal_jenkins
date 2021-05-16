package com.epam.programsportalautomation.api;

//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restassured {
    public void setup(){
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET,"colleges/2345");
    }
    public void testGetCollegeByID() {

//        System.out.println(response.getStatusLine()+"----->"+response.getStatusCode());
//        System.out.println(response.asString());
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode,200);
    }
}
