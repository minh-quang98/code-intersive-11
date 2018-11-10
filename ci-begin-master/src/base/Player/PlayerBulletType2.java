package base.Player;

import base.GameObject;
import base.Vector2D;
import base.enemy.Enemy;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType2 extends PlayerBullet {
    public PlayerBulletType2() {
        super();
        this.creatRenderer();
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\cyan.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\green.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\pink.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\red.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\white.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\bullets\\yellow.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.moveToEnemy();

    }

    private void moveToEnemy() {
        Enemy enemy = null;
        for (GameObject gameObject: GameObject.gameObjects) {
            if (gameObject.isActive && gameObject instanceof  Enemy) {
                enemy = (Enemy) gameObject;
                break;
            }
        }
        if (enemy != null) {
            Vector2D enemyPosition = enemy.position;
            Vector2D result = enemyPosition.substract(this.position);
            result.addThis(this.velocity);
            result.setLength(5);
            this.velocity.set(result);
        }
    }
}
