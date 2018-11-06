package base.Player;

import base.FrameCounter;
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

    private void fire() {
        if (this.firecounter.run()) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position);
            this.firecounter.reset();
        }
    }
}
