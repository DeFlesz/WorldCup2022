package org.example.controller;

import org.example.API.ApiAuthResponse;
import org.example.API.WorldCupAPI;
import org.example.model.LoginUserModel;
import org.example.view.LoginPanel;

import java.io.IOException;

public class LoginController {
    LoginPanel context;
    SessionController sessionController;
    WorldCupAPI api;

    public LoginController(LoginPanel context, SessionController sessionController) {
        this.context = context;
        this.sessionController = sessionController;
        api = new WorldCupAPI();

        context.getSubmitButton().addActionListener(l -> {
            LoginUserModel loginUser = new LoginUserModel(
                    getEmail(),
                    getPassword()
            );
            System.out.println(loginUser);
//            sessionController.setToken("asdf");
//            sessionController.invalidate();
            try {
                ApiAuthResponse response = api.login(loginUser);
                String status = response.getStatus();

                switch (status){
                    case "success":
                        sessionController.setToken(response.getToken());
                        sessionController.invalidate();
                        break;
                    case "error":
                        setValidationText(response.getMessage());
                        break;

                    default:
                        System.out.println("unimplemented status value: " + status);
                }
            } catch (IOException e) {
                e.printStackTrace();
                setValidationText("couldn't get an API response");
            }
        });
    }

    public String getEmail() {
        return context.getEmailInput().getText();
    }

    public String getPassword() {
        return context.getPasswordInput().getText();
    }

    public void setValidationText(String validationMessage) {
        context.getValidationText().setText(validationMessage);
    }
}
