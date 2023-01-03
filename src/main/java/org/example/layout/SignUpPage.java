package org.example.layout;

import org.example.AppFrame;
import org.example.controller.LoginController;
import org.example.controller.RegisterController;
import org.example.controller.SessionController;
import org.example.view.LoginPanel;
import org.example.view.RegisterPanel;

import javax.swing.*;

public class SignUpPage extends JTabbedPane {
    LoginPanel loginPanel;
    RegisterPanel registerPanel;

    SessionController sessionController;

    public SignUpPage (SessionController sessionController) {
        System.out.println("Creating [SignUpPage]");

        this.sessionController = sessionController;

        loginPanel = new LoginPanel(sessionController);
        addTab("Login", loginPanel);
        registerPanel = new RegisterPanel(sessionController);
        addTab("Register", registerPanel);
    }
}
