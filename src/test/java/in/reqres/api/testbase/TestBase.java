package in.reqres.api.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void inIT() {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }
}
