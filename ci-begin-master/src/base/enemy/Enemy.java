package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        this.image = SpriteUtils.loadImage("E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png");
        this.position.set(50,50);
    }


    @Override
    public void run() {
//        super.run();
        if (this.position.y < 300){
            this.position.addThis(0,3);
        }
        this.fire();
    }

    int count = 0;
    private void fire() {
        if (count >= 20) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(enemyBullet);
        } else {
            count ++;
        }
    }
}
