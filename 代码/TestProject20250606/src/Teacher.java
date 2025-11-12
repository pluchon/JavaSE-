/**
 * @author pluchon
 * @create 2025-06-06-14:38
 * 作者代码水平一般，难免难看，请见谅
 */
public class Teacher extends Person{
    String department;
    String subject;

    public Teacher(String name,String department, String subject) {
        super(name);
        this.department = department;
        this.subject = subject;
    }

    @Override
    void sleep() {
        System.out.println(name+department+"老师在睡觉");
    }
}