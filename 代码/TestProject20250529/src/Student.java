/**
 * @author pluchon
 * @create 2025-05-29-08:15
 * 作者代码水平一般，难免难看，请见谅
 */
public class Student extends Person{
   public String colleague;//学校...
   public String subject;//主修学科...
   public int stage;//大一、大二...
   public char sex;

   protected int money = 200;

   static{
       System.out.println("Student类的静态代码块被调用");
   }

    {
        System.out.println("Student类的构造代码块被调用");
    }
    /*@Override
    public String toString() {
        return "Student{" +
                "colleague='" + colleague + '\'' +
                ", subject='" + subject + '\'' +
                ", stage=" + stage +
                ", sex=" + super.sex +
                '}';
    }*/

    /*public void eat(String colleague){
        System.out.println(colleague+"的大学生正在吃饭");
    }

    public void sleep(){
        super.sleep();
        System.out.println("大学生在睡觉");
    }*/

    public Student(String colleague,String subject,int stage,char sex){
        super(18,180.5,'男');
        this.colleague = colleague;
        this.subject = subject;
        this.stage = stage;
        this.sex = sex;
        System.out.println("Student类构造方法被调用");
    }

    /*@Override
    public String toString() {
        return "Student{" +
                "colleague='" + colleague + '\'' +
                ", subject='" + subject + '\'' +
                ", stage=" + stage +
                ", sex=" + sex +
                ", age=" + age +
                ", high=" + high +
                ", sex=" + super.sex +
                '}';
    }*/
}
