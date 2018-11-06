package base.Player;

import base.GameObject;
import base.renderer.AnimationRenderer;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
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

    @Override
    public void run() {
        this.position.subtractThis(0, 5);
        if (this.position.y < -20) {
            this.destroy();
        }
    }
}
