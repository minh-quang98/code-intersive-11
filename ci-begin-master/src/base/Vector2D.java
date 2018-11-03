package base;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(float x, float y) {
        Vector2D result = new Vector2D(this.x + x, this.y + y);
        return result;
    }

    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D substract(float x, float y){
        Vector2D result = new Vector2D(this.x - x, this.y - y);
        return result;
    }

    public Vector2D subtractThis(float x,float y) {
        this.x -= x;
        this.y -=y;
        return this;
    }

    public Vector2D scale(float rate) {
        Vector2D result = new Vector2D(this.x * rate, this.y * rate);
        return result;
    }

    public Vector2D scaleThis(float rate) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public Vector2D set(float x,float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D setLenght(float lenght) {
        float currentlenght = this.length();
        this.scaleThis(lenght / currentlenght);
        return this;
    }
}
