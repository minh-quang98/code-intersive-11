package base.Player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public Player() {
        super();
//        BufferedImage image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
//        this.renderer = new SIngleImagaeRenderer(image);
        this.creatRenderer();
        this.position.set(200,300);
    }

    private void creatRenderer() {
        //ArrayList<BufferedImage> image
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\0.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\1.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\2.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\3.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\4.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\5.png"));
        images.add(SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\6.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if (KeyEventPress.isUpPress) {
            if (this.position.y > 0) {
                this.position.subtractThis(0, 5);
            }
        }
        if (KeyEventPress.isDownPress) {
//            if (this.position.y < Settings.SCREEN_HEIGHT - this.image.getHeight() * 2) {
                this.position.addThis(0,5);
//            }
        }
        if (KeyEventPress.isLeftPress) {
            if (this.position.x > 0) {
                this.position.subtractThis(5, 0);
            }
        }
        if (KeyEventPress.isRightPress) {
//            if (this.position.x < Settings.SCREEN_WIDTH - 416 - this.image.getWidth()) {
                this.position.addThis(5, 0);
//            }
        }
        if (KeyEventPress.isFirePress) {
            this.fire();
        }
    }

    int count = 0;
    private void fire() {
        if (count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);

            GameCanvas.bullets.add(bullet);
            count = 0;
        } else {
            count++;
        }
    }
}
