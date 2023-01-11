package org.example.controller;

import org.example.util.model.Match;
import org.example.view.FiltrableMatchListPanel;
import org.example.view.MatchListPanel;

import java.util.ArrayList;

public class FiltrableMatchListController {
    FiltrableMatchListPanel context;

    public FiltrableMatchListController(FiltrableMatchListPanel context, ArrayList<Match> matches) {
        this.context = context;

        context.getSubmit().addActionListener(l -> {
            if (getData() == null) { return; }
//            System.out.println(getData());
            context.setMatchListPanel(new MatchListPanel(matches, getData()));
        });
    }

    public String getData() {
        return context.getSearchInput().getText();
    }
}
