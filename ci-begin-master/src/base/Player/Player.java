package base.Player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.action.Action;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    Action action;
    BoxCollider boxCollider;
    public Player() {
        super();
        this.creatRenderer();
        this.position.set(200,300);
        this.boxCollider = new BoxCollider(this.position, 32, 48);
        this.action = new ActionFire(3);
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
        this.move();
        this.action.run(this);
        super.run();
    }

    private void move() {
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



    @Override
    public void destroy() {
        super.destroy();
        PlayerExplosion playerExplosion = GameObject.recycle(PlayerExplosion.class);
        playerExplosion.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxcollider() {
        return this.boxCollider;
    }
}
