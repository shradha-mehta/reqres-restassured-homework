package in.reqres.api.user;

import in.reqres.api.UsersPojo;
import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.api.UsersPojo.getRandomString;
import static io.restassured.RestAssured.given;


public class PatchUsers extends TestBase {
    String name = "Amit" + getRandomString(2);
    String job = "leader"+getRandomString(2);

    @Test

    public void updateUsersJobOnly(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setJob(job);
        usersPojo.setName(name);

        Response response =  given()
                .header("Content-Type","application/json")
                .when()
                .body(usersPojo)
                .patch("/users/5");
        response.then().statusCode(200)
                .log().body();

    }

}
