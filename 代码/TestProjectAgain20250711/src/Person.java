/**
 * @author pluchon
 * @create 2025-07-11-17:22
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
