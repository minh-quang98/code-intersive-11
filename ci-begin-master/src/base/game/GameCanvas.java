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
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<EnemyBullet> enemyBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        this.bullets = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.enemyBullets = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for(PlayerBullet bullet : bullets){
            bullet.render(g);
        }
        for(Enemy enemy : enemies){
            enemy.render(g);
        }
        for(EnemyBullet enemyBullet : enemyBullets){
            enemyBullet.render(g);
        }
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
        this.background.run();
        this.player.run();
        for (PlayerBullet bullet : bullets) {
            bullet.run();
        }
        for (Enemy enemy  : enemies) {
            enemy.run();
        }
        for (EnemyBullet enemyBullet : enemyBullets) {
            enemyBullet.run();
        }
    }

    private void renderAll() {
        this.repaint();
    }
}
