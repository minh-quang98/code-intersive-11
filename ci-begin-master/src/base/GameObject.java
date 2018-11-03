package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;

    //phương thức
    public GameObject() {
        this.position = new Vector2D();
    }

    //logic
    public void run() {

    }

    //hiển thị
    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

}
