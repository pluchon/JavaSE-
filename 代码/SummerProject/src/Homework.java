import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-12-08:06
 * 作者代码水平一般，难免难看，请见谅
 */
public class Homework {

    //1、编写程序，输入一个字符，判断它是否为小写字母，如果是，将它转换成大写字母，否则，不转换。
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的字符：");
        char ch = sc.next().charAt(0);//读取第一个字符
        if (!Character.isLowerCase(ch)) {
            System.out.print("你输入的不是小写字符，需转换：");
            char ret = Character.toLowerCase(ch);
            System.out.println(ret);
        }
    }

    //2、编写程序，对输入的年、月、日，给出该天是该年的第多少天？
    public static void main2(String[] args) {
        System.out.println("请输入年/月/日");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int[] isLeapYear = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//平年数组
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {//判断闰年
            isLeapYear[2] = 29;
        }
        int count = 0;//计数器
        for (int i = 1; i < month; i++) {
            count += isLeapYear[i];//闰年二月要加一天
        }
        count += day;//把天数加上
        System.out.println(year + "年" + month + "月" + day + "日是该年的第" + count + "天");
    }

    //编程求 1~10000 之间的所有“完全数”，完全数是该数的所有因子之和等于该数的数。例如，6 的因子有 1、2、
    //3，且 6=1+2+3，所以 6 是完全数。
    public static void main3(String[] args) {
        int end = 10000;
        for (int i = 1; i <= end; i++) {
            int count = 0;//每次循环重置计数器
            for (int j = 1; j <= i / 2; j++) {//只需遍历一半的数字即可
                if (i % j == 0) {
                    count += j;
                }
            }
            if (count == i) {
                System.out.println(i);
            }
        }
    }

    public static int func(int num, int day) {//可以写一个计数器来跟踪
        if (day >= 10) {
            return num;
        } else {
            return func((num + 1) * 2, day + 1);//必须是day+1不能是day++
        }
    }

    //2、猴子吃桃问题。猴子第一天摘下若干个桃子，当时就吃了一半，还不过瘾，就又吃了一个。第二天又将剩下的
    //桃子吃掉一半，又多吃了一个。以后每天都吃前一天剩下的一半零一个。到第 10 天在想吃的时候就剩一个桃子了,
    //求第一天共摘下来多少个桃子？
    public static void main4(String[] args) {
        int ret = 1;
        int result = func(ret, 1);
        System.out.println("第一天一共摘下了" + result + "个桃子");
    }

    //1、一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多 少
    //米？第10次反弹多高？
    public static void main5(String[] args) {
        double high = 100.0;
        int times = 10;
        double distance = 0.0;
        for (int i = 0; i < times; i++) {
            if (i == 1) {//第一次落地并没有弹跳
                distance += high;
            } else {
                distance += 2 * high;
            }
            high /= 2.0;
        }
        System.out.println("第十次反弹" + high + "高，共" + distance + "米");
    }

    //2、有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子
    //都不死，问第n个月的兔子对数为多少？斐波那契数列，推荐使用迭代
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int count = fibonacci(month);
        System.out.println("第" + month + "个月兔子对数为 " + count);
    }

    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if (month == 1 || month == 2) {
            System.out.println("第" + month + "月兔子对数为1");
        }

        int p1 = 1;
        int p2 = 1;
        int count = 0;

        for (int i = 3; i < month; i++) {
            count = p1 + p2;
            p2 = p1;
            p1 = count;
        }
        System.out.println("第" + month + "月兔子对数为" + count);
    }

    public static int age(int age, int count) {
        if (count == 1) {
            return age;
        } else {
            return age(age + 2, count - 1);
        }
    }

    public static void main8(String[] args) {
        int year = 10;
        int count = 5;
        int ret = age(year, count);
        System.out.println("第五个人为" + ret + "岁");
    }

    public static void main9(String[] args) {
        int year = 10;
        int count = 5;
        for (int i = 1; i < count; i++) {//如果等于count会多加一次
            year += 2;
        }
        System.out.println("第五个人为" + year + "岁");
    }

    public static void main10(String[] args) {
        int[][] arrays = new int[3][3];
        int sum1 = 0;
        int sum2 = 0;
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrays[i][j] = random.nextInt(50) + 1;//生成1~50随机数
            }
        }
        System.out.println("当前数组内容是：" + Arrays.deepToString(arrays));
        //正对角线
        for (int i = 0; i < 3; i++) {
            sum1 += arrays[i][i];
        }
        //反对角线
        for (int i = 0; i < 3; i++) {
            sum2 += arrays[i][2 - i];
        }
        System.out.println("两个对角线元素之和分别是" + sum1 + " " + sum2);
    }

    public static int searchYueShu(int num) {
        // 计算真约数之和（排除自身）
            int sum = 0;
            // 只需遍历到 sqrt(num)
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;             // 添加约数i
                    if (i != 1 && i != num / i) {
                        sum += num / i;   // 添加配对的约数
                    }
                }
            }
            return sum;
    }

    public static void main11(String[] args) {
        for (int i = 2; i < 1000; i++) { // 从2开始（1无意义）
            int j = searchYueShu(i); // i的真约数和 → j
            // 核心条件：j ≠ i 且 i 的真约数和 = j 且 j 的真约数和 = i
            if (j > i && j < 1000 && searchYueShu(j) == i) {
                System.out.println("相亲数对：" + i + " - " + j);
            }
        }
    }

    public static int arraySum(int[] array, int len) {
        // 递归终止条件：当数组长度为0时，返回0
        if (len == 0) {
            return 0;
        }// 递归关系：当前元素 + 前面所有元素的和
        else {
            // 通过len-1获取前n-1个元素的和
            return array[len - 1] + arraySum(array, len - 1);//原来直接这样就好了吗
            //类似于拆积木，先算第一个元素，再把剩下的元素放一起
        }
    }

    public static void main12(String[] args) {
        int[] array1 = {1, 3, 5, 7, 6};
        System.out.println("数组元素和: " + arraySum(array1, array1.length));
    }

    public static boolean isPower(int n){
        if(n % 2 != 0 && n != 1){//直接排除除1以上的奇数
            return false;
        }
        if(n == 1){
            return true;
        }
        boolean ret = true;
        while(n > 1){
            int yushu = n % 2;
            if(yushu == 1){//说明就不是2的倍数
                ret = false;
                break;
            }
            n /= 2;
        }
        return ret;
    }

    public static void main13(String[] args) {
        System.out.println(isPower(256));
    }

    public static int[] findNumberAppearOnce(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0;i<arr.length-1;i++){
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){//有相似的就跳出来
                    break;
                }
                //到这里说明没找到相同的数，arr[i]就是我们要找的数
                //但是问题是返回值是int[]，我们怎么把返回的数字存在数组中呢
                //可以定义一个数组索引
            }
        }
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,1,5,5,4,6,7,7,9,9};//1,1,4,5,5,6,7,7,9,9
        findNumberAppearOnce(array);
    }
}