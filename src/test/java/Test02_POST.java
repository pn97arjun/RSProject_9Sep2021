import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class Test02_POST {

    @Test(priority = 2)
    public void test1_POST()
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","Arjun");
        map.put("job","AE");

        System.out.println(map);

        JSONObject request=new JSONObject(map);
        System.out.println(request.toJSONString());

        given().
                header("content-type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
         then()
                .statusCode(201)
                .log().all();


    }
    @Test(priority = 1)
    public void test2_POST()
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
                post("https://reqres.in/api/users").
        then().
                statusCode(201)
                .log().all();
    }
}
