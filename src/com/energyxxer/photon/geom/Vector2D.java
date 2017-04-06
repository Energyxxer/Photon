package com.energyxxer.photon.geom;

/**
 * Created by User on 4/4/2017.
 */
public class Vector2D {

    public double x,y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point2D p) {
        return getDistance(p.x,p.y);
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x,2) + Math.pow(this.y - y,2));
    }

    public Vector2D rotate(double angle) {
        double rad = Math.toRadians(angle);
        return new Vector2D(x * Math.cos(rad) - y * Math.sin(rad), x * Math.sin(rad) + y * Math.cos(rad));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void apply(Vector2D vec) {
        this.x += vec.x;
        this.y += vec.y;
    }

    public void applyResistance(double resistance) {
        if(this.x > 0) {
            if(this.x > resistance) this.x -= resistance;
            else this.x = 0;
        } else if(this.x < 0) {
            if(this.x < -resistance) this.x += resistance;
            else this.x = 0;
        }

        if(this.y > 0) {
            if(this.y > resistance) this.y -= resistance;
            else this.y = 0;
        } else if(this.y < 0) {
            if(this.y < -resistance) this.y += resistance;
            else this.y = 0;
        }
    }

    public Vector2D getInverse() {
        return new Vector2D(-this.x, -this.y);
    }

    public void multiply(double factor) {
        this.x *= factor;
        this.y *= factor;
    }
}
