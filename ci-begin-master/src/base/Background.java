package base;

import base.game.Settings;
import base.renderer.SIngleImagaeRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\background\\0.png");
        this.renderer = new SIngleImagaeRenderer(image);
        this.position.set(0, Settings.SCREEN_HEIGHT - image.getHeight());
    }

    @Override
    public void run() {
        if (this.position.y <= 0) {
            this.position.addThis(0, 10);
        }
    }
}
