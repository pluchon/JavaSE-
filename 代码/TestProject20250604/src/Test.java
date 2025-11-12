import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-06-04-08:06
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void func(Person person){
        person.sleep();
    }

    public static Person funcs(int num){
        if(num == 10){
            return new Teacher("李四","教务处",35);
        }else{
            return new Student("张三", "计科2班", 19);
        }
    }

    public static void main1(String[] args) {
        Person pr1 = new Student("张三","计科2班",19);
         Person pr2 = new Teacher("李四","教务处",35);
         pr1.sleep();
        pr2.sleep();
    }

    public static void main2(String[] args) {
        Student pr1 = new Student("张三","计科2班",19);
        Teacher pr2 = new Teacher("李四","教务处",35);
        func(pr1);
        func(pr2);
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Person person = funcs(input);
        person.sleep();
    }

    public static void main(String[] args) {
        Person person = new Student("张三","计科2班",19);
        Student student = (Student) person;
        student.homework();
    }
}
