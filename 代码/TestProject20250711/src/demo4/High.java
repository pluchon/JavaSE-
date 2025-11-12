package demo4;

/**
 * @author pluchon
 * @create 2025-07-11-22:53
 * 作者代码水平一般，难免难看，请见谅
 */
public class High implements Cloneable{
    protected double high;

    public High(double high) {
        this.high = high;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
