package base.enemy;

import base.GameObject;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
        this.renderer = new SIngleImagaeRenderer(image);
    }

    @Override
    public void run() {
        super.run();
        this.position.addThis(0,5);
    }
}
