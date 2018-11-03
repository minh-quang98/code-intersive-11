package base.renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SIngleImagaeRenderer extends Renderer{
    BufferedImage image;

    public SIngleImagaeRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image, (int)master.position.x, (int)master.position.y, null);
    }
}
