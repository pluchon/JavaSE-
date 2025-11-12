import javax.xml.transform.Source;
import java.util.*;
import java.util.function.Function;
import java.util.zip.CheckedOutputStream;

/**
 * @author pluchon
 * @create 2025-05-08-21:00
 */
public class Try {
    public static void main1(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num = 0;
        while (sc.hasNextInt()) {//表示直到输入到非整数结束循环,只会统计小数点之前的数
            //这段代码仅支持计算整数（你可以输入小数来终止创造循环读取的终止条件），且切记输入整数后手动输入^D终止流
            //反之hasNextDouble亦然
            int tmp = sc.nextInt();//^D是用来主动终止程序的，快捷键：Ctrl和d
            sum += tmp;
            num++;//num++ 是一个计数器，每执行一次，表示 读取了一个有效的整数。它的核心作用是：
            //记录输入次数：每次循环读取一个整数，num 加1，最终 num 的值等于输入的整数总数
            //计算平均值：最后计算平均值时，需要用总和 sum 除以输入的整数个数 num（即 sum / num）
            //
            //sc.hasNextInt() 是Scanner类的方法，作用是 检查输入流中是否还有下一个整数
            //使用原因：过滤非整数输入：确保只有整数会被处理。如果输入字母、小数等非整数值，循环会立即终止，避免程序崩溃
            //灵活控制输入结束：允许用户通过输入结束符主动终止输入，程序随后输出结果
        }
        System.out.println("sum = " + sum);
        System.out.println("avg = " + sum / num);
        sc.close();
    }

    public static void main3(String[] args) {
        Random random = new Random();//创建对象
        Scanner sc = new Scanner(System.in);//创建对象，并且绑定到输入流
        int toGuess = random.nextInt(100) + 1; // 修正为 1~100（原0~99）
        // System.out.println("toGuess: " + toGuess);
        while (true) {
            System.out.println("请输入要猜测的数字 (1-100): ");
            if (sc.hasNextInt()) {//检查输入是否合规，我觉得这一步挺重要的
                int num = sc.nextInt();
                if (num < toGuess) {
                    System.out.println("低了");
                } else if (num > toGuess) {
                    System.out.println("高了");
                } else {
                    System.out.println("猜对了");
                    break;
                }
            } else {
                System.out.println("输入无效，请重新输入整数！");
                sc.next(); // 清除无效输入
            }
        }
        sc.close();//关闭资源，必要！
    }

    //写一个方法来判断闰年，先把定义写出来，但是没有返回结果，因为还没有调用，方法写在main类的外面
    public static boolean isYear(int year) {//注意要写返回值，和C/C++一样
        //没有返回值要写void！而且在Java中，方法无需声明
        if ((0 == year % 4 && 0 != year % 100) || 0 == year % 400) {
            return true;
        } else {
            return false;
        }
    }

    public static void main4(String[] args) {
        //跟C/C++类似，我们需要调用方法，就跟调用函数一样
        boolean ret = isYear(2005);
        if (ret) {
            System.out.println("不是闰年");
        } else {
            System.out.println("是闰年");
        }
    }

