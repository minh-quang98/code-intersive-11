import java.util.Date;

public class student {
    //attribute = thuộc tính
    String name;
    Date birthdate;
    String code;
    //methods = phương thức
    //1.construct = hàm tạo
    public student() {
        this.name = "Nguyễn Văn A";
        this.birthdate = new Date();
        this.code = "sel123";
    }
    //2. others methods
    public void print() {
        System.out.println(this.name);
        System.out.println(this.birthdate);
        System.out.println(this.code);
    }
}
