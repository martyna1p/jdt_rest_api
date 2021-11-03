package pl.akademiaqa.test.booking;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.dto.AuthDto;
import pl.akademiaqa.dto.BookingDto;
import pl.akademiaqa.request.auth.PostAuthRequest;
import pl.akademiaqa.request.booking.DeleteBookingRequest;
import pl.akademiaqa.request.booking.PostBookingRequest;
import static org.assertj.core.api.Assertions.assertThat;

class DeleteBookingTest {

    private static String token;

    @BeforeAll
    static void setup() {
        JSONObject defaultAuth = AuthDto.getDefaultAuth();
        token = PostAuthRequest.createToken(defaultAuth);
    }

    @Test
    void deleteBookingTest() {

        // 1. Tworzymy nowy booking
        JSONObject defaultBooking = BookingDto.getDefaultBooking();
        Response createResponse = PostBookingRequest.createBooking(defaultBooking);
        String bookingId = createResponse.jsonPath().getString("bookingid");

        // 2. Wysyłamy DELETE na booking
        Response deleteResponse = DeleteBookingRequest.deleteBooking(bookingId, token);
        assertThat(deleteResponse.getStatusCode()).isEqualTo(201);
    }
}
