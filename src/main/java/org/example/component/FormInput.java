package org.example.component;

import javax.swing.*;
import java.awt.*;

public class FormInput extends JPanel {
    JLabel label;
    JTextField input;

    int maxWidth = 200;
    int maxHeight = 50;

    public FormInput(String inputLabel, String inputHint) {
//        Border border = new EmptyBorder(5, 5, 5, 5);

        label = new JLabel(inputLabel, SwingConstants.LEFT);
//        label.setOpaque(true);
//        label.setBackground(new Color(255));
//        label.setPreferredSize(new Dimension(maxWidth, 32));

//        label.setSize(new Dimension(maxWidth, maxHeight));
//        label.setBorder(border);
        input = new JTextField("", 16);
//        input.setPreferredSize(new Dimension(maxWidth, 50));

//        input.setBorder(border);
        setMaximumSize(new Dimension(maxWidth, maxHeight));

        init();
    }

    public String getText() {
        return input.getText();
    }

    void init(){
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup()
                        .addComponent(label)
                        .addComponent(input));
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addComponent(label)
                .addComponent(input));

        setLayout(groupLayout);

        add(label);
        add(input);

//        layout.putConstraint(SpringLayout.SOUTH, label, SpringLayout.NORTH, input);
    }
}
