package org.example.view;

import org.example.controller.SessionController;
import org.example.controller.StandingController;

import javax.swing.*;
import java.awt.*;

public class StandingsPanel extends JPanel {
    StandingController standingController;

    public StandingsPanel(SessionController sessionController) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Standings Panel"), BorderLayout.CENTER);

        standingController = new StandingController(sessionController, this);
    }
}
