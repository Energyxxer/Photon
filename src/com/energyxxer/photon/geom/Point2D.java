package com.energyxxer.photon.geom;

/**
 * Created by User on 4/3/2017.
 */
public class Point2D {
    public double x,y;

    public Point2D() {
        this(0, 0);
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point2D p) {
        return getDistance(p.x,p.y);
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x,2) + Math.pow(this.y - y,2));
    }

    public Point2D rotate(double angle) {
        double rad = Math.toRadians(angle);
        return new Point2D(x * Math.cos(rad) - y * Math.sin(rad), x * Math.sin(rad) + y * Math.cos(rad));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setLocation(Point2D p) {
        this.setLocation(p.x, p.y);
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public java.awt.Point toAwt() {
        return new java.awt.Point((int) x, (int) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        return Double.compare(point2D.x, x) == 0 && Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ')';
    }

    public void apply(Vector2D vec) {
        this.x += vec.x;
        this.y += vec.y;
    }
}
