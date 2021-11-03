package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.dto.AuthDto;
import pl.akademiaqa.dto.BookingDto;
import pl.akademiaqa.request.auth.PostAuthRequest;
import pl.akademiaqa.request.booking.PatchBookingRequest;
import pl.akademiaqa.request.booking.PostBookingRequest;

import static org.assertj.core.api.Assertions.*;

class PatchBookingTest {

    private static String token;

    @BeforeAll
    static void setup() {
        JSONObject defaultAuth = AuthDto.getDefaultAuth();
        token = PostAuthRequest.createToken(defaultAuth);
    }

    @Test
    void partialUpdateBookingTest() {

        // 1. Tworzymy nowy booking
        JSONObject defaultBooking = BookingDto.getDefaultBooking();
        Response createResponse = PostBookingRequest.createBooking(defaultBooking);
        String bookingId = createResponse.jsonPath().getString("bookingid");

        // 2. Obiekt z nowymi danymi
        JSONObject patchBooking = new JSONObject();
        patchBooking.put("firstname", "Tomek");
        patchBooking.put("lastname", "Czarny");

        // 3. Wysyłamy PATCH na booking
        Response patchResponse = PatchBookingRequest.patchBooking(bookingId, patchBooking, token);
        JsonPath jsonPath = patchResponse.jsonPath();

        assertThat(jsonPath.getString("firstname")).isEqualTo("Tomek");
        assertThat(jsonPath.getString("lastname")).isEqualTo("Czarny");
    }
}
