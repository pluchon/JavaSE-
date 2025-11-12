package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-08:15
 * 作者代码水平一般，难免难看，请见谅
 */
public class Dog extends Animal implements IRunable{
    public String bodySize;//体型
    public String socialBehaviors;//狗的社交能力强还是弱
    public String work;//工作内容
    public String emotion;//心情

    public Dog(String name,int age,String food,String bodySize, String socialBehaviors, String work,String emotion) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.bodySize = bodySize;
        this.socialBehaviors = socialBehaviors;
        this.work = work;
        this.emotion = emotion;
    }

    public void tailBehaviors(){//尾巴行为
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗在摇尾巴");
    }

    public void emotionalDisplay(){//情感表达
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗在"+emotion);
    }

    public void sensorySuperpowers(){//感官特异
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗感知到了危险");
    }

    @Override
    void eat() {
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗在吃"+food);
    }

    @Override
    void sleep() {
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗在睡觉");
    }

    @Override
    void voice() {
        System.out.println(bodySize+"的"+socialBehaviors+"从事"+work+"工作的狗在汪汪叫");
    }

    @Override
    public void run() {//重写接口的方法
        System.out.println("具备了奔跑能力");
    }
}
