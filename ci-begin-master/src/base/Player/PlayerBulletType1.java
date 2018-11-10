package base.Player;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType1 extends PlayerBullet{
    public PlayerBulletType1() {
        super();
        this.creatRenderer();
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }
}
