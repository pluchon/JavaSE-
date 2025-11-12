package demo3;

/**
 * @author pluchon
 * @create 2025-06-04-12:10
 * 作者代码水平一般，难免难看，请见谅
 */
public class Two extends One{
    private int n = 1;

    @Override
    public void func(){
        System.out.println("Two中的func方法"+"且n的值是："+n);
    }
}
