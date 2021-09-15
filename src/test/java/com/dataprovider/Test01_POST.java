package com.dataprovider;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test01_POST {

    @DataProvider(name = "dataPost")
    public Object[][] dataParameter()
    {
        Object[][] data=new Object[2][3];

        data[0][0]="Tony";
        data[0][1]="Cruise";
        data[0][2]=2;

        data[1][0]="Martin";
        data[1][1]="Crowe";
        data[1][2]=2;

        return data;
    }
    @DataProvider(name="hardCode")
    public Object[][] dataHardCode()
    {
        return new Object[][]{
                {"George","Bush",1}

        };
    }

    @Test(dataProvider = "dataPost")
    public void Test1_DATAPOST(String firstName,String lastName,int subjectId)
    {
        baseURI="http://localhost:3000/";

        JSONObject request=new JSONObject();
        request.put("firstname",firstName);
        request.put("lastname",lastName);
        request.put("subjectId",subjectId);

        given()
                .header("content-type","application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                post("/users")
       .then()
                .statusCode(201)
                .log().all();

    }
}
