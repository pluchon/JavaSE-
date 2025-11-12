package demo4;

/**
 * @author pluchon
 * @create 2025-07-11-22:37
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person implements Cloneable{
    protected int age;
    protected String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    High highs = new High(175.0);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person temp = (Person) super.clone();//在Person类中克隆了的对象传进来
        temp.highs = (High) this.highs.clone();//再强转为克隆的对象
        return temp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
