package org.example.view;

import org.example.controller.FiltrableMatchListController;
import org.example.util.model.Match;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiltrableMatchListPanel extends JPanel {
    FiltrableMatchListController filtrableMatchListController;

    MatchListPanel matchListPanel;
    JTextField searchInput;
    JButton submit;

    public FiltrableMatchListPanel(ArrayList<Match> matches) {
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());
        header.setBackground(new Color(125, 125, 125, 125));

        searchInput = new JTextField(16);
        submit = new JButton(">>");

        header.add(searchInput);
        header.add(submit);

        add(header, BorderLayout.NORTH);

        matchListPanel = new MatchListPanel(matches, null);
        add(matchListPanel, BorderLayout.CENTER);

        filtrableMatchListController = new FiltrableMatchListController(this, matches);
    }

    public JTextField getSearchInput() {
        return searchInput;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setMatchListPanel(MatchListPanel matchListPanel) {
        this.matchListPanel = matchListPanel;
        remove(1);
        add(matchListPanel, BorderLayout.CENTER);
        validate();
        invalidate();
        repaint();
    }
}
