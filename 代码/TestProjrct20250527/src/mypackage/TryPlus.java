package mypackage;

/**
 * @author pluchon
 * @create 2025-05-27-08:54
 * 作者代码水平一般，难免难看，请见谅
 */
public class TryPlus {
    String name = "zlh";
    public int a = 10;
    private int age = 19;
    static double high = 180.0;

    {
        System.out.println("这是构造代码块");
        a = 100;
    }

    static{
        System.out.println("这是静态代码块一号");
    }

    static{
        System.out.println("这是静态代码块二号");
    }
    //public void setAge(int age){
    //    this.age =age;
    //}
    //public void getAge (){
    //    System.out.println(age);
    //}

    public void func1(){
        System.out.println("这是非静态方法");
    }

    static{
        System.out.println("这是静态方法");
    }


}
