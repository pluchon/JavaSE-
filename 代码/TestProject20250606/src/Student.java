/**
 * @author pluchon
 * @create 2025-06-06-14:38
 * 作者代码水平一般，难免难看，请见谅
 */
public class Student extends Person{
    String classes;
    String stage;

    public Student(String name, String classes,String stage) {
        super(name);
        this.classes = classes;
        this.stage = stage;
    }

    @Override
    void sleep() {
        System.out.println(name+classes+"学生在睡觉");
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;//如果你传的是空对象直接返回
        }
        if(this == obj){//如果你传的另外个对象是你本身的话
            return true;
        }
        if(!(obj instanceof Person)){//实例化的不是同个类
            return false;
        }
        //此时的情况就是同一个类的情况了，只需要比较内容是否一致就好
        Person temp = (Person) obj;//为什么此时向下转型安全，因为之前已经检查过了
        return temp.name.equals(this.name);
    }
}