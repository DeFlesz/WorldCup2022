package org.example;

import org.example.controller.SessionController;
import org.example.layout.LandingPage;
import org.example.layout.SignUpPage;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    int width = 800;
    int height = 600;

    SignUpPage signUpPage;
    LandingPage landingPage;

    SessionController sessionController = new SessionController(this);

    public AppFrame() {
        System.out.println("Creating [AppFrame]");

        setSize(new Dimension(width, height));

        sessionController.invalidate();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void bringToLandingPage() {
        if (signUpPage != null) {
            remove(signUpPage);
            signUpPage = null;
        }
        if (landingPage == null)
            landingPage = new LandingPage(sessionController);

        add(landingPage);
        refreshLayout();
    }

    public void bringToSignUp() {
        if (landingPage != null) {
            remove(landingPage);
            landingPage = null;
        }
        if (signUpPage == null)
            signUpPage = new SignUpPage(sessionController);

        add(signUpPage);
        refreshLayout();
    }

    public void refreshLayout() {
        invalidate();
        validate();
        repaint();
    }

    public SessionController getSessionController() {
        return sessionController;
    }
}
