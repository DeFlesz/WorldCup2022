package org.example.component;

import javax.swing.*;
import java.awt.*;

public class FormInput extends JPanel {
    JLabel label;
    JTextField input;

    int maxWidth = 200;
    int maxHeight = 100;

    public FormInput(String inputLabel, String inputHint) {
        label = new JLabel(inputLabel);
        input = new JTextField(inputHint);
        setMaximumSize(new Dimension(maxWidth, maxHeight));

        init();
    }

    public FormInput(String inputLabel, String inputHint, Dimension d) {
        label = new JLabel(inputLabel);
        input = new JTextField(inputHint);
        setMaximumSize(d);

        init();
    }

    public String getText() {
        return input.getText();
    }

    void init(){

//        setMaximumSize(new Dimension(maxWidth, maxHeight));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(label);
        add(input);

    }
}
