package base.Player;

import base.GameObject;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerExplosion extends GameObject {
    public PlayerExplosion() {
        super();
        this.createAnimation();
    }

    private void createAnimation() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\0.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\1.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\2.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\3.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\4.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\5.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\6.png",
                "C:\\Users\\User\\Desktop\\CI 11\\ci-begin-master\\assets\\images\\players\\explosions\\7.png"
        );
        this.renderer = new AnimationRenderer(images,5,true);
    }
}
