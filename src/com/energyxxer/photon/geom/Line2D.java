package com.energyxxer.photon.geom;

/**
 * Created by User on 4/3/2017.
 */
public class Line2D {
    public double x1,y1,x2,y2;

    public Line2D(Point2D a, Point2D b) {
        this(a.getX(),a.getY(),b.getX(),b.getY());
    }

    public Line2D(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }

    public double getAngle() {
        return Math.toDegrees(Math.atan2(y2-y1,x2-x1));
    }

    public Line2D rotate(double angle) {
        return new Line2D(new Point2D(x1,y1).rotate(angle), new Point2D(x2,y2).rotate(angle));
    }

    public Point2D getIntersection(Line2D l) {
        return getIntersection(l, false);
    }

    public Point2D getIntersection(Line2D l, boolean infiniteLength) {
        Point2D intersection;
        {
            //Compare projection of A
            double angle = 90 - getAngle();
            Line2D a = this.rotate(angle);
            Line2D b = l.rotate(angle);

            if(a.x1 >= Math.min(b.x1,b.x2) && a.x1 <= Math.max(b.x1,b.x2)) {
                //May intersect
                double theta = getAngle() - l.getAngle();
                double seg = a.x1 - b.x1;
                double hypot = seg * Math.sin(Math.toRadians(theta));

                intersection = new Point2D(b.x1 + hypot * Math.cos(90 - theta), b.y1 + hypot * Math.sin(90 - theta)).rotate(-angle);
            } else {
                return null;
            }
        }
        if(!infiniteLength){
            //Compare projection of B
            double angle = 90 - l.getAngle();
            Line2D a = l.rotate(angle);
            Line2D b = this.rotate(angle);

            return (a.x1 >= Math.min(b.x1,b.x2) && a.x1 <= Math.max(b.x1,b.x2)) ? intersection : null;
        } else return intersection;
    }

    @Override
    public String toString() {
        return "L[P(" + x1 + ", " + y1 + "), P(" + x2 + ", " + y2 + ")]";
    }
}
