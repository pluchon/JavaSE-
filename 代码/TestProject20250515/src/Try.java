import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-05-15-08:48
 * 作者代码水平一般，难免难看，请见谅
 */
public class Try {
    public static void main1(String[] args) {
        //首先我们来讲输入和输出
        System.out.println("hello world");//这个是换行输出
        System.out.print("hello world"+" ");//这个是不换行输出
        System.out.printf("%s","hello world");//这个是格式化规范输出，很少使用
        //其次我们再来讲输入
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);//必写的一行代码,Scanner后面的sc可以取其他名字，但建议sc
        //int input = sc.nextInt();//你输入的是什么类型，初始化成什么类型，目前只能读取到一个输入的值
        //这里的nextInt表示你读取到非整数内容就停止读取，而next读取到空格就停止了
        //System.out.println(input);
        //sc.close();//使用后关闭资源，不关也可以
        //下面有种特殊情况
//        System.out.println("年龄");
//        int age = sc.nextInt();
//        //sc.nextLine();//单独添加这一行，让这一行把空行读走
//        System.out.println("姓名");
//        String high = sc.nextLine();//注意看这里是nextLine
//        //读取的是一行的内容，你输入完年龄后回车产生了一个空行，而nextLine把这个空行读走了，导致打印结果是空的
//        System.out.println("年龄："+age);
//        System.out.println("姓名："+high);
        //再讲一个循环输入问题，我们可以使用CTRL+d来自己终止循环读入
        int sum = 0;
        while(sc.hasNextInt()) {//hasNextInt中int类型表示你输入除整数以外的数循环终止，建议输入什么联系就写什么类型的hasNext
            int input = sc.nextInt();//←毕竟这里是nextInt
            sum += input;//我们就写一个求和的循环输入把，你提前终止循环输入。会导致你输入的数没有加到sum中去，你输入完数后回车以下
        //    此时再按ctrl+d才会有正确结果
        }
        System.out.println(sum);
    }

    public static int addSimple (int num1,int num2){
        int ret = num1+num2;
        return ret;//这里的return作为方法结束的标志，而且支持链式表达式，比如return (1/2)+6
    }

    public static double addSimple (double num1,double num2){
        double ret = num1+num2;
        return ret;//这个方法就是addSimple方法的重载，这个重构的方法是专门求浮点型的
    }

    public static void swap(int num3,int num4){
        int temp = num3;
        num3 = num4;
        num4 = temp;
    }

    //public static void addSimple (int num1,int num2){
    //    int ret = num1+num2;//这个方法只改变了返回类型，不能构成重载
    //}

    public static void main2(String[] args) {
        //我们再来讲方法的使用,我们上面那一行就是main方法的格式，你可以把方法理解成一个工厂，原材料进去成品出来
        //Java中的方法不需要声明，而且你写哪里都可以，毕竟Java是全局搜索的，而且方法不可以嵌套，不像C/C++函数一样
        //public static是修饰符，void是返回类型，main是方法名，括号里的东西是形参，这就是基本结构
        //其生命周期，作用域，就是在“{}”内部，进入开始，出去结束
        //如何调用方法呢？我们这里创建一个求两数之和的方法
        int result = addSimple(1,2);//如果方法有返回值（除void以外的），我们需要有一个变量来接收，如果方法无返回值，则为void
        System.out.println(result);//还有个要注意的点，你方法的返回值是什么类型，你接收方法返回值的变量就要是什么类型
        //三匹配：方法返回类型，返回值类型，接受方法返回值的变量的类型
        //你肯定写过在C语言中通过函数交换两个数字，用的是地址，但是在Java中，不存在地址的概念，所以Java很安全
        int num3 =1,num4 = 2;
        swap(1,2);//这里的num3：是编译器自己加的，我们不用管
        System.out.println(num3+" "+num4);//我们发现并没有交换，原理跟C语言差不多，你形参知识实参的一份临时拷贝
        //也就是说形参有自己的一块空间，你交换了形参并不等于交换了实参，在Java中只有传值调用，而且方法调用同样是要在栈上开辟空间
    }

    public static void main3(String[] args) {
        //接着我们将方法重载，这个跟C++很像，我们每个重构的方法可以去相同的方法名，在方法调用的时候编译器自己选择
        //重载三个条件：方法名相同，（参数列表/参数类型/参数个数）不同，并且和返回类型无关！！
        //我们就拿两数之和来举例
        int ret1 = addSimple(1,2);
        double ret2 =addSimple(1.5,2.5);
        //编译器会根据参数列表自动选择对应的方法，怎么样，很智能吧！但是我们人看起来各个方法名都是一模一样的，同名不会报错吗？
        //→方法签名是编译器将不同的重构的方法进行修改后最终的方法名，也就是编译器看到的方法名，格式是：方法名+参数列表
    }

    public static int func(int n){
        if(n==1){//这个是起始条件，也是递归中递推的终止条件
            return 1;
        }
        return n*func(n-1);
    }//这就是最简单的递归形式

    public static void print(int num){
        if(num<10){
            System.out.print(num+" ");
        }else {
            print(num / 10);//递推
            System.out.print(num % 10+" ");//回归的时候打印
        }//为什么不写else会导致栈溢出？
        //这是因为在if中不存在return语句，return语句作用就是终止后面代码执行
        //这是因为即使你的num小于了10，上面执行完了，下面的else部分还是会执行
    }

    public static int add (int num){
        if(num==1){
            return 1;//这里有return语句，满足条件后后面代码就不会执行
        }
            return num + add(num - 1);
    }

    public static int addPlus (int num){
        if(num<=0){
            System.out.println("输入错误");
            return 0;
        }
        if(num<10){
            return num;
        }
        return(num%10)+addPlus(num/10);
    }

    public static int fib(int num){
        if(num==1 || num==2){//对特殊值进行区分
            return 1;
        }
       return fib(num-1)+fib(num-2);
    }

    public static void main4(String[] args) {
        //我们最后来讲方法递归，之前在C语言中的函数递归与之类似
        //递归求N的阶乘
        int ret3 =func(3);
        System.out.println(ret3);
        //递归来顺序打印4567
        print(1234);
        //递归求1~10的和
        int ret4 = add(10);
        System.out.println(ret4);
        //递归一个数字，并把各个位数数字求和，比如1729，各个位数之和是19
        int ret5 = addPlus(2255);
        System.out.println(ret5);
        //我们再尝试用递归求斐波那契数
        int ret6 =fib(10);//你会发现数字很大了之后计算特别慢
        System.out.println(ret6);
        //因此我们使用迭代（循环）来解决这个问题
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret7 = 0;
        int strat = 3;
        if(n==1 || n==2) {//对特殊值进行区分
            ret7 = 1;
        }
        int step1 = 1;
        int step2 = 1;
        int step3 = 0;
        while(strat<=n){
            step3 = step1+step2;
            step1=step2;
            step2=step3;//注意前后顺序不能弄反，不然值会错乱
            strat++;
        }
        System.out.println(step3);//打印最终结果
    }
}
