package base;

import base.Player.Player;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Player createPlayer() {
        Player player = new Player();
        gameObjects.add(player);
        return player;
    }

    //createGameObject generic
    public static <E extends GameObject> E create(Class<E> clazz) {
        try {
            E gameObject = clazz.newInstance();// = new E()
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E recycle(Class<E> clazz) {
        for (GameObject gameObject : gameObjects) {
            if(isValidRecycle(gameObject, clazz)) {
                gameObject.reset();
                return (E)gameObject;
            }
        }
        E newGameOfject = create(clazz);
        return newGameOfject;
    }

    private static boolean isValidRecycle(GameObject gameObject, Class clazz) {
        //TODO
        // isActive == false
        //gameObject ~ instance of clazz
        return !gameObject.isActive
                && gameObject.getClass().isAssignableFrom(clazz);
    }

    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;
    public Vector2D velocity;

    //phương thức
    public GameObject() {
        this.position = new Vector2D();
        this.isActive = true;
        this.velocity = new Vector2D();
    }

    public void destroy() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
    }

    //logic
    public void run() {
        this.position.addThis(velocity);
    }

    //hiển thị
    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

}
