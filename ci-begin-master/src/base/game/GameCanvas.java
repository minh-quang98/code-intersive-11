package base.game;

import base.Background;
import base.GameObject;
import base.Player.Player;
import base.Player.PlayerBullet;
import base.enemy.Enemy;
import base.enemy.EnemyBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    public GameObject background;
    public GameObject player;

    public GameCanvas() {
        this.background = GameObject.recycle(Background.class); // new Background
        this.player = GameObject.recycle(Player.class);
        Enemy enemy = GameObject.recycle(Enemy.class);
    }

    public void gameLoop() {
        int delay = 1000 / 60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
            this.runAll();
            this.renderAll();
            lastRun = currentTime;
            }
        }
    }

    private void runAll() {
//        for(GameObject gameObject : GameObject.gameObjects) {
        for (int i = 0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }
        System.out.println(GameObject.gameObjects.size());
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (GameObject gameObject : GameObject.gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    private void renderAll() {
        this.repaint();
    }
}
