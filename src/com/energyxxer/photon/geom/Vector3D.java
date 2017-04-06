package com.energyxxer.photon.geom;

/**
 * Created by User on 4/5/2017.
 */
public class Vector3D {

    public double x,y,z;

    public Vector3D() {
        this(0, 0, 0);
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistance(Point3D p) {
        return getDistance(p.x,p.y,p.z);
    }

    public double getDistance(double x, double y, double z) {
        return Math.sqrt(Math.pow(this.x - x,2) + Math.pow(this.y - y,2) + Math.pow(this.z - z,2));
    }

    public Vector2D rotate(double yaw) {
        double rad = Math.toRadians(yaw);
        return new Vector2D(x * Math.cos(rad) - y * Math.sin(rad), x * Math.sin(rad) + y * Math.cos(rad));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void apply(Vector3D vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
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

        if(this.z > 0) {
            if(this.z > resistance) this.z -= resistance;
            else this.z = 0;
        } else if(this.z < 0) {
            if(this.z < -resistance) this.z += resistance;
            else this.z = 0;
        }
    }

    public Vector3D getInverse() {
        return new Vector3D(-this.x, -this.y, -this.z);
    }

    public void multiply(double factor) {
        this.x *= factor;
        this.y *= factor;
        this.z *= factor;
    }
}
