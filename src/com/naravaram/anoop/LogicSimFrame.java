package com.naravaram.anoop;

import javax.swing.*;
import java.awt.*;

public class LogicSimFrame extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogicSimFrame();
            }
        });
    }

    LogicSimFrame() {
        super("Logic Simulator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));
        contentPane.add(new LogicSimPanel());
        contentPane.add(new Label("This is the menu."), BorderLayout.LINE_START);

        this.setContentPane(contentPane);

        this.pack();
        this.setVisible(true);
    }
}
