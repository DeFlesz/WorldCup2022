package org.example.API;

import org.example.builder.MatchBuilder;
import org.example.builder.TeamBuilder;
import org.example.model.LoginUser;
import org.example.model.Match;
import org.example.model.RegisterUser;
import org.example.model.Team;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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

    public ApiAuthResponse register(RegisterUser registerUser) throws IOException {
        return requestApiAuthResponse("{" +
                        "\"name\": \"" + registerUser.getName() + "\"," +
                        "\"email\": \"" + registerUser.getEmail() + "\"," +
                        "\"password\": \"" + registerUser.getPassword() + "\"," +
                        " \"passwordConfirm\": \"" + registerUser.getConfirmPassword() +
                        "\"}", registerURL);
    }

    public ApiAuthResponse login(LoginUser loginUser) throws IOException {
         return requestApiAuthResponse("{" +
                "\"email\": \"" + loginUser.getEmail() + "\"," +
                " \"password\": \"" + loginUser.getPassword() +
                "\"}", loginURL);
    }

//    not needed - would cause to much traffic on the API server
    public Team requestTeamData(String token, String teamID) throws IOException {
        URL matchURL = new URL("http://api.cup2022.ir/api/v1/team/"+teamID);
        HttpURLConnection matchConn = (HttpURLConnection) matchURL.openConnection();
        matchConn.setRequestMethod("GET");
        matchConn.setRequestProperty("Authorization", "Bearer "+token);
        matchConn.setRequestProperty("Content-type", "application/json");
        String response = "";
        Scanner scanner = new Scanner(matchConn.getInputStream());
        while (scanner.hasNext()){
            response += scanner.nextLine();
        }
        scanner.close();
        JSONObject responseJSON = new JSONObject(response);
        JSONObject data = responseJSON.getJSONObject("data");
        Team team = new TeamBuilder()
                .set_id(retrieveString(data, "_id"))
                .setId(retrieveString(data, "id"))
                .setName(retrieveString(data, "name_en"))
                .setFlag(retrieveString(data, "flag"))
                .setFifa_code(retrieveString(data, "fifa_code"))
                .setGroup(retrieveString(data, "groups"))
                .createTeam();

        System.out.println("Team: " + team);

        return team;
    }

    public ArrayList<Team> requestAllTeamsData(String token) throws IOException {
        URL matchURL = new URL("http://api.cup2022.ir/api/v1/team");
        HttpURLConnection matchConn = (HttpURLConnection) matchURL.openConnection();
        matchConn.setRequestMethod("GET");
        matchConn.setRequestProperty("Authorization", "Bearer "+token);
        matchConn.setRequestProperty("Content-type", "application/json");
        String response = "";
        Scanner scanner = new Scanner(matchConn.getInputStream());
        while (scanner.hasNext()){
            response += scanner.nextLine();
        }
        scanner.close();
        JSONObject responseJSON = new JSONObject(response);
        JSONArray teamJSONArray = responseJSON.getJSONArray("data");
        ArrayList<Team> teamArray = new ArrayList<>();

        for (int i = 0; i < teamJSONArray.length(); i++) {
            JSONObject teamJSON = teamJSONArray.getJSONObject(i);
            Team team = new TeamBuilder()
                    .set_id(retrieveString(teamJSON, "_id"))
                    .setId(retrieveString(teamJSON, "id"))
                    .setName(retrieveString(teamJSON, "name_en"))
                    .setFlag(retrieveString(teamJSON, "flag"))
                    .setFifa_code(retrieveString(teamJSON, "fifa_code"))
                    .setGroup(retrieveString(teamJSON, "groups"))
                    .createTeam();

            teamArray.add(team);
        }

//        System.out.println("Teams: " + teamArray);
        return teamArray;
//        return new TeamBuilder()
//                .set_id(retrieveString(data, "_id"))
//                .setId(retrieveString(data, "id"))
//                .setName(retrieveString(data, "name_en"))
//                .setFlag(retrieveString(data, "flag"))
//                .setFifa_code(retrieveString(data, "fifa_code"))
//                .setGroup(retrieveString(data, "groups"))
//                .createTeam();
    }

    public ArrayList<Match> requestMatchData(String token) throws IOException {
        URL matchURL = new URL("http://api.cup2022.ir/api/v1/match");
        HttpURLConnection matchConn = (HttpURLConnection) matchURL.openConnection();
        matchConn.setRequestMethod("GET");
        matchConn.setRequestProperty("Authorization", "Bearer "+token);
        matchConn.setRequestProperty("Content-type", "application/json");
        String response = "";
        Scanner scanner = new Scanner(matchConn.getInputStream());
        while (scanner.hasNext()){
            response += scanner.nextLine();
        }
        scanner.close();
        JSONObject responseJSON = new JSONObject(response);
        JSONArray matchJSONArray = responseJSON.getJSONArray("data");
        ArrayList<Match> matchArray = new ArrayList<>();

        for (int i = 0; i < matchJSONArray.length(); i++) {
            JSONObject matchJSON = matchJSONArray.getJSONObject(i);
            Match match = new MatchBuilder()
                    .setType(retrieveString(matchJSON, "type"))
                    .setDate(retrieveString(matchJSON, "local_date"))
                    .setHomeTeamEn(retrieveString(matchJSON, "home_team_en"))
                    .setHomeFlag(retrieveString(matchJSON, "home_flag"))
                    .setHomeScore(""+retrieveInt(matchJSON, "home_score"))
                    .setAwayTeamEn(retrieveString(matchJSON, "away_team_en"))
                    .setAwayFlag(retrieveString(matchJSON, "away_flag"))
                    .setAwayScore(""+retrieveInt(matchJSON, "away_score"))
                    .createMatch();

            matchArray.add(match);
        }

//        System.out.println(matchArray);

        return matchArray;
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

//        System.out.println(apiAuthResponse);

        return apiAuthResponse;
    }

    public String retrieveString(JSONObject jsonObject, String key){
        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    public int retrieveInt(JSONObject jsonObject, String key){
        try {
            return jsonObject.getInt(key);
        } catch (JSONException e) {
            return -1;
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

    public static Thread setImage(URL imageURL, JLabel imageContainer) {
        Runnable runnable = () -> {
//            System.out.println("setImage: async bind item");


            ImageIcon imageIcon = null;
            try {
                imageIcon = new ImageIcon(ImageIO.read(imageURL));
                imageContainer.setIcon(imageIcon);
            } catch (IOException e) {
                System.out.println("setImage: image not found");
            }
        };

        return new Thread(runnable);
    }

}