    public static int trueNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int ret = 1;//每次阶乘重置
            for (int q = 1; q <= i; q++) {
                ret *= q;
            }
            sum += ret;//以此阶乘完统计一次求和
        }
        return sum;//sum也可以替换成一个表达式，比如(2+5)/2
    }

    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);//建立对象
        int input = sc.nextInt();//初始化输入值
        int ret = trueNum(input);//调用方法
        System.out.println(ret);
    }

    public static void main6(String[] args) {
        int ret1 = add(1, 2); // 调⽤add(int, int)
        double ret2 = add(1.5, 2.5); // 调⽤add(double, double)
        double ret3 = add(1.5, 2.5, 3.5); // 调⽤add(double, double, double)
        System.out.printf("%d %.1f %.1f", ret1, ret2, ret3);//直接格式化输出一次性打印多个值，默认是打印6个小数位
        System.out.print("\n");
        //int in = simple(1729);
        //System.out.println(in);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double add(double x, double y, double z) {
        return x + y + z;
    }

    //转到反汇编分析，我再搜寻下Java中如何进行反汇编？？
    //我发现了只需要在左边打开out文件→production
    //但是这样看不到add函数真正的名字，怎么办？
    //接下来就是一些递归代码练习，之前已经练过，这里只练习比较难的
    //输⼊⼀个⾮负整数，返回组成它的数字之和. 例如，输⼊ 1729, 则应该返回1+7+2+9，它的和是19
    public static int fun(int x) {
        if (x < 10) {//这是递归终止条件
            return x;
        }
        return x % 10 + fun(x / 10);//右边是进行下一次递归
    }

    public static void main7(String[] args) {
        //我们进行数组的尝试
        int[] array1 = new int[10];//左边那个int是数组类型，右边那个是存放数组中的元素的数据类型
        double[] array2 = new double[5];//写了数组大小，表示动态初始化
        String[] array3 = new String[3];
        int[] array4 = new int[]{1, 2, 3, 4, 5};//没写数组大小，表示静态初始化，根据数组内容自动改变代大小
        String[] array5 = new String[]{"hello world", "6666"};
        String[] array6 = {"hello world", "hello"};//静态初始化可以直接这么写，不写new String
        //当然你初始化数组也可以分两步
        int[] array7;
        array7 = new int[10];//这一步一定要写，在分两步初始化的时候；只有你在定义的同时初始化才可以省略
        //数组未初始化会存在一些默认值，如果是引用类型的话，是null
        //当然在Java中也会有数组下标
        System.out.println(array6[0]);
        //当然你也可以通过数组下标循环打印数组元素，当然不能越界，不然会产生程序抛出异常
        for (int i = 0; i < 5; i++) {
            System.out.print(array4[i] + " ");
        }
        //但是如果数组长度变化呢？我们之前在C语言学过利用sizeof求得，但是在Java中，我们可以直接通过包装类来求
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
        }
        //你也可以通过for-each来遍历数组，这种我从没见过呀
        for (int x : array4) {
            System.out.print(x + " ");
        }
        for (String x : array6) {
            System.out.println(x);
        }
        //通过以上规律我明白了，对于这种循环的打印，我们要打印的数组是什么类型，则我们就初始化成什么类型的X变量
        //接着我们讲数组引用传参
        int[] arr = {1, 2, 3, 4, 5, 6};
        func(arr);
        System.out.println(arr[0]);//我们发现把数组传过去，Java不会像C一样拷贝数组，而是直接传了地址，我们可以直接改变原数组中内容
        //数组转字符串
        String array8 = Arrays.toString(array4);
        System.out.println(array8);//[1, 2, 3, 4, 5]这就是结果,这样就可以一连串打印数组
        //引用同类数组
        int[] array9 = arr;
        array9[0] = 1;
        System.out.println(Arrays.toString(arr));//我们发现原来的arr数组也被进行了修改，因此这种方法不可拷贝数组
        //使⽤Arrays中copyOf⽅法完成数组的拷⻉
        array9 = Arrays.copyOf(arr, arr.length);
        array9[0] = 10;
        System.out.println(Arrays.toString(array9));//可以看到我们进行拷贝后，原数组的值不会再因后来值改变而改变
        array9 = Arrays.copyOfRange(arr, 2, 4);//这里数字指的是下标
        System.out.println(Arrays.toString(array9));//我们可以看到只拷贝了3和4
        //下面这里补充冒泡排序

        //对于数组排序，我们可以使用冒泡排序，但是效率较低，Java中内置了更高效的排序方法
        int[] array10 = {4, 2, 6, 7};
        Arrays.sort(array10);
        System.out.println(Arrays.toString(array10));//怎么样，是不是非常快速呢？
        //给点一个数组，将数组元素逆序
        int[] array11 = {1, 2, 3, 4, 6};
        int left = 0;
        int right = array11.length - 1;
        while (left < right) {
            int temp = array11[left];
            array11[left] = array11[right];
            array11[right] = temp;
            left++;
            right--;
            //左右下标相等的时候循环就结束了
        }
        System.out.println(Arrays.toString(array11));
        //Java中的二维数组中行不可以省略，列可以，这个跟C/C++不一样呢
        //因此你求数组的length求的是数组行数，arr[row].length才是求数组列数
        int[][] array12 = {
                {1, 2, 3, 4, 5, 6},//用逗号分隔
                {7, 8, 9, 10, 11, 12}
        };
        int[][] array13 = new int[5][];//可以不写列，但一定要写行
        //再来讲不规则数组
        int[][] array14 = new int[2][];
        array14[0] = new int[3];//这是第一行，有三个元素
        array14[1] = new int[5];//这是第二行，有5个元素
    }

    public static void func(int[] arrs) {
        arrs[0] = 10;
    }

    public static int simpleAdd(int a,int b){
        a*=2;
        b*=2;
        return a+b;
    }

    public static void main8(String[] args) {
        //此处为调试讲解用
        int a = 10;
        int b = 20;
        int ret = simpleAdd(a,b);
        System.out.println(ret);
    }

    //今天我们讲类和对象，首先我们先定义一个简单的类，类名采用大驼峰，而且不写static哦，类里面我们可以再定义方法
    public static class Book {
        String title;
        String author;
        int pages;
        boolean isBorrowed = false;

        public Book() {
            this("Untitled","Unknown",0);//调用三参构造方法
        }

        public Book(String title, int pages) {//调用三参构造方法
            this(title,"Unknown",pages);//没有初始化的变量直接写变量名就好
        }

        public Book(String title, String author, int pages) {
            this.title = title;
            this.author = author;
            this.pages=pages;
        }

        public void borrowBook() {
            if (isBorrowed) {
                System.out.println("【" + title + "】已被借出，暂不可借");
            } else {
                isBorrowed = true;//书借出去了就更新下状态
                System.out.println("【" + title + "】借阅成功！");
            }
        }

        public void returnBook() {
            isBorrowed = false;
            System.out.println("【"+title+"】归还成功！");//归还的时候提示下
        }

        public void showInfo() {
            System.out.println("书名：" + title);
            System.out.println("作者：" + author);
            System.out.println("页数：" + pages);
            System.out.println("状态：" +(isBorrowed?"已借出":"可借"));//这里添加判断，以此来决定打印什么内容
        }
        //如果想要默认打印对象中的属性
        @Override
        public String toString() {
            return "《"+title+"》"+author+"（"+pages+"页)";
        }

        public static void main8(String[] args) {
            Book book = new Book("奇幻世界","未知",100);//实例化一个对象
            book.showInfo();
        }
    }

    public static void main9(String[] args) {
        int [] array = new int[5];
        System.out.println(array);
    }

    //我们一起来感受类和对象
    public static class Date {//编译器强制要求我使用static修饰，为什么？这是因为非static内部无法定义static方法
        public int year;
        public int month;
        public int day;

        public void setDay(int years,int months,int days){
            year = years;//名字不能相同，不然会报0
            month = months;
            day = days;
        }

        public void printDay(){
            System.out.println(year+"/"+month+"/"+day);
        }

        public static void main10(String[] args) {
            Date d1 = new Date();
            Date d2 = new Date();
            Date d3 = new Date();

            d1.setDay(2022,1,20);
            d2.setDay(2023,1,1);
            d3.setDay(2024,2,2);

            d1.printDay();
            d2.printDay();
            d3.printDay();
        }
    }

    public static void main10(String[] args) {
        int [] array1 = new int [5];
        double [] array2 = new double [5];
        float [] array3 = new float [5];
        char [] array4 = new char [5];
        boolean [] array5 = new boolean[5];
        String [] array6 = new String[5];
        Arrays.toString(array1);
    }

    public static void func() {
        int[] array1 = new int[3];
        array1[0] = 5;
        array1[1] = 10;
        array1[2] = 15;
        int[] array2 = new int[]{2,3,4,5,6};
        array2[0] = 30;
        array2[1] = 40;

        array1 = array2;//重点是这一步
        array1[2] = 80;
        array1[3] = 90;
        array2[4] = 100;
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }

    public static void main11(String[] args) {
        func();
        int [] array1 = null;
        System.out.println(array1.length);
    }

    public static void fuction1 (int [] array){
        array = new int []{100,200,300,400,500};
    }

    public static void fuction2 (int [] array){
        array [0] = 99;
    }

    public static void main(String[] args) {
        int [] array = {5,6,7,8,9};
        fuction1(array);
        System.out.println(Arrays.toString(array));
        fuction2(array);
        System.out.println(Arrays.toString(array));
    }
}