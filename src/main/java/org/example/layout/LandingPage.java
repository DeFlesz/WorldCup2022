package org.example.layout;

import org.example.controller.SessionController;

import javax.swing.*;
import java.awt.*;

public class LandingPage extends JPanel {
    SessionController sessionController;

//   Might be a tabbed layout
//   TODO
//    teams
//    match list
//    match ladder
//    group standings

    public LandingPage(SessionController sessionController) {
        System.out.println("Creating [LandingPage]");
        this.sessionController = sessionController;

        System.out.println(sessionController.getToken());

        add(new JLabel(sessionController.getToken()), BorderLayout.CENTER);
    }
}
