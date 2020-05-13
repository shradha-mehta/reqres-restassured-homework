package in.reqres.api.user;

import in.reqres.api.UsersPojo;
import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.api.UsersPojo.getRandomString;
import static io.restassured.RestAssured.given;


public class PostUsers extends TestBase {

    String name = "Amit" + getRandomString(2);
    String job = "leader"+getRandomString(2);
    String email = "Amit" + getRandomString(3)+"@reares.in";
    String password = "Tiger1"+getRandomString(3);


    @Test
        public void creatNewUsers() {
            UsersPojo usersPojo = new UsersPojo();
            usersPojo.setName(name);
            usersPojo.setJob(job);

        Response response =  given()
                .header("Content-Type","application/json")
                .when()
                .body(usersPojo)
                .post("/users");
        response.then().statusCode(201)
       .log().body();

        }

        @Test
    public  void registerUserSuccessfully(){
            UsersPojo usersPojo = new UsersPojo();
            usersPojo.setEmail(email="eve.holt@reqres.in");
            usersPojo.setPassword(password);
            Response  response =  given()
                  .header("Content-Type","application/json")
                    .when()
                    .body(usersPojo)
                    .post("/register");
            response.then().statusCode(200)
                    .log().body();

        }

        @Test
    public void unsuccessfulUserRegistration(){
            UsersPojo usersPojo = new UsersPojo();
            usersPojo.setEmail(email="eve.holt@reqres.in");
            Response  response =  given()
                    .header("Content-Type","application/json")
                    .when()
                    .body(usersPojo)
                    .post("/register");
            response.then().statusCode(400)
                    .log().body();


        }

        @Test
    public  void loginUserSuccessfully(){
            UsersPojo usersPojo = new UsersPojo();
            usersPojo.setEmail(email="eve.holt@reqres.in");
            usersPojo.setPassword(password= "cityslicka");
            Response  response =  given()
                    .header("Content-Type","application/json")
                    .when()
                    .body(usersPojo)
                    .post("/login");
            response.then().statusCode(200)
                    .log().body();
    }

    @Test

    public void unsuccessfullLoginUser(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail(email="eve.holt@reqres.in");
        Response  response =  given()
                .header("Content-Type","application/json")
                .when()
                .body(usersPojo)
                .post("/login");
        response.then().statusCode(400)
                .log().body();

    }


    }



