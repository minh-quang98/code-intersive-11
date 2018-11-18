package base;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle() {
        this(new Vector2D(), 5, 5);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public int top() {
        return (int)this.position.y;
    }

    public int botton() {
        return (this.top() + this.height);
    }

    public int left() {
        return (int)this.position.x;
    }

    public int right() {
        return this.left() + this.width;
    }

    public boolean intersects(Rectangle other) {
//        boolean intersecX = (other.top() >= this.top() && other.top() <= this.botton()
//        || other.botton() >= this.top() && other.botton() <= this.botton());
//        boolean intersecY = (other.left() >= this.left() && other.left() <= this.right()
//        || other.right() >= this.left() && other.right() <= this.right());
        boolean intersecX = this.left() <= other.right()
                && other.left() <= this.right();
        boolean intersecY = this.top() <= other.botton()
                && other.top() <= this.botton();
        return intersecX && intersecY;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(0, 0), 10 ,10);
        Rectangle rect2 = new Rectangle(new Vector2D(5, 5), 10, 10);
        Rectangle rect3 = new Rectangle(new Vector2D(5, -15),10,10);

        System.out.println(rect1.intersects(rect2));
        System.out.println(rect2.intersects(rect3));
        System.out.println(rect1.intersects(rect3));
    }
}
