package demo1;

/**
 * @author pluchon
 * @create 2025-07-11-16:08
 * 作者代码水平一般，难免难看，请见谅
 */
public class High implements Comparable {
    public double high;

    public High(double high) {
        this.high = high;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
