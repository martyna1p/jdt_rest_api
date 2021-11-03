package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.dto.BookingDto;
import pl.akademiaqa.request.booking.PostBookingRequest;

import static org.assertj.core.api.Assertions.*;

class CreateBookingTest {

    @Test
    void createBookingTest() {

        final JSONObject booking = BookingDto.getDefaultBooking();
        Response response = PostBookingRequest.createBooking(booking);
        JsonPath json = response.jsonPath();

        assertThat(json.getString("booking.firstname")).isEqualTo("Bartek");
        assertThat(json.getString("booking.lastname")).isEqualTo("Testowy");
    }
}
