package com.energyxxer.photon.objects;

import com.energyxxer.photon.geom.Point2D;
import com.energyxxer.photon.geom.Vector3D;
import com.energyxxer.photon.main.renderer.Graphics2D;
import com.energyxxer.photon.main.renderer.Renderer;
import com.energyxxer.photon.main.renderer.Scene;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

/**
 * Created by User on 4/4/2017.
 */
public class TestObject extends PhysicsObject {

    private double size;

    public TestObject(Scene scene) {
        super(scene);
        Random random = new Random();
        this.motion = new Vector3D(random.nextInt(81)-40, random.nextInt(40), random.nextInt(161)-80);
        this.size = random.nextInt(76) + 25;
    }

    @Override
    public void onTick() {
        super.onTick();
        Point2D p = this.scene.getCamera().pointToScreen(this.pos);
        Dimension resolution = this.scene.getGame().getRenderer().getResolution();
        if(p.x < 0 || p.y < 0 || p.x > resolution.width || p.y > resolution.height) this.delete();
    }

    @Override
    public void render(Graphics2D g, Renderer r) {
        /*int brightness = (int) (255 * (pos.z/1000));
        brightness = Math.min(Math.max(brightness,0), 255);
        g.setColor(new Color(brightness, brightness, brightness));*/
        g.setColor(Color.WHITE);
        g.fill3DOval(pos.x - (size/2), pos.y - (size/2), pos.z, size, size);
    }
}
