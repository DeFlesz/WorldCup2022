package org.example.controller;

import org.example.model.LoginUserModel;
import org.example.view.LoginPanel;

public class LoginController {
    LoginPanel context;
    SessionController sessionController;

    public LoginController(LoginPanel context, SessionController sessionController) {
        this.context = context;
        this.sessionController = sessionController;

        context.getSubmitButton().addActionListener(l -> {
//          TODO -> validation, api response, landing
            LoginUserModel loginUserModel = new LoginUserModel(
                    getEmail(),
                    getPassword()
            );
            System.out.println(loginUserModel);
//          TODO -> put here api response why validation failed
            setValidationText("login validation");

//            for testing purposes, finally put here api response
            sessionController.setToken(loginUserModel.toString());
            sessionController.invalidate();
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
