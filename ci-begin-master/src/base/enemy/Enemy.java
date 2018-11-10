package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    FrameCounter firecounter;
    public Enemy() {
        super();
        this.creatRenderer();
        this.position.set(50,50);
        this.velocity.set(0, 3);
        this.firecounter = new FrameCounter(20);
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\0.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\1.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\2.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }


    @Override
    public void run() {
        super.run();
        if (this.position.y > 300) {
            this.velocity.set(0, 0);
        }
        this.fire();
    }

    private void fire() {
        if (this.firecounter.run()) {
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            this.firecounter.reset();
        }
    }

}
