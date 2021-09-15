package com.rest;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Rest3_PATCH_PUT {

    @Test //PATCH
    public void Rest01_PATCH()
    {
        baseURI="http://localhost:3000/";

        JSONObject request=new JSONObject();
        request.put("subjectId",1);

        given()
                .header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).

        when().
                patch("/users/4")
        .then().
                statusCode(200)
                .log().all();
    }

    @Test //PUT
    public void Rest02_PUT()
    {
        baseURI="http://localhost:3000/";

        JSONObject request=new JSONObject();
        request.put("firstname","Mary");
        request.put("lastname","Blessie");

        given()
                .header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).

        when().
                put("/users/4")
        .then().
                statusCode(200)
                .log().all();
    }
}
