package pl.akademiaqa.dto;

import org.json.JSONObject;

public class BookingDto {

    private BookingDto() {}

    public static JSONObject getDefaultBooking() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        JSONObject booking = new JSONObject();
        booking.put("firstname", "Bartek");
        booking.put("lastname", "Testowy");
        booking.put("totalprice", 1000);
        booking.put("depositpaid", true);
        booking.put("additionalneeds", "sauna");
        booking.put("bookingdates", bookingdates);

        return booking;
    }
}
