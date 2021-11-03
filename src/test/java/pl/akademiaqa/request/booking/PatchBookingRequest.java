package pl.akademiaqa.request.booking;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.url.BookingUrl;

import static io.restassured.RestAssured.given;

public class PatchBookingRequest {

    public static Response patchBooking(String bookingId, JSONObject json, String token) {

        return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .header("Cookie", "token=" + token)
                .when()
                .patch(BookingUrl.BASE_URL + BookingUrl.BOOKING + "/" + bookingId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
