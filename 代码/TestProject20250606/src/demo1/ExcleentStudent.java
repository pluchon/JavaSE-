package demo1;

/**
 * @author pluchon
 * @create 2025-06-06-18:48
 * 作者代码水平一般，难免难看，请见谅
 */
public class ExcleentStudent implements IExcellent {

    @Override
    public void blackboard() {
        System.out.println("优秀学生在讲课");
    }

    @Override
    public void note() {
        System.out.println("优秀学生在记笔记");
    }
}
