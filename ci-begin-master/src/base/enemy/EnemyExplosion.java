package base.enemy;

import base.GameObject;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion() {
        super();
        this.createAnimation();
    }

    private void createAnimation() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
          "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\0.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\1.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\2.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\3.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\4.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\5.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\6.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\explosion\\7.png"
                );
        this.renderer = new AnimationRenderer(images,3,true);
    }
}
