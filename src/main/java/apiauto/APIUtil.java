package apiauto;


import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APIUtil {

    static {
        RestAssured.baseURI = "https://airportgap.com/";
    }

    public static ValidatableResponse getAirportByCode(String airportCode) {
        return given()
                .when()
                .get("api/airports/" + airportCode)
                .then()
                .log().all();
    }

    public static ValidatableResponse postAirportDistance(String from, String to) {
        JSONObject bodyObject = new JSONObject();
        bodyObject.put("from", from);
        bodyObject.put("to", to);

        return given()
                .header("Content-Type", "application/json")
                .body(bodyObject.toString())
                .when()
                .post("api/airports/distance")
                .then()
                .log().all();
    }

    public static ValidatableResponse getAirportsWithPage(int page) {
        return given()
                .when()
                .get("api/airports?page=" + page)
                .then()
                .log().all();
    }
}
