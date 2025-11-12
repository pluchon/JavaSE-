package mypackage;

/**
 * @author pluchon
 * @create 2025-05-27-09:11
 * 作者代码水平一般，难免难看，请见谅
 */
public class TryPlusPlus {
    public static void main1(String[] args) {
        //TryPlus tryPlus = new TryPlus();
        //tryPlus.name = "zlhs";
        //System.out.println(tryPlus.name);
        //tryPlus.setAge(20);
        //tryPlus.getAge();
        //System.out.println("-------");
        //TryPlus person1 = new TryPlus();
        //System.out.println(person1.high);
        //person1.func1();
    }

    public static void main(String[] args) {
        {
            int tmp = 100;
            System.out.println("这是在main方法中普通代码块");
        }
        TryPlus tryPluss = new TryPlus();
        System.out.println(tryPluss.a);
        System.out.println();
        TryPlus tryPlusss = new TryPlus();
        System.out.print(tryPlusss.a);
    }
}
