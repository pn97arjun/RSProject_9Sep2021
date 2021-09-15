package com.parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class Test01_DELETE {


    @Parameters({"userId"})
    @Test
    public void Test1(int userID)
    {
        System.out.println("Param value: "+userID);
        baseURI="http://localhost:3000/";

        when().
                delete("/users/"+userID)
       .then()
                .statusCode(200)
                .log().all();
    }
}
