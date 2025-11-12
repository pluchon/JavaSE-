package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-08:13
 * 作者代码水平一般，难免难看，请见谅
 */
public abstract class Animal {
    public String name;
    public int age;
    public String food;

    abstract void eat();
    abstract void sleep();
    abstract void voice();
}
