package demo1;

/**
 * @author pluchon
 * @create 2025-06-06-16:58
 * 作者代码水平一般，难免难看，请见谅
 */
public class Student implements IPerson,INoteable{

    @Override
    public void Attendclass() {
        System.out.println("学生在上课");
    }

    @Override
    public void Classisover() {
        System.out.println("学生下课离开了");
    }

    public void note(){
        System.out.println("记笔记");
    }
}
