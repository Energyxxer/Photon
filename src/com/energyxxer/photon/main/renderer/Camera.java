package com.energyxxer.photon.main.renderer;

import com.energyxxer.photon.geom.Point2D;
import com.energyxxer.photon.geom.Point3D;

import java.awt.Dimension;

/**
 * Created by User on 4/4/2017.
 */
public class Camera {
    private Renderer renderer;

    private double x;
    private double y;
    private double z;

    private double fov = 3000;
    private double depth = 2;

    public Camera(Scene scene) {
        this.renderer = scene.getGame().getRenderer();
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point2D pointToScreen(Point2D p) {
        return pointToScreen(new Point3D(p.x,p.y,0));
    }

    public Point2D pointToScreen(Point3D p) {
        Dimension resolution = renderer.getResolution();
        double unitSize = ((resolution.width) / (fov + (p.z - z) * depth));
        return new Point2D((((p.x - x) - Math.copySign((p.z - z) * depth/8, p.x - x)) * unitSize) + (resolution.width / 2), (resolution.height / 2) - (((p.y - y) - Math.copySign((p.z - z) * depth/8, p.y - y)) * unitSize));
    }
}
