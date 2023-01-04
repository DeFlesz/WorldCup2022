package org.example.API;

import org.example.model.LoginUserModel;
import org.example.model.RegisterUserModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WorldCupAPI {
    /*
    login
     status: success/error
    if error: message
    else: data{token}

    register
     status: success
    if error: message
    else message, data{token}
     */


    URL loginURL;
    URL registerURL;

    public WorldCupAPI() {
        loginURL = initializeURL("http://api.cup2022.ir/api/v1/user/login", "loginURL");
        registerURL = initializeURL("http://api.cup2022.ir/api/v1/user", "registerURL");
    }

    public URL initializeURL(String urlResource, String mName) {
        URL url;
        try {
            url = new URL(urlResource);
        } catch (MalformedURLException e) {
//            e.printStackTrace();
            System.out.println("Failed creatin URL resource: " + mName);
            return null;
        }
        return url;
    }

    public ApiAuthResponse register(RegisterUserModel registerUser) throws IOException {
        return requestApiAuthResponse("{" +
                        "\"name\": \"" + registerUser.getName() + "\"," +
                        "\"email\": \"" + registerUser.getEmail() + "\"," +
                        "\"password\": \"" + registerUser.getPassword() + "\"," +
                        " \"passwordConfirm\": \"" + registerUser.getConfirmPassword() +
                        "\"}", registerURL);
    }

    public ApiAuthResponse login(LoginUserModel loginUser) throws IOException {
         return requestApiAuthResponse("{" +
                "\"email\": \"" + loginUser.getEmail() + "\"," +
                " \"password\": \"" + loginUser.getPassword() +
                "\"}", loginURL);
    }

    public ApiAuthResponse requestApiAuthResponse(String request, URL url) throws IOException {
        System.out.println(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.getOutputStream()
                .write((request)
                        .getBytes(StandardCharsets.UTF_8));
        String response = "";
        Scanner scanner;
        if (connection.getResponseCode() >= 400) {
            scanner = new Scanner(connection.getErrorStream());
        } else {
            scanner = new Scanner(connection.getInputStream());
        }

        while (scanner.hasNext()){
            response += scanner.nextLine();
        }
        scanner.close();
        JSONObject responseJSON = retrieveJSONObject(response);

        if (responseJSON == null) {
            return null;
        }
        String status = retrieveString(responseJSON, "status");
        String message = retrieveString(responseJSON, "message");

        JSONObject dataJSON = retrieveJSONObject(responseJSON, "data");
        String token = null;
        if (dataJSON != null) {
            token = retrieveString(dataJSON, "token");
        }

        ApiAuthResponse apiAuthResponse = new ApiAuthResponse(message, token, status);

        System.out.println(apiAuthResponse);

        return apiAuthResponse;
    }

    public String retrieveString(JSONObject jsonObject, String key){
        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    public JSONObject retrieveJSONObject(String content) {
        try{
            return new JSONObject(content);
        } catch (JSONException e) {
            return null;
        }
    }

    public JSONObject retrieveJSONObject(JSONObject jsonObject, String key) {
        try{
            return jsonObject.getJSONObject(key);
        } catch (JSONException e) {
            return null;
        }
    }

}
