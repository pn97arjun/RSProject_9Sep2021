import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test03_PUT_PATCH {

    @Test
    public void Test1_PUT()
    {
        JSONObject request=new JSONObject();
        request.put("name","John");
        request.put("job","Police");
        System.out.println(request.toJSONString());

        given().
                header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200)
                .log().all();
    }

    @Test(priority = 1)
    public void Test2_PATCH()
    {
        JSONObject request=new JSONObject();
        request.put("name","John");
        request.put("job","Police");
        System.out.println(request.toJSONString());

        given().
                header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                patch("https://reqres.in/api/users/2").
        then().
                statusCode(200)
                .log().all();
    }
}
