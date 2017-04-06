package com.energyxxer.photon.geom;

/**
 * Created by User on 4/5/2017.
 */
public class Rectangle2D {
    public double x,y,width,height;

    public Rectangle2D() {
        this(0, 0, 0, 0);
    }

    public Rectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Point2D p) {
        return p.x >= x && p.x <= x+width && p.y >= y && p.y <= y+height;
    }
}
