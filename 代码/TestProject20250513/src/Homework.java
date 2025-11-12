import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.util.Random;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-05-13-18:47
 * 作者代码水平一般，难免难看，请见谅
 */
public class Homework {
    public static void main1(String[] args) {
        //打印 1 - 100 之间所有的素数
        System.out.print(2+" ");
        int num1 = 3;
        while(num1<=100) {
            boolean flag = true;//假设是素数
            for (int i = 2; i <= Math.sqrt(num1); i++) {
                if (num1 % i == 0) {
                    flag = false;//布尔值改变
                    break;
                }
            }
            if (flag) {//如果flag值从未改变，先判断再自增
                System.out.print(num1+" ");
            }
            num1 += 2;
        }
    }

    public static void main2(String[] args) {
        //输出闰年在之前代码就有，这里再判断一次吧,输出 1000 - 2000 之间所有的闰年
        int year = 1000;
        while(year<=2000){
            if((year % 4 == 0)&&(year % 100 != 0)||(year % 400 == 0)){
                System.out.println(year);
            }
            year++;
        }
    }

    public static void main3(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int num2 = 1;
        int count = 0;
        while(num2<=100){
            int temp = num2;//使用临时变量，不然会死循环，这个是关键带你，因为你判断完一次循环后，变量值改变
            //本应该是下一个数，比如20判断完应该是21，但是之前的式子导致了20这个值被污染，可能变成了很小的数，导致死循环
            while(temp!=0){
                if(temp % 10 == 9){
                    count++;
                }
                temp/=10;
            }
            num2++;
        }
        System.out.println(count);
    }

    public static void main4(String[] args) {
        //求两个数最大公约数我们采用非欧几里得法，调换顺序没有问题
        int simple1 = 48;
        int simple2 = 18;
        while(true){
            int temp = simple1%simple2;
            if(temp==0){
                System.out.println(simple2);
                break;
            }
            simple1 = simple2;
            simple2 = temp;//这里的不能写成simple1%simple2，因为此时的simple1不是原来的值了
        }
    }

    public static void main5(String[] args) {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100的值
        int simple3 = 1;
        double sum = 0.0;
        int sign = 1;// 符号独立控制,不然会在-2和1之间无限循环
        while(simple3 <=100.0){
            sum +=sign*( 1.0/simple3);
            simple3++;
            sign*=-1;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        //求出0～n之间的所有“水仙花数”并输出
        int simple4 = 1;
        while(simple4<10){
            System.out.print(simple4+" ");
            simple4++;
        }
        System.out.print("\n");
        int num3 = 10;
        while(num3<=99999){
            int count = 0;
            //先统计是几位数
            int temp = num3;
            while(temp != 0) {
                temp /= 10;
                count++;
            }
            int sum = 0;//用来计算次方和
            temp = num3;
            while(temp != 0){
                sum += Math.pow(temp%10,count);
                temp /= 10;
            }
            if(sum==num3){
                System.out.print(num3+" ");
            }
            num3++;
        }
    }

    public static void main7(String[] args) {
        //实现猜数字游戏
        Random rand = new Random();
        int num4 = rand.nextInt(100)+1;
        Scanner input = new Scanner(System.in);
        int fate = 10;
        System.out.println("猜数字，范围在1~100，您总共有10次机会");
        while(true){
            int guess = input.nextInt();//输入放在这，猜不对可以多轮猜
            if(guess>num4){
                System.out.println("猜大了");
                fate--;
                System.out.println("还剩"+fate+"次机会");
            }else if(guess<num4){
                System.out.println("猜小了");
                fate--;
                System.out.println("还剩"+fate+"次机会");
            }else{
                System.out.println("猜对了");
                break;
            }
            if(fate == 0){
                System.out.println("您的机会已用尽");
                break;
            }
        }
        input.close();
    }

    public static void main8(String[] args) {
        //打印“X”图案
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for(int i = 0;i<n;i++){
                for(int q = 0;q<n;q++){
                    if(i==q){
                        System.out.print("*");
                    }else if(i == n-q-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println("\n");//循环完一次换行
            }
        }
    }
}
