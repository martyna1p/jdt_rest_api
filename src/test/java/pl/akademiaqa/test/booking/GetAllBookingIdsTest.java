package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.request.booking.GetBookingIdsRequest;

import static org.assertj.core.api.Assertions.*;

class GetAllBookingIdsTest {

    @Test
    void getBookingIdsTest() {
        Response response = GetBookingIdsRequest.getAllBookingIds();
        JsonPath json = response.jsonPath();

        assertThat(json.getList("bookingid").size()).isPositive();
    }
}
