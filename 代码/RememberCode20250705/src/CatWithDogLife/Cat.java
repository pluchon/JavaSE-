package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-08:14
 * 作者代码水平一般，难免难看，请见谅
 */
public class Cat extends Animal implements IRunable{
    public String coatColors;//毛色
    public String patterns;//花斑
    public String eyeColors;//眼睛颜色

    public Cat(String name,int age,String food,String coatColors, String patterns, String eyeColors) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.coatColors = coatColors;
        this.patterns = patterns;
        this.eyeColors = eyeColors;
    }

    public void kneading(){//猫儿踩奶
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在踩奶呢");
    }

    public void nightVersion(){//猫儿夜视
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在晚上看东西呢");
    }

    public void rightingReflex(){//翻正反射，猫能在下落中调整姿势，用四肢着地
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在落地无伤呢");
    }

    @Override
    void eat() {
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在吃"+food);
    }

    @Override
    void sleep() {
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在睡懒觉");
    }

    @Override
    void voice() {
        System.out.println(coatColors+"的"+patterns+"的"+eyeColors+"的猫儿在喵喵叫");
    }

    @Override
    public void run() {//重写接口方法
        System.out.println("具备了奔跑能力");
    }
}
