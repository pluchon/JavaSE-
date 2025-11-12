package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-08:15
 * 作者代码水平一般，难免难看，请见谅
 */
public class Fish extends Animal implements ISwimable{
    public String dynamicColorChange;//鱼儿是否能动态变色
    public String light;//鱼儿是否能发光
    public String camouflage;//鱼儿伪装程度是否高

    public Fish(String name,int age,String food,String dynamicColorChange, String light, String camouflage) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.dynamicColorChange = dynamicColorChange;
        this.light = light;
        this.camouflage = camouflage;
    }

    void breath(){
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼用腮呼吸");
    }

    void reproductionStrategies(){//繁殖行为
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼体外受精");
    }

    void collectiveBehaviors(){//群体行为
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼在集体行动");
    }

    @Override
    void eat() {
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼吃"+food);
    }

    @Override
    void sleep() {
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼在睡觉");
    }

    @Override
    void voice() {
        System.out.println(dynamicColorChange+"的"+light+"的"+camouflage+"的鱼在吐泡泡");
    }

    @Override
    public void swim() {
        System.out.println("具备了游泳能力");
    }
}
