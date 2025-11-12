/**
 * @author pluchon
 * @create 2025-05-13-08:40
 * 作者代码水平一般，难免难看，请见谅
 */
public class TryCode {//我们今天要讲的东西不多，基本上都是对C语言学习中的算法知识回顾

    //首先就是程序逻辑控制，首先是分支和选择
    public static void main1(String[] args) {
        //if判断类
        //判断数字奇偶性
        int num1 = 5;
        if (num1 % 2 == 0) {
            System.out.println("是偶数");
        } else {
            System.out.println("是奇数");
        }
        //判断正负还是0
        int num2 = -1;
        if (num2 > 0) {
            System.out.println("是正数");
        } else if (num2 < 0) {
            System.out.println("是负数");
        } else {
            System.out.println("是0");
        }
        //判断闰年
        int year = 2024;
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("是闰年");
        } else {
            System.out.println("不是闰年");
        }
        //悬浮else问题，这个在C语言中讲过了
        if (num1 == 5)
            if (num2 == -1)
                System.out.println("true");
            else
                System.out.println("false");
        //输出true，else是跟最近的if匹配，编译器也帮我们自动对齐了
    }

    public static void main2(String[] args) {
        //swithch语句
        int num3 = 3;
        switch (num3) {
            case 1:
                System.out.println("错误");
                break;
            case 2:
                System.out.println("错误");
                break;
            case 3:
                System.out.println("输入正确");//输出这条语句了
                break;
            default:
                System.out.println("非法！");
                break;
        }
        //还可以判断字符，以及其他类型
        char str1 = '中';
        switch (str1) {
            case '中':
                System.out.println("输出正确");
                break;
            default:
                System.out.println("输出错误");
                break;
        }
        //唯独不能是long，float，double，boolean类型
        long errorNum1 = 15L;
        //switch (errorNum1){
        //    case 15L:
        //        System.out.println("正错误");
        //        break;
        //以上代码直接报错
    }

    public static void main3(String[] args) {
        //接下来我们讲循环结构
        //首先是while循环，首先在Java中不能写while(1)这种死循环
        //打印1~10数字
        int num4 = 1;
        while (num4 <= 10) {
            System.out.print(num4 + " ");
            num4++;
        }
        //打印1~1000数字之和
        int num5 = 1;
        int sum1 = 0;
        while (num5 <= 1000) {
            sum1 += num5;
            num5++;
        }
        System.out.println(sum1);
        //计算阶乘
        int num6 = 1;
        //int ret = 1;
        //while(num6 <= 10){
        //    ret *= num6;
        //    num6++;
        //}
        //System.out.println(ret);
        //计算阶乘的和
        int sum2 = 0;
        while (num6 <= 10) {
            int flag = 1;
            int ret = 1;
            while (flag <= num6) {
                ret *= flag;
                flag++;
            }
            sum2 += ret;//每次小的循环完求和
            num6++;
        }
        System.out.println(sum2);//这就很神奇了，明明只隔着个循环，值不能传递到下面？
        //找到1~100之间第一个3的倍数
        while (num6 <= 100) {
            if (num6 % 3 == 0) {
                System.out.println("找到了");
                break;
            }
            num6++;
        }
        //找出100以内所有3和4的倍数
        while (num6 <= 100) {
            if (num6 % 3 == 0 && num6 % 4 == 0) {
                System.out.print("找到了，是" + num6 + " ");
            }
            num6++;
        }
        System.out.print("\n");
        //这里利用continue讲一个while循环注意事项
        while (num6 <= 105) {
            if (num6 % 2 != 0) {
                num6++; // 这⾥的++ 不要忘记，不然会死循环.
                continue;
            }
            System.out.println("找到了2的倍数, 为:" + num6);
            num6++;
        }
        //for循环与之类似，我们再日常工作中也是使用for循环最多，这里只举一个例子
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i);
        }
        //for( ; ; )//这是一个死循环
        //for(int i = 0 ; ; i++)//这也是一个死循环，因为中间终止条件没写
        //接下来讲很少用到的do-while循环，它至少执行一次，执行之后再判断
        System.out.print("\n");
        do {
            System.out.println("num真的是负数吗");
        } while (num6 < 0);//代码结果显而易见
    }

    public static void main4(String[] args) {
        //判断素数
        /*
        int num7 = 22;
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num7); i++) {//这里用到了数学方法Math中的一个功能
            if (num7 % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag == false) {
            System.out.println("不是素数");
        } else {
            System.out.println("是素数");
        }
         */
        //打印水仙花数
        for (int i = 1; i < 999; i++) {//1~10都是特殊的独身数
            int temp = i;
            int count = 0;
            while (temp != 0) {
                temp /= 10;
                count++;
            }
            temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += Math.pow(temp % 10,count);//数据太大精度丢失
                temp /= 10;
            }
            if (sum == i) {
                System.out.print(i+" ");
            }
        }
    }
}
