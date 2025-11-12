/**
 * @author pluchon
 * @create 2025-06-04-08:02
 * 作者代码水平一般，难免难看，请见谅
 */
public class Student extends  Person{
    String classes;
    int age;

    public Student(String name, String classes, int age) {
        super(name);
        this.classes = classes;
        this.age = age;
    }

    //public void sleep()
    //{
    //    System.out.println(name+classes+"学生在睡觉");
    //}
    @Override
    public Student sleep()
    {
        System.out.println(name+classes+"学生在睡觉");
        return null;
    }

    public Student homework()
    {
        System.out.println(name+classes+"在写作业");
        return null;
    }
}
