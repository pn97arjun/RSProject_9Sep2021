package com.rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Rest1_GET {

    @Test
    public void Rest01_GET()
    {
        baseURI="http://localhost:3000/";

        given().
               param("name","Devops")
                .get("/subjects").
        then().
                statusCode(200)
                .log().all();

    }
    @Test
    public void Rest02_GET()
    {
        baseURI="http://localhost:3000/";

        given().
                get("/users").
        then().
                statusCode(200)
                .log().all();

    }
}
