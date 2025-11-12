/**
 * @author pluchon
 * @create 2025-05-29-08:16
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person {
    public int age;
    public double high;
    public char sex;

    protected int hands = 2;

    static{
        System.out.println("Person类的静态代码块被调用");
    }

    {
        System.out.println("Person类的构造代码块被调用");
    }
    /*public void eat (){
        System.out.println("人正在吃饭");
    }

    public void sleep(){
        System.out.println("人在睡觉");
    }*/

    public Person(int age,double high,char sex){
        this.age = age;
        this.high = high;
        this.sex = sex;
        System.out.println("Person类构造方法被调用");
    }
}
