package base.Player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.Vector2D;
import base.action.Action;

public class ActionFire implements Action {
    FrameCounter firecounter;
    int bulletCount;
    public ActionFire(int bulletCount) {
        this.firecounter = new FrameCounter(20);
        this.bulletCount = bulletCount;
    }
    @Override
    public boolean run(GameObject master) {
        if (this.firecounter.run() && KeyEventPress.isFirePress) {
            this.fire(master);
        }
        return false;
    }

    private void fire(GameObject master) {
        for (int i = 0; i < this.bulletCount; i++) {
            Vector2D velocity = calculateVelocity(i, this.bulletCount);
            PlayerBullet bullet = GameObject.recycle(PlayerBulletType1.class);
            bullet.position.set(master.position);
            bullet.velocity.set(velocity);
        }

        this.firecounter.reset();
    }

    private Vector2D calculateVelocity(int i, int bulletCount) {
        int velocityLenght = 5;
        double startAngle = 3 * Math.PI / 4;
        double step = Math.PI / 2 / (bulletCount - 1);
        if (bulletCount == 1) {
            return new Vector2D(0,-velocityLenght);
        }
        Vector2D velocity = new Vector2D(0, -velocityLenght);
        velocity.setAngle(startAngle + step * i);
        return velocity;
    }

    @Override
    public void reset() {
        this.firecounter.reset();
    }
}
