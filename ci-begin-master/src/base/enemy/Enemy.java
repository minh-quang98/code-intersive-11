package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        this.image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png");
        Enemy enemy = new Enemy();
        enemy.position.set(0,0);
        GameCanvas.enemies.add(enemy);
    }

    int count = 0;
    @Override
    public void run() {
        if (count > 30) {
            Enemy enemy = new Enemy();
            enemy.position.set(0,0);

            GameCanvas.enemies.add(enemy);
            count = 0;
        } else {
            count ++;
        }
    }
}
