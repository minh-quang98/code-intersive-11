package base.Player;

import base.GameObject;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        super();
        this.image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
    }

    @Override
    public void run() {
        this.position.subtractThis(0, 3);
    }
}
