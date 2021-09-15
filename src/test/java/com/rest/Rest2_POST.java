package com.rest;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class Rest2_POST {
    @Test
    public void Rest01_POST()
    {
        baseURI="http://localhost:3000/";

        JSONObject request=new JSONObject();
        request.put("firstname","Kevin");
        request.put("lastname","Peterson");
        request.put("subjectId",1);

        given()
                .header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).

        when().
                post("/users")
       .then().
                statusCode(201)
                .log().all();
    }

}
