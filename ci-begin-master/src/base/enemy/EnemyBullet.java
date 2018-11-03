package base.enemy;

import base.GameObject;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        this.image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addThis(0,5);
    }
}
