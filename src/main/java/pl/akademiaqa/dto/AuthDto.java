package pl.akademiaqa.dto;

import org.json.JSONObject;

public class AuthDto {

    private AuthDto(){}

    public static JSONObject getDefaultAuth() {

        JSONObject authJson = new JSONObject();
        authJson.put("username", "admin");
        authJson.put("password", "password123");

        return authJson;
    }
}
