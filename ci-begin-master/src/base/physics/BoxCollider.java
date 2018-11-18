package base.physics;

import base.Rectangle;
import base.Vector2D;

public class BoxCollider {
    public Vector2D masterPosition; //master == GameObject chủ
    public int width;
    public int height;

    public BoxCollider(Vector2D masterPosition, int width, int height) {
        this.masterPosition = masterPosition;
        this.width = width;
        this.height = height;
    }

    public int top() {
        return (int)this.masterPosition.y;
    }

    public int botton() {
        return (this.top() + this.height);
    }

    public int left() {
        return (int)this.masterPosition.x;
    }

    public int right() {
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other) {
//
        boolean intersecX = this.left() <= other.right()
                && other.left() <= this.right();
        boolean intersecY = this.top() <= other.botton()
                && other.top() <= this.botton();
        return intersecX && intersecY;
    }
}
