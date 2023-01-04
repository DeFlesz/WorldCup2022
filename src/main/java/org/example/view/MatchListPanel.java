package org.example.view;

import org.example.controller.SessionController;

import javax.swing.*;
import java.awt.*;

public class MatchListPanel extends JPanel {

    public MatchListPanel(SessionController sessionController) {
        add(new JLabel("Match List Panel"), BorderLayout.CENTER);

        JButton jButton = new JButton("wyloguj");
        add(jButton, BorderLayout.EAST);

        jButton.addActionListener(l -> {
            sessionController.setToken(null);
            sessionController.invalidate();
        });
    }
}
