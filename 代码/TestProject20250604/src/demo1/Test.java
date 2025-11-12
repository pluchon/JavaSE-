package demo1;

import java.rmi.Naming;

/**
 * @author pluchon
 * @create 2025-06-04-10:44
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {

    public static void boilAndEat()
    {
        Vegetable vegetable = new Vegetable();
        Meat meat = new Meat();
    }

    public static void main1(String[] args) {
        Eat eat = new Meat();
        eat.eat();
        Eat eats = new Vegetable();
        eats.eat();
        Eat eatss = new Fish();
        eatss.eat();
        eatss.boil();
    }

    public static void main2(String[] args) {
        //我们想实现的是遍历字符数组，如果是不同的情况我们就打印不同结果
        Vegetable vegetable = new Vegetable();
        Meat meat = new Meat();
        String[] eats = {"Ve", "Me", "Ve", "Me"};
        for (int i = 0; i < eats.length; i++) {
            String eat = eats[i];
            if (eat.equals("Ve")) {
                vegetable.eat();
            } else {
                meat.eat();
            }
        }
    }

    public static void main(String[] args) {
        Vegetable vegetable = new Vegetable();
        Meat meat = new Meat();
        Eat [] eats = {vegetable,meat,vegetable,meat};
        Eat [] eatss = {new Vegetable(),new Meat(),new Vegetable(),new Meat()};//前提Eat是父类
        for(Eat eat:eats){
            eat.eat();
        }
        System.out.println("=======================");
        for(Eat eat:eatss){
            eat.eat();
        }
    }
}
