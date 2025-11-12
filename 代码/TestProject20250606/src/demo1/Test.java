package demo1;

/**
 * @author pluchon
 * @create 2025-06-06-16:50
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void noting(INoteable noteable){
        noteable.note();
    }

    public static void blackborading(IBlackboardable blackboardable){
        blackboardable.blackboard();
    }

    public static void excleenting(IExcellent iexcellent){
        iexcellent.blackboard();
        iexcellent.note();
    }

    public static void main(String[] args) {//究极大招
        Student stu = new Student();
        Teacher ter = new Teacher();
        ExcleentStudent stus = new ExcleentStudent();
        noting(stu);
        blackborading(ter);
        excleenting(stus);
    }

    public static void main1(String[] args) {
        Classroom classroom = new Classroom();
        Student stu = new Student();
        Teacher ter = new Teacher();
        classroom.openDoor();
        classroom.learn(stu);
        classroom.learn(ter);
        classroom.closeDoor();
    }
}
