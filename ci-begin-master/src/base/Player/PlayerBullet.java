package base.Player;

import base.GameObject;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        super();
        this.velocity.set(0, -5);
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
