import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test04_DELETE {
    @Test
    public void Test1_Delete()
    {
        given()
                .delete("https://reqres.in/api/users/2").
        then().
                statusCode(204)
                .log().all();
    }
}
