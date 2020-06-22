package com.example.loginregistrationrestassure;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Registration_POSTApi {


    @Before
    public void setup(){
        RestAssured.baseURI = "https://api.dev-sheba.xyz";
    }



    /**
     * Registration POST API
     * Response code - 200
     * Check for null example
     */



    @Test
    public void Registration_api_200(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"vUXmcCyv6MblL0fafVZuRjrQdEVKB6fXn7nyGttEmlEY8hRUSEpHvrGPjM59\"," +
                "\"name\": \"Arshi digigo\"," +
                "\"mobile\": \"01444455567\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/partners/37662/register").
                then().statusCode(200).assertThat()
                .body("code", equalTo(200));


    }


    /**
     * Registration POST API
     * Response code - 500
     */



    @Test
    public void Registration_api_500(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"J9EIxpNiEISE3WU1kO1gWrNP6I7FlNp2JAmUzHVmXWWRawGYYtmgWeRfqLJC\"," +
                "\"name\": \"Arnab\"," +
                "\"mobile\": \"01678242969\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/partners/233/register").
                then().statusCode(200).assertThat()
                .body("code", equalTo(500));
    }

    /**
     * Registration POST API
     * Response code - 400
     * message: The seat class field is required.
     */



    @Test
    public void Registration_api_400(){
        RequestSpecification request = RestAssured.given();

        String body =// "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                        "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("code", equalTo(400));
    }


    /**
     * Registration POST API
     * Response code - 403
     * message: You're not authorized to access this user.
     */



    @Test
    public void Registration_api_403(){

        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"J9EIxpNiEISE3WU1kO1gWrNP6I7FlNp2JAmUzHVmXWWRawGYYtmgWeRfqLJC\"," +
                "\"name\": \"Arnab\"," +
              //  "\"mobile\": \"01678242969\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/partners/233/register").
                then().statusCode(200).assertThat()
                .body("code", equalTo(403));
    }


    /**
     * Registration POST API
     * Response code - 404
     * message: User not found.
     */



    @Test
    public void Registration_api_404(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"J9EIxpNiEISE3WU1kO1gWrNP6I7FlNp2JAmUzHVmXWWRawGYYtmgWeRfqLJD\"," +
                "\"name\": \"Arnab\"," +
                "\"mobile\": \"01678242969\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/partners/233/register").
                then().statusCode(200).assertThat()
                .body("code", equalTo(404));

    }


    /**
     * Registration POST API
     * Response code - 405
     * message: User not found.
     */



    @Test
    public void Registration_api_405(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"J9EIxpNiEISE3WU1kO1gWrNP6I7FlNp2JAmUzHVmXWWRawGYYtmgWeRfqLJC\"," +
                "\"name\": \"Arnab\"," +
                "\"mobile\": \"01678242969\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.put("/v2/partners/233/register").
                then().statusCode(405);
    }



    /**
     * Registration POST API
     * Check for null example
     */


    @Test
    public void checkForNullExample() {

        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"vUXmcCyv6MblL0fafVZuRjrQdEVKB6fXn7nyGttEmlEY8hRUSEpHvrGPjM59\"," +
                "\"name\": \"Irteza Raju\"," +
                "\"mobile\": \"01666666663\"," +
                "\"type\": \"customer\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/partners/37662/register").
                then().statusCode(200).assertThat()
                .body("customer", not(equalTo(null)))
                .body("customer.id", not(equalTo(null)))
                .body("customer.remember_token", not(equalTo(null)));

    }
}


