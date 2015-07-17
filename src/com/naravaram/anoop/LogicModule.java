package com.naravaram.anoop;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by anoop on 7/15/15.
 */
public class LogicModule {

    private ArrayList<LogicBlock> blocks;

    public LogicModule() {
        blocks = new ArrayList<>();
        blocks.add(new AndGate());
        blocks.add(new OrGate());
    }

    public void paint(Graphics2D g2) {
        for (LogicBlock b : blocks) {
            b.paint(g2);
        }
    }

    public void addBlock(LogicBlock lb) {
        blocks.add(lb);
    }

    public ArrayList<LogicBlock> getBlocks() {
        return blocks;
    }
}
