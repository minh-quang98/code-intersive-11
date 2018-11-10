package base.Player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter firecounter;
    public Player() {
        super();
        this.creatRenderer();
        this.position.set(200,300);
        this.firecounter = new FrameCounter(20);
    }

    private void creatRenderer() {
        //ArrayList<BufferedImage> image
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\0.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\1.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\2.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\3.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\4.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\5.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\6.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        if (this.firecounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
    }

    private void move() {
        //TODO upgrade
        int vx = 0;
        int vy = 0;
        if (KeyEventPress.isUpPress) {
            if (this.position.y > 0) {
                vy -= 5;
            }
        }
        if (KeyEventPress.isDownPress) {
//            if (this.position.y < Settings.SCREEN_HEIGHT - this.image.getHeight() * 2) {
                vy += 5;
//            }
        }
        if (KeyEventPress.isLeftPress) {
            if (this.position.x > 0) {
                vx -= 5;
            }
        }
        if (KeyEventPress.isRightPress) {
//            if (this.position.x < Settings.SCREEN_WIDTH - 416 - this.image.getWidth()) {
                vx += 5;
//            }
        }
        this.velocity.set(vx, vy);

    }

    private void fire() {
            PlayerBullet bullet = GameObject.recycle(PlayerBulletType1.class);
            bullet.position.set(this.position);

            PlayerBulletType2 bullet2 = GameObject.recycle(PlayerBulletType2.class);
            bullet2.position.set(this.position.add(-25, 0));
            bullet2.velocity.set(-5, -5);

            PlayerBulletType2 bullet3 = GameObject.recycle(PlayerBulletType2.class);
            bullet3.position.set(this.position.add(25,0));
            this.firecounter.reset();
            bullet3.velocity.set(5, -5);
    }
}
