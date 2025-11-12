package demo1;

/**
 * @author pluchon
 * @create 2025-07-11-15:51
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person implements Cloneable{
    public int age;

    public Person(int age) {
        this.age = age;
    }

    High high1 = new High(150.5);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
