package com.energyxxer.photon.main.renderer;

import com.energyxxer.photon.main.PhotonGame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 3/24/2017.
 */
public class Renderer extends JPanel {
    private PhotonGame game;

    private final Dimension resolution = new Dimension(500, 500);

    private Timer timer;

    public Renderer(PhotonGame game) {
        this.game = game;

        this.setPreferredSize(resolution);

        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                repaint();
            }
        },0, 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        Graphics2D g2d = new Graphics2D((java.awt.Graphics2D) g, this);

        if(game.activeScene != null) {
            game.activeScene.render(g2d, this);
        }
    }

    public Dimension getResolution() {
        return resolution;
    }

    public PhotonGame getGame() {
        return game;
    }
}
