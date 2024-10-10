package apiauto;
import io.restassured.module.jsv.JsonSchemaValidator;

import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class APITest {

    @Test
    public void testStatusCode() {
        ValidatableResponse response = APIUtil.getAirportByCode("CGK");
        response.assertThat()
                .statusCode(200)
                .assertThat()
                .body("data.attributes.name", equalTo("Soekarno-Hatta International Airport"));
    }

    @Test
    public void testPositiveCaseInput() {
        String valueFrom = "CGK";
        String valueTo = "NRT";

        File file = new File("src/test/resources/jsonSchema/GetAirportDataSchema.json");

        ValidatableResponse response = APIUtil.postAirportDistance(valueFrom, valueTo);
        response.assertThat()
                .statusCode(200)
                .assertThat()
                .body("data.attributes.from_airport.iata", equalTo(valueFrom))
                .body(JsonSchemaValidator.matchesJsonSchema(file));
    }

    @Test
    public void testNegativeCaseInput(){
        String valueFrom = "1234??";
        String valueTo = "NRT";

        ValidatableResponse response = APIUtil.postAirportDistance(valueFrom, valueTo);
        response.assertThat()
                .statusCode(422); //  the API returns 422 for invalid input
    }

    @Test
    public void testEdgeCase(){
        ValidatableResponse response = APIUtil.getAirportsWithPage(0);
        response.assertThat()
                .statusCode(404); // the API returns 400 for not found page parameter
    }


}
