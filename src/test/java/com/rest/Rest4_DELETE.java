package com.rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Rest4_DELETE {

    @Test
    public void Rest01_DELETE()
    {
        baseURI="http://localhost:3000/";

        when().
                delete("/users/4")
        .then().
                statusCode(200).
                log().all();

    }
}
