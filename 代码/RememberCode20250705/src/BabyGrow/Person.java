package BabyGrow;

/**
 * @author pluchon
 * @create 2025-07-06-09:49
 * 作者代码水平一般，难免难看，请见谅
 */

//名字叫萌天天，成长之路
public abstract class Person {
    protected String name;
    protected double weight;//以斤为准
    protected double high;//以厘米为计量单位
    protected int age;

    public Person(double weight, String name, double high,int age) {
        this.weight = weight;
        this.name = name;
        this.high = high;
        this.age = age;
    }

    abstract void eat();

    abstract void sleep();

    void breathe(){
        System.out.println(name+"正在吸气");
    }

    void blink(){//眨眼睛
        System.out.println(name+"眨眼睛");
    }

    abstract void cry();

    abstract void makeVocie();

    abstract void sport();

    abstract void game();
}
