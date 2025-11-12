package demo1;

/**
 * @author pluchon
 * @create 2025-06-06-16:58
 * 作者代码水平一般，难免难看，请见谅
 */
public class Teacher implements IPerson,IBlackboardable{
    @Override
    public void Attendclass() {
        System.out.println("老师在上课");
    }

    @Override
    public void Classisover() {
        System.out.println("老师下课离开了");
    }

    public void blackboard(){
        System.out.println("粉笔写字");
    }
}
