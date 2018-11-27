package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.action.Action;
import base.action.ActionParallel;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter firecounter;
    int hp;
    boolean immune;
    FrameCounter immuneCounter;
    Action action;

    public Enemy() {
        super();
        this.creatRenderer();
        this.position.set(50,50);
        this.velocity.set(0, 3);
        this.firecounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this.position, 28, 28);
        this.hp = 3;
        this.immune = false;
        this.immuneCounter = new FrameCounter(60);
        this.action = this.createAction();
    }

    private Action createAction() {
        Action actionRun = new Action() {
            @Override
            public boolean run(GameObject master) {
                master.velocity.set(1, 0);
                if (master.position.x > Settings.SCREEN_WIDTH * 3/4) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void reset() {
            }
        };
        Action actionFire = new Action() {
            @Override
            public boolean run(GameObject master) {
                Enemy enemy = (Enemy) master;
                enemy.fire();
                return false;
            }

            @Override
            public void reset() {
                firecounter.reset();
            }
        };
        Action actionParallel = new ActionParallel(actionRun, actionFire);
        return actionParallel;
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\0.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\1.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\2.png",
                "E:\\CI 11\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }


    @Override
    public void run() {
        super.run();
//        if (this.position.y > 300) {
//            this.velocity.set(0, 0);
//        }
//        this.fire();
        this.action.run(this);
    }

    private void fire() {
        if (this.firecounter.run()) {
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            this.firecounter.reset();
        }
    }

    public void takeDamage(int damage) {
        if (this.immune) {
            return;
        }
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            this.destroy();
        } else {
            this.immune = true;
            this.immuneCounter.reset();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxcollider() {
        return this.boxCollider;
    }

    @Override
    public void render(Graphics g) {
        if (this.immune) {

            if (this.immuneCounter.run()) {
                this.immune = false;
            }
            if(this.immuneCounter.count % 4 == 0) {
                super.render(g);
            }
        } else {
            super.render(g);
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.velocity.set(0, 3);
        this.immune = false;
        this. immuneCounter.reset();
        this.hp = 3;
    }
}
