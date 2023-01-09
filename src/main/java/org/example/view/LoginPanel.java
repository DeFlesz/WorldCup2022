package org.example.view;

import org.example.component.FormInput;
import org.example.controller.LoginController;
import org.example.controller.SessionController;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    LoginController loginController;
    FormInput emailInput = new FormInput("email:", "mail@example.com");
    FormInput passwordInput = new FormInput("password:", "password");

    JLabel validationText = new JLabel("");

    JButton submitButton = new JButton("Submit");

    public LoginPanel(SessionController sessionController) {
//        setLayout(new GridBagLayout());
//        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        GroupLayout groupLayout = new GroupLayout(this);
        setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        loginController = new LoginController(this, sessionController);

        validationText.setForeground(new Color(0xFF0000));

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup()
                .addComponent(emailInput)
                .addComponent(passwordInput)
                .addComponent(validationText)
                .addComponent(submitButton));

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addComponent(emailInput)
                .addComponent(passwordInput)
                .addComponent(validationText)
                .addComponent(submitButton));


        add(emailInput);
        add(passwordInput);
        add(validationText);
        add(submitButton);
    }

    public FormInput getEmailInput() {
        return emailInput;
    }

    public FormInput getPasswordInput() {
        return passwordInput;
    }

    public JLabel getValidationText() {
        return validationText;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
