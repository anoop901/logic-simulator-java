package com.naravaram.anoop;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by anoop on 7/15/15.
 */
public abstract class LogicBlock {

    private Point2D.Double position;

    public abstract void paint(Graphics2D g);

    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public abstract Dimension getDimension();

    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(
                position.x - this.getDimension().getWidth() / 2, position.y - this.getDimension().getHeight() / 2,
                this.getDimension().getWidth(), this.getDimension().getHeight());
    }
}
