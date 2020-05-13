package in.reqres.api.user;

import in.reqres.api.UsersPojo;
import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.api.UsersPojo.getRandomString;
import static io.restassured.RestAssured.given;


public class PutUsers extends TestBase {
    String name = "Amit" + getRandomString(2);
    String job = "leader"+getRandomString(2);
@Test

    public void updateUsers(){
    UsersPojo usersPojo = new UsersPojo();
    usersPojo.setName(name);
    usersPojo.setJob(job);

    Response response =  given()
            .header("Content-Type","application/json")
            .when()
            .body(usersPojo)
            .put("/users/5");
    response.then().statusCode(200)
            .log().body();

}

}
