package com.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Interview {

    public static void main(String[] args) {

        Data requestBody = new Data.Builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .countryENCode("US")
                .countryCode("+1")
                .phone("9876543210")
                .DOTNumber("123456")
                .build();

        Response response = RestAssured
                .given()
                .baseUri("http://dev.etruckingsystem.com:8000")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/admin/verifyUser");

        System.out.println("Status Code: " + response.getStatusCode());
        response.prettyPrint();
    }
}
