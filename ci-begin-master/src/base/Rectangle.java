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

    public boolean intersects(Rectangle other) {

        return true;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(0, 0), 10 ,10);
        Rectangle rect2 = new Rectangle(new Vector2D(5, 5), 10, 10);
        Rectangle rect3 = new Rectangle(new Vector2D(5, -15),10,10);

        rect1.intersects(rect2); // true
        rect2.intersects(rect3); //false
        rect1.intersects(rect3); //false
    }
}
