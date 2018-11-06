package base.renderer;

import base.FrameCounter;
import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    FrameCounter nextImageCounter;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCounter = new FrameCounter(10);
    }

    public void render (Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentImageIndex),
                (int)master.position.x, (int)master.position.y, null);

        if (this.nextImageCounter.run()) {
            this.currentImageIndex++;
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }
    }
}
