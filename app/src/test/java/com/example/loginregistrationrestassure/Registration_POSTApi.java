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
     * Pay ticket POST API
     * Response code - 200
     * Check for null example
     */



    @Test
    public void PayTicket_api_200(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"592\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("code", equalTo(200));


    }


    /**
     * Pay ticket POST API
     * Response code - 500
     */



    @Test
    public void PayTicket_api_500(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("code", equalTo(500));
    }

    /**
     * Pay ticket POST API
     * Response code - 400
     * message: The seat class field is required.
     */



    @Test
    public void PayTicket_api_400(){
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
     * Pay ticket POST API
     * Response code - 403
     * message: You're not authorized to access this user.
     */



    @Test
    public void PayTicket_api_403(){

        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39168/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("code", equalTo(403));
    }


    /**
     * Pay ticket POST API
     * Response code - 404
     * message: User not found.
     */



    @Test
    public void PayTicket_api_404(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"GguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("code", equalTo(404));

    }


    /**
     * Pay ticket POST API
     * Response code - 405
     * message: User not found.
     */



    @Test
    public void PayTicket_api_405(){
        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.put("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(405);
    }



    /**
     * Book ticket POST API
     * Check for null example
     */


    @Test
    public void checkForNullExample() {

        RequestSpecification request = RestAssured.given();

        String body = "{ \"remember_token\": \"YguKQVLGiEJbqZORmlCbRkngzTulqdfRPHYaUMknRXtmnLLDEyfVyVKwMKKCVANpdRLGnaSYsgQYkIyjXOJJlVBECkmQycWdZpjktvURfeQsYLtmgSctAFyyhJZRmEnZkyxyatNaBHYixkUcmcHYNuTjxUzGjfLRCsTDWcjQtzcfinLKXJmXtEdNfEoZVmnnbzOhBKZUgCqIQqifLUCsIDpcPmnmnPjsugtGFqYZSDquNIxIJIFbHPPyxpMQtse\"," +
                "\"payment_method\": \"wallet\"," +
                "\"order_id\": \"587\"}";

        request.header("Content-Type", "application/json");
        request.body(body);

        request.post("/v2/affiliates/39169/transport/bus-ticket/pay").
                then().statusCode(200).assertThat()
                .body("payment", not(equalTo(null)));

    }
}


