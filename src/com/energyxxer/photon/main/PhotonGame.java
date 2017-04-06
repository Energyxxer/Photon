package com.energyxxer.photon.main;

import com.energyxxer.photon.main.renderer.Renderer;
import com.energyxxer.photon.main.renderer.Scene;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 3/24/2017.
 */
public class PhotonGame {
    private final Renderer renderer;
    public Scene activeScene;
    private Timer timer;

    public PhotonGame() {
        this.renderer = new Renderer(this);
        this.activeScene = new Scene(this);

        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                if(activeScene != null) activeScene.onTick();
            }
        },0, 20);
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
