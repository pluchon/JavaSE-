/**
 * @author pluchon
 * @create 2025-06-04-08:02
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public Person sleep()
    {
        System.out.println(name+"人正在睡觉");
        return null;
    }
}
