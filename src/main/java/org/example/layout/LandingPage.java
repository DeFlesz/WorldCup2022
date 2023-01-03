package org.example.layout;

import org.example.AppFrame;
import org.example.controller.SessionController;

import javax.swing.*;

public class LandingPage extends JPanel {
    SessionController sessionController;

    public LandingPage(SessionController sessionController) {
        System.out.println("Creating [LandingPage]");
        this.sessionController = sessionController;

        System.out.println(sessionController.getToken());
    }
}
