/**
 * @author pluchon
 * @create 2025-06-06-14:38
 * 作者代码水平一般，难免难看，请见谅
 */
public abstract class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    abstract void sleep();
}