package base.Player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Settings;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    public Player() {
        super();
        this.image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        this.position.set(200,300);
    }

    @Override
    public void run() {
        if (KeyEventPress.isUpPress) {
            if (this.position.y > 0) {
                this.position.subtractThis(0, 5);
            }
        }
        if (KeyEventPress.isDownPress) {
            if (this.position.y < Settings.SCREEN_HEIGHT - this.image.getHeight() * 2) {
                this.position.addThis(0,5);
            }
        }
        if (KeyEventPress.isLeftPress) {
            if (this.position.x > 0) {
                this.position.subtractThis(5, 0);
            }
        }
        if (KeyEventPress.isRightPress) {
            if (this.position.x < Settings.SCREEN_WIDTH - 416 - this.image.getWidth()) {
                this.position.addThis(5, 0);
            }
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
