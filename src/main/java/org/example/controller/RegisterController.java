package org.example.controller;

import org.example.model.RegisterUserModel;
import org.example.view.RegisterPanel;

public class RegisterController {
    RegisterPanel context;
    SessionController sessionController;
    public RegisterController(RegisterPanel context, SessionController sessionController) {
        this.context = context;
        this.sessionController = sessionController;

        context.getSubmitButton().addActionListener(l -> {
            RegisterUserModel registerUserModel = new RegisterUserModel(getName(),
                    getEmail(),
                    getPassword(),
                    getConfirmPassword()
            );

            System.out.println(registerUserModel);
//          TODO -> put here api response why validation failed
            setValidationText("register validation");
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
