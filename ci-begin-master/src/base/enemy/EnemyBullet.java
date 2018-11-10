package base.enemy;

import base.GameObject;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, 5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeed();
    }
    private void destroyIfNeed() {
        if (this.position.y < -20 || this.position.y >= Settings.SCREEN_HEIGHT
                || this.position.x < 0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
