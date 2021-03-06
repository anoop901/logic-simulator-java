package com.naravaram.anoop;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

/**
 * Created by anoop on 7/15/15.
 */
public class LogicSimPanel extends JPanel implements MouseListener, MouseMotionListener {

    private final LogicModule module;

    private final CreateLogicBlockMenu createMenu;

    private LogicBlock draggingBlock;

    public LogicSimPanel() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1000, 800));
        this.module = new LogicModule();

        this.createMenu = new CreateLogicBlockMenu(this);

        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        module.paint(g2);
    }

    public LogicModule getModule() {
        return module;
    }

    /* MouseListener methods */

    @Override
    public void mousePressed(MouseEvent e) {

        // figure out which block was clicked, if any
        this.draggingBlock = null;
        for (LogicBlock block : module.getBlocks()) {
            if (block.getBounds().contains(e.getPoint())) {
                this.draggingBlock = block;
                break;
            }
        }

        maybeShowPopupMenu(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.draggingBlock = null;
        maybeShowPopupMenu(e);
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    private void maybeShowPopupMenu(MouseEvent e) {
        if (e.isPopupTrigger()) {
            this.createMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    /* MouseMotionListener methods */

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.draggingBlock != null) {
            this.draggingBlock.setPosition(new Point2D.Double(e.getX(), e.getY()));
            this.repaint();
        }
    }

    @Override public void mouseMoved(MouseEvent e) {}
}
