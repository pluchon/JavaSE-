import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-05-15-10:23
 * 作者代码水平一般，难免难看，请见谅
 */
public class Homework {

    public static int get (int num1,int num2){
        return Math.max(num1,num2);
    }

    public static double get(double num1,double num2,double num3){
        return Math.max(num1, Math.max(num2,num3));//可以使用Math嵌套
    }

    public static void main1(String[] args) {
        //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
        int ret1 = get(10,20);
        double ret2 =get(10.5,50.5,13.14);
        System.out.println(ret1);
        System.out.println(ret2);
    }

    public static void hanNuoTa (int num,char pos1,char pos2,char pos3){
        if(num==1) {//递归终止条件
            System.out.print(pos1+"→"+pos3+" ");
        }else {//一定要写else，因为递归式子中无return，会导致无限递归
            hanNuoTa(num - 1, pos1, pos3, pos2);
            System.out.print(pos1 + "→" + pos2+" ");
            hanNuoTa(num - 1, pos2, pos1, pos3);
        }
    }

    public static void main(String[] args) {
        //我们再使用递归求汉诺塔问题
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        hanNuoTa(input,'A','B','C');
    }
}
