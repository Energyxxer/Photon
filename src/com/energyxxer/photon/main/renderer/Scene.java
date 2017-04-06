package com.energyxxer.photon.main.renderer;

import com.energyxxer.photon.main.PhotonGame;
import com.energyxxer.photon.objects.GameObject;
import com.energyxxer.photon.objects.TestObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by User on 4/4/2017.
 */
public class Scene {
    private PhotonGame game;
    private ArrayList<GameObject> objects = new ArrayList<>();
    private Camera camera;

    public Scene(PhotonGame game) {
        this.game = game;
/*
        GameObject o1 = new OpaqueObject(this, Color.BLUE);
        GameObject o2 = new OpaqueObject(this, Color.BLACK);
        GameObject o3 = new OpaqueObject(this, Color.ORANGE);
        GameObject o4 = new OpaqueObject(this, Color.BLACK);
        GameObject o5 = new OpaqueObject(this, Color.MAGENTA);
        GameObject o6 = new OpaqueObject(this, Color.BLACK);
        GameObject o7 = new OpaqueObject(this, Color.GREEN);
        GameObject o8 = new OpaqueObject(this, Color.BLACK);
        o1.pos = new Point3D(-400, -400, 0);
        o2.pos = new Point3D(-400, -400, 50);
        o3.pos = new Point3D(-400, 400, 0);
        o4.pos = new Point3D(-400, 400, 50);
        o5.pos = new Point3D(400, -400, 0);
        o6.pos = new Point3D(400, -400, 50);
        o7.pos = new Point3D(400, 400, 0);
        o8.pos = new Point3D(400, 400, 50);
        this.objects.add(o1);
        this.objects.add(o2);
        this.objects.add(o3);
        this.objects.add(o4);
        this.objects.add(o5);
        this.objects.add(o6);
        this.objects.add(o7);
        this.objects.add(o8);*/
        this.camera = new Camera(this);
    }

    void render(Graphics2D g, Renderer r) {
        ArrayList<GameObject> currentObjects = new ArrayList<>();
        currentObjects.addAll(objects);

        currentObjects.sort((a,b) -> (int) (b.pos.z - a.pos.z));

        for(GameObject gameObject : currentObjects) {
            gameObject.render(g,r);
        }
    }

    public void onTick() {
        objects.add(new TestObject(this));
        Iterator<GameObject> it = objects.iterator();
        while(it.hasNext()) {
            GameObject gameObject = it.next();
            gameObject.onTick();
            if(!gameObject.isAlive()) it.remove();
        }
    }

    public PhotonGame getGame() {
        return game;
    }

    public Camera getCamera() {
        return camera;
    }
}
