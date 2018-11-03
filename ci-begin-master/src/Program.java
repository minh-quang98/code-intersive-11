import base.game.GameCanvas;
import base.game.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    //sum()
    //access modifier public/protected/default/private
    public static double sum(double a, double b) {
        return a + b;
    }
    public static void main(String[] args) {
//        int x = 0;
//        double d = 1.0d;
//        float f = 2.0f;
//        boolean b = true//fale;
//        //...
//        string s = "hello world";

//        double result = sum(1, 2);
//        if(result > 3) {
//            System.out.println("Big number");
//        } else {
//            System.out.println("Small number");
//        }
//        int number = 1;
//        switch (number) {
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            default:
//                System.out.println("Unknow number");
//        }

//        student student1 = new student();
//        student student2 = new student();
//        student1.print(); // this = student 1
//
//        student2.name = "Nguyễn Thị B";
//        student2.code = "sb1111221";
//        student2.print(); // this = student 2

        GameWindow window = new GameWindow();

        GameCanvas canvas = new GameCanvas();
        window.add(canvas);
        window.setVisible(true);
        canvas.gameLoop();
    }
}
