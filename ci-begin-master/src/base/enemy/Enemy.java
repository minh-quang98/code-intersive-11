package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import base.renderer.AnimationRenderer;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy() {
        super();
//        BufferedImage image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png");
//        this.renderer = new SIngleImagaeRenderer(image);
        this.creatRenderer();
        this.position.set(50,50);
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\1.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\2.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\3.png"));
        this.renderer = new AnimationRenderer(images);
    }


    @Override
    public void run() {
//        super.run();
        if (this.position.y < 300){
            this.position.addThis(1,1);
        }
        this.fire();
    }

    int count = 0;
    private void fire() {
        if (count >= 20) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(enemyBullet);
        } else {
            count ++;
        }
    }
}
