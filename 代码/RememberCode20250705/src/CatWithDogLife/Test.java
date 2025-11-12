package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-08:40
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main(String[] args) {
        Land land = new Land();
        Dog dog = new Dog("旺财", 3, "狗粮", "大", "社牛", "无固定工作","高兴的跳起来");
        Cat cat = new Cat("咪咪", 1, "猫粮", "琥珀色", "花斑", "蓝眼睛");
        land.sunRise();
        land.wind();
        land.rain();
        land.life(dog);
        land.life(cat);
        land.sunSet();
        System.out.println("----陆地时代谢幕----");
        Sea sea = new Sea();
        Fish fish = new Fish("啾啾",1,"面包屑","能动态变色","能动态发光","擅长伪装");
        sea.sunrise();
        sea.wave();
        sea.life(fish);
        sea.deepToSea();
        sea.sunset();
        System.out.println("----海洋时代谢幕----");
    }
}
