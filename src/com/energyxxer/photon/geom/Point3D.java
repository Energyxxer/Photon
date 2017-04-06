package com.energyxxer.photon.geom;

/**
 * Created by User on 4/5/2017.
 */
public class Point3D {
    public double x,y,z;

    public Point3D() {
        this(0, 0, 0);
    }

    public Point3D(double x, double y, double z) {
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setLocation(Point3D p) {
        setLocation(p.x,p.y,p.z);
    }

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point3D point3D = (Point3D) o;

        if (Double.compare(point3D.x, x) != 0) return false;
        if (Double.compare(point3D.y, y) != 0) return false;
        return Double.compare(point3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ", " + z + ')';
    }

    public void apply(Vector3D vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
    }
}
