/**
 * @author pluchon
 * @create 2025-06-04-08:03
 * 作者代码水平一般，难免难看，请见谅
 */
public class Teacher extends Person {
    String department;
    int age;

    public Teacher(String name,String department, int age) {
        super(name);
        this.department = department;
        this.age = age;
    }

    public Teacher sleep()
    {
        System.out.println(name+department+"老师在睡觉");
        return null;
    }

    public Teacher teach()
    {
        System.out.println(name+department+"在教书");
        return null;
    }
}
