
import static io.restassured.RestAssured.*;

import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

    @Test
    void test1_GET()
    {
        Response response=get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.SECONDS));

        int statusCode=response.getStatusCode();

        Assert.assertEquals(statusCode,200);
    }
    @Test
    void test2_GET()
    {
        given().
                get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .body("data.first_name",hasItem("Michael"))
                .log().all();



    }

}
