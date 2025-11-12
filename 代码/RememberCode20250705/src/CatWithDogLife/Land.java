package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-09:09
 * 作者代码水平一般，难免难看，请见谅
 */
public class Land {
    public void sunRise(){
        System.out.println("太阳升起");
    }

    public void rain(){
        System.out.println("天降大雨");
    }

    public void wind(){
        System.out.println("刮起大风");
    }

    public void sunSet(){
        System.out.println("太阳落下");
    }

    public void life(IRunable iRunable){
        if(iRunable instanceof Cat) {
            Animal cat = new Cat("咪咪", 1, "猫粮", "琥珀色", "花斑", "蓝眼睛");
            cat.voice();
        }else if(iRunable instanceof Dog){
            Animal dog = new Dog("旺财", 3, "狗粮", "大", "社牛", "无固定工作","高兴的跳起来");
            dog.voice();
        }
        iRunable.run();
    }
}
