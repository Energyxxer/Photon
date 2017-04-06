package com.energyxxer.photon.objects;

import com.energyxxer.photon.main.renderer.Graphics2D;
import com.energyxxer.photon.main.renderer.Renderer;
import com.energyxxer.photon.main.renderer.Scene;

import java.awt.Color;

/**
 * Created by User on 4/5/2017.
 */
public class OpaqueObject extends GameObject {
    private Color color;

    public OpaqueObject(Scene scene, Color color) {
        super(scene);
        this.color = color;
    }

    @Override
    public void render(Graphics2D g, Renderer r) {
        g.setColor(color);
        g.fill3DRect(this.pos.x - 100, this.pos.y - 100, this.pos.z, 200, 200);
    }
}
