package org.example.controller;

import org.example.API.ApiAuthResponse;
import org.example.API.WorldCupAPI;
import org.example.util.model.RegisterUser;
import org.example.view.RegisterPanel;

import java.io.IOException;

public class RegisterController {
    WorldCupAPI api;
    RegisterPanel context;
    SessionController sessionController;
    public RegisterController(RegisterPanel context, SessionController sessionController) {
        this.context = context;
        this.sessionController = sessionController;

        api = new WorldCupAPI();

        context.getSubmitButton().addActionListener(l -> {
            RegisterUser registerUser = new RegisterUser(
                    getName(),
                    getEmail(),
                    getPassword(),
                    getConfirmPassword()
            );

            System.out.println(registerUser);

            try {
                ApiAuthResponse response = api.register(registerUser);
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

    public String getName() {
        return context.getNameInput().getText();
    }

    public String getEmail() {
        return context.getEmailInput().getText();
    }

    public String getPassword() {
        return context.getPasswordInput().getText();
    }

    public String getConfirmPassword() {
        return context.getConfirmPasswordInput().getText();
    }
    public void setValidationText(String validationMessage) {
        context.getValidationText().setText(validationMessage);
    }
}
