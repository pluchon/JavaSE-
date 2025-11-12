/**
 * @author pluchon
 * @create 2025-05-29-08:01
 * 作者代码水平一般，难免难看，请见谅
 */
public class Try {
    public static void main(String[] args) {
        Student stu = new Student("北京大学","Java数据结构",2,'男');
        System.out.println("============================");
        Student stus = new Student("浙江大学","Java微服务",3,'男');
        System.out.println("--------------------------------");
        System.out.println("学生类的钱："+stu.money);
        System.out.println("父类的手："+stu.hands);
        System.out.println("---------------------------------");
        final int a = 100;
        //stu.eat("北京大学");
        //stu.eat();
        //System.out.println("===============");
        //System.out.println(stu.colleague);
        //System.out.println(stu.high);
        //System.out.println(stu.money);
        //stu.sleep();
    }
}
