package org.example.view;

import org.example.component.FormInput;
import org.example.controller.RegisterController;
import org.example.controller.SessionController;

import javax.swing.*;

public class RegisterPanel extends JPanel {
    RegisterController registerController;
    FormInput nameInput = new FormInput("name:", "John Smith");

    FormInput emailInput = new FormInput("email:", "mail@example.com");

    FormInput passwordInput = new FormInput("password:", "password");
    FormInput confirmPasswordInput = new FormInput("repeat password:", "password");
    JLabel validationText = new JLabel("");

    JButton submitButton = new JButton("Submit");

    public RegisterPanel(SessionController sessionController) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        registerController = new RegisterController(this, sessionController);

        add(nameInput);
        add(emailInput);
        add(passwordInput);
        add(confirmPasswordInput);
        add(validationText);
        add(submitButton);
    }

    public FormInput getNameInput() {
        return nameInput;
    }

    public FormInput getEmailInput() {
        return emailInput;
    }

    public FormInput getPasswordInput() {
        return passwordInput;
    }

    public FormInput getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public JLabel getValidationText() {
        return validationText;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
