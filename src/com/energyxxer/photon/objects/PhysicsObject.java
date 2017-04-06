package com.energyxxer.photon.objects;

import com.energyxxer.photon.geom.Vector3D;
import com.energyxxer.photon.main.renderer.Scene;

/**
 * Created by User on 4/4/2017.
 */
public abstract class PhysicsObject extends GameObject {

    public static final Vector3D GRAVITY = new Vector3D(0, -0.981, 0);
    public static final double AIR_RESISTANCE = 0.1875;

    protected Vector3D motion = new Vector3D(0, 0, 0);

    public PhysicsObject(Scene scene) {
        super(scene);
    }

    @Override
    public void onTick() {
        this.pos.apply(motion);
        motion.applyResistance(AIR_RESISTANCE);
        motion.apply(GRAVITY);
    }
}
