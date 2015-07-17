package com.naravaram.anoop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

/**
 * Created by anoop on 7/16/15.
 */
public class CreateLogicBlockMenu extends JPopupMenu {

    private LogicSimPanel logicSimPanel;
    private Point2D.Double position;

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public Point2D.Double getPosition() {
        return position;
    }

    private enum LogicBlockType {
        AND_GATE,
        OR_GATE
    }

    public CreateLogicBlockMenu(LogicSimPanel logicSimPanel) {

        this.logicSimPanel = logicSimPanel;

        for (LogicBlockType blockType : LogicBlockType.values()) {

            String name = null;
            switch (blockType) {
                case AND_GATE:
                    name = "AND Gate";
                    break;
                case OR_GATE:
                    name = "OR Gate";
                    break;
            }

            JMenuItem menuItem = new JMenuItem(name);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LogicBlock lb = null;
                    switch (((JMenuItem) e.getSource()).getText()) {
                        case "AND Gate":
                            lb = new AndGate(CreateLogicBlockMenu.this.position);
                            break;
                        case "OR Gate":
                            lb = new OrGate(CreateLogicBlockMenu.this.position);
                            break;
                    }
                    logicSimPanel.getModule().addBlock(lb);
                    logicSimPanel.repaint();
                }
            });

            this.add(menuItem);
        }
    }
}
