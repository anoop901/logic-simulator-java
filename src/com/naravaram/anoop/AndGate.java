package com.naravaram.anoop;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * Created by anoop on 7/15/15.
 */
public class AndGate extends LogicBlock {

    public AndGate() {
        this(new Point2D.Double(200, 100));
    }

    public AndGate(Point2D.Double position) {
        this.setPosition(position);
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(50, 50);
    }

    @Override
    public void paint(Graphics2D g2) {
        GeneralPath gp = new GeneralPath();
        double x = this.getPosition().x;
        double y = this.getPosition().y;
        gp.moveTo(x - 20, y - 20);
        gp.lineTo(x, y - 20);
        gp.quadTo(x + 20, y - 20, x + 20, y);
        gp.quadTo(x + 20, y + 20, x, y + 20);
        gp.lineTo(x - 20, y + 20);
        gp.closePath();

        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        g2.draw(gp);
    }
}
