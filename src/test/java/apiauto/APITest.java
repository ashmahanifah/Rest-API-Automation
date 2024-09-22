package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class APITest {

    //Automate GET request

//    @Test
//    public void getUserTest() {
//        //Define baseURI
//        RestAssured.baseURI = "https://reqres.in/";
//        //Test GET api/users?page=1 with total data 6 per page
//        given().when().get("api/users?page=1")
//                .then()
//                .log().all() //cetak response ke console
//                .assertThat().statusCode(200) //assertion status code=200
//                .assertThat().body("page", Matchers.equalTo(1)) //assertion data page
//                .assertThat().body("data.id", Matchers.hasSize(6)); //assertion count data id
//
//    }

    //Automate POST request
    @Test
    public void createNewUserTest() {
        RestAssured.baseURI = "https://reqres.in/";

    }
}
