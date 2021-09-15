package com.dataprovider;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test02_Delete {

    @DataProvider(name = "dataToDelete")
    public Object[] dataDelete()
    {
        return new Object[]{
               5,6,7,8
        };
    }
    @Test(dataProvider = "dataToDelete")
    public void deleteByDataProvider(int userId)
    {
        baseURI="http://localhost:3000/";

        when()
                .delete("/users/"+userId)
        .then()
                .statusCode(200)
                .log().all();
    }

}
