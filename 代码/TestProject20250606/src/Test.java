/**
 * @author pluchon
 * @create 2025-06-06-15:29
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {

    public static void func(Person person){
        person.sleep();
    }

    public static void main(String[] args) {
        Person per1 = new Student("张三","计科二班","大一");
        Person per2 = new Teacher("王五","教务处","计算机科学与技术");
        Person per3 = new Student("张三","计科二班","大一");
        func(per1);
        func(per2);

        System.out.println(per1.hashCode());
        System.out.println(per3.hashCode());
    }
}