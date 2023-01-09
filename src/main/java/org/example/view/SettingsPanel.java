package org.example.view;

import org.example.controller.SessionController;

import javax.swing.*;

public class SettingsPanel extends JPanel {
    SessionController sessionController;

    public SettingsPanel(SessionController sessionController) {
        this.sessionController = sessionController;

        JButton logoutButton = new JButton("logout");
        logoutButton.addActionListener(l -> {
            sessionController.setToken(null);
            sessionController.invalidate();
        });

        add(logoutButton, GroupLayout.Alignment.CENTER);
    }
}
