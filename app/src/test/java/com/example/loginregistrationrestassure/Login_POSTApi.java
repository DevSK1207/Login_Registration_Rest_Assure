package com.example.loginregistrationrestassure;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static groovy.xml.Entity.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Nowrin
 * 6/20/2020
 * sManager login/registration Post APi
 */
public class Login_POSTApi {

    @Before
    public void setup(){
        RestAssured.baseURI = "https://api.dev-sheba.xyz";
    }



    /**
     * Login POST API
     * Response code - 200
     * Check for null example
     */



    @Test
    public void Login_api_200(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154440\"," +
                "\"password\": \"12345\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v1/login").
                then().statusCode(200).assertThat()
                .body("code", equalTo(200))
                .body("message", equalTo("Successful"));


    }


    /**
     * Login POST API
     * Response code - 500
     */



    @Test
    public void Login_api_500(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154440\"," +
                "\"password\": \"12345\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v1/login").
                then().statusCode(200).assertThat()
                .body("code", equalTo(500));
    }

    /**
     * Login POST API
     * Response code - 400
     * message: The seat class field is required.
     */



    @Test
    public void Login_api_400(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154440\"," +
                "\"password\": \"yqtyqutgquwgtuigu\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v1/login").
                then().statusCode(200).assertThat()
                .body("code", equalTo(400))
                .body("message", equalTo("Password does't match"));
    }





    /**
     * Login POST API
     * Response code - 404
     * message: User not found.
     */



    @Test
    public void Login_api_404(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154441\"," +
                "\"password\": \"yqtyqutgquwgtuigu\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v1/login").
                then().statusCode(200).assertThat()
                .body("code", equalTo(404))
                .body("message", equalTo("Not found"));

    }


    /**
     * Login POST API
     * Response code - 405
     * message: User not found.
     */



    @Test
    public void Login_api_405(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154440\"," +
                "\"password\": \"12345\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.put("/v1/login").
                then().statusCode(405);
    }



    /**
     * Login POST API
     * Check for null example
     */


    @Test
    public void checkForNullExample() {

        RequestSpecification request = RestAssured.given();

        String body = "{ \"from\": \"manager-app\"," +
                "\"email\": \"01956154440\"," +
                "\"password\": \"12345\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v1/login").
                then().statusCode(200).assertThat()
                .body("info", not(equalTo(null)))
                .body("info.id", not(equalTo(null)))
                .body("info.name", not(equalTo(null)))
                .body("info.mobile", not(equalTo(null)))
                .body("info.email", not(equalTo(null)))
                .body("info.profile_image", not(equalTo(null)))
                .body("info.token", not(equalTo(null)))
                .body("info.is_handyman", not(equalTo(null)))
                .body("info.is_profile_avatar_default", not(equalTo(null)))
                .body("info.is_verified", not(equalTo(null)))
                .body("info.partners", not(equalTo(null)))
                .body("info.partner.id", not(equalTo(null)))
                .body("info.partner.name", not(equalTo(null)))
                .body("info.partner.sub_domain", not(equalTo(null)))
                .body("info.partner.mobile", not(equalTo(null)))
                .body("info.partner.address", not(equalTo(null)))
                .body("info.partner.status", not(equalTo(null)))
                .body("info.partner.is_verified", not(equalTo(null)))
                .body("info.partner.is_category_tagged", not(equalTo(null)))
                .body("info.partner.geo_informations", not(equalTo(null)))
                .body("info.partner.geo_informations.lat", not(equalTo(null)))
                .body("info.partner.geo_informations.lng", not(equalTo(null)))
                .body("info.partner.geo_informations.radius", not(equalTo(null)));


    }
}

