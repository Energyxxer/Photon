package com.energyxxer.photon.objects;

import com.energyxxer.photon.geom.Point3D;
import com.energyxxer.photon.main.renderer.Renderable;
import com.energyxxer.photon.main.renderer.Scene;

/**
 * Created by User on 4/3/2017.
 */
public abstract class GameObject implements Renderable {
    protected Scene scene;

    public Point3D pos = new Point3D();
    private boolean alive = true;

    public GameObject(Scene scene) {
        this.scene = scene;
    }

    public void onTick() {}
    protected void delete() {
        this.alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
}
