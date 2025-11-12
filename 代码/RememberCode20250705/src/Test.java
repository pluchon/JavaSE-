import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-05-07:24
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main1(String[] args) {
        int num1 = 1;
        while (num1 < 10) {
            System.out.print(num1 + " ");
            num1++;
        }
        System.out.println();
        int num2 = 10;
        while (num2 < 999999) {
            int count = 0;//计数器
            int temp = num2;//临时变量
            while (temp != 0) {//统计几位数
                temp /= 10;
                count++;
            }
            int sum = 0;//求和
            temp = num2;
            while(temp!=0){
                sum += Math.pow(temp%10,count);//运用Math方法
                temp /= 10;
            }
            if(sum==num2){
                System.out.print(sum+" ");
            }
            num2++;
        }
    }

    public static boolean IsLeapYear(int year){
        if((year%4==0&&year%100!=0)||year%400 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {//输入年月日判断当前天数是本年的第几天
        //我们可以先判断是否是闰年，再设计两套月份数组，输入几月后再把这个月之前的天数加起来
        //先判断是不是闰年
        Scanner sc = new Scanner(System.in);
        System.out.print("输入年份：");
        int year = sc.nextInt();
        System.out.print("输入月份：");
        int month = sc.nextInt();
        System.out.print("输入天数：");
        int day = sc.nextInt();

        //再创建闰年和非闰年数组
        int [] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int [] monthss = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};

        int sum = day;//求和器，先把当前月天数加上，再把前几个月天数加上

        boolean ret = IsLeapYear(year);

        if(ret){
            for (int i = 1; i < month; i++) {
                sum += monthss[i];
            }
        }else{
            for (int i = 1; i < month; i++) {
                sum += months[i];
            }
        }

        System.out.println("当前对应"+year+"年第"+sum+"天");
    }
}
