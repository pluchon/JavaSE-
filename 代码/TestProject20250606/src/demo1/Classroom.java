package demo1;

/**
 * @author pluchon
 * @create 2025-06-06-17:00
 * 作者代码水平一般，难免难看，请见谅
 */
public class Classroom {//这个大类把两个子类集中起来
    void openDoor(){
        System.out.println("打开教室门");
    }

    void closeDoor(){
        System.out.println("关机教室门");
    }

    void learn(IPerson person){//协作方法
        person.Attendclass();
        if(person instanceof Student){
            Student stu = (Student) person;
            stu.note();
        }else if(person instanceof Teacher){
            Teacher ter = (Teacher) person;
            ter.blackboard();
        }
        person.Classisover();
    }
}
