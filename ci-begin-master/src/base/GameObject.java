package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public BufferedImage image;
    public Vector2D position;

    //phương thức
    public GameObject() {
        this.position = new Vector2D();
    }

    //logic
    public void run() {

    }

    //hiển thị
    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);

    }

}
