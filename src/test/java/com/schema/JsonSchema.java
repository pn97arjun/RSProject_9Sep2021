package com.schema;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class JsonSchema {

    @Test
    public void testGet()
    {
        baseURI="https://reqres.in/";

        given().
               get("/users?page=2")
       .then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
    @Test
    public void validateSoapXML()
    {
        baseURI="https://ecs.syr.edu/faculty/fawcett/handouts/cse686/code/calcWebService/Calc.asmx";

        given().
                contentType("test/xml")
                .accept(ContentType.XML);
    }
}
