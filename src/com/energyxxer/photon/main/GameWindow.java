package com.energyxxer.photon.main;

import com.energyxxer.photon.geom.Line2D;
import com.energyxxer.photon.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * Created by User on 3/24/2017.
 */
public class GameWindow extends JFrame {
    public static GameWindow instance;

    public final PhotonGame game;

    private GameWindow() {
        super("Photon DEV");
        this.game = new PhotonGame();
        this.setContentPane(game.getRenderer());
        this.setSize(new Dimension(500, 500));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);

        Line2D a = new Line2D(-1,-1,1,1);
        Line2D b = new Line2D(-1, 1,1,-1);

        Point2D intersection = a.getIntersection(b);

        System.out.println(intersection);
        System.out.println(intersection.toAwt());
    }

    public static void main(String[] args) {
        instance = new GameWindow();
    }
}
