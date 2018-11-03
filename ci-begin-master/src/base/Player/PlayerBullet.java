package base.Player;

import base.GameObject;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
        this.renderer = new SIngleImagaeRenderer(image);
    }

    @Override
    public void run() {
        this.position.subtractThis(0, 3);
    }
}
