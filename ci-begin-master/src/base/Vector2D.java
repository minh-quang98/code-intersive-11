package base;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
       this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(float x, float y) {
        Vector2D result = new Vector2D(this.x + x, this.y + y);
        return result;
    }

    public Vector2D add(Vector2D other){
        return this.add(other.x, other.y);
    }

    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addThis(Vector2D other){
        return this.addThis(other.x, other.y);
    }

    public Vector2D substract(float x, float y){
        Vector2D result = new Vector2D(this.x - x, this.y - y);
        return result;
    }

    public Vector2D substract(Vector2D other){
        return this.substract(other.x,other.y);
    }

    public Vector2D subtractThis(float x,float y) {
        this.x -= x;
        this.y -=y;
        return this;
    }

    public Vector2D subtractThis(Vector2D other){
        return this.subtractThis(other.x, other.y);
    }

    public Vector2D scale(float rate) {
        Vector2D result = new Vector2D(this.x * rate, this.y * rate);
        return result;
    }

    public Vector2D scaleThis(float rate) {
        this.x *= rate;
        this.y *= rate;
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

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D setLength(float length) {
        float currentlength = this.length();
        this.scaleThis(length / currentlength);
        return this;
    }

    public Vector2D setAngle(double angle) {
        double lenght = this.length();
        this.x = (float)(lenght * Math.sin(angle));
        this.y = (float)(lenght * Math.cos(angle));
        return this;
    }

    public double getAngle() {
        return Math.atan(this.y / this.x);
    }

    public static void main(String[] args) {
        Vector2D test = new Vector2D(0,1);
        test.setAngle(Math.PI);
        Vector2D test2 = new Vector2D(0,-1);
        System.out.println(test.getAngle());
        System.out.println(test2.getAngle());


    }
}

