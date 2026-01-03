package com.api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Interview {

    public static void main(String[] args) {

        Data data = new Data();
        data.setFirstName("John");
        data.setLastName("Doe");
        data.setEmail("john.doe@example.com");
        data.setCountryENCode("US");
        data.setCountryCode("+1");
        data.setPhone("9876543210");
        data.setDOTNumber("123456");

        Response response = RestAssured
                .given()
                .baseUri("http://dev.etruckingsystem.com:8000")
                .contentType("application/json")
                .body(data)
                .when()
                .post("/admin/verifyUser");

        // Print response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        response.prettyPrint();
    }
}
