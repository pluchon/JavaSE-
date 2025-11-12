package demo2;

/**
 * @author pluchon
 * @create 2025-06-04-11:32
 * 作者代码水平一般，难免难看，请见谅
 */
public class EatPlus {
    public String foodType;
    public String biolFire;

    public EatPlus(String foodType, String biolFire) {
        this.foodType = foodType;
        this.biolFire = biolFire;
    }

    @Override
    public String toString() {
        return "EatPlus{" +
                "foodType='" + foodType + '\'' +
                ", biolFire='" + biolFire + '\'' +
                '}';
    }
}
