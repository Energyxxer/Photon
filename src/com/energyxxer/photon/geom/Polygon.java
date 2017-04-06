package com.energyxxer.photon.geom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by User on 4/3/2017.
 */
public class Polygon {
    private ArrayList<Point2D> vertices = new ArrayList<>();

    public Polygon(Point2D... vertices) {
        Collections.addAll(this.vertices, vertices);
    }

    public boolean contains(Point2D p) {
        int hits = 0;
        Line2D l = new Line2D(p.x, p.y, p.x + 1, p.y);
        for(int i = 0; i < vertices.size(); i++) {
            Point2D a = vertices.get(i);
            Point2D b = vertices.get((i+1 == vertices.size()) ? 0 : i+1);
            if(l.getIntersection(new Line2D(a,b)) != null) {
                hits++;
            }
        }
        return (hits ^ 1) == 0;
    }
}
