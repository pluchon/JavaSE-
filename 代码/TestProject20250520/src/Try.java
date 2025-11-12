import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-05-20-07:58
 * 作者代码水平一般，难免难看，请见谅
 */
public class Try {
    //我们先来讲Java中的调试,断点,逐语句,逐过程,强制步入,跳出,运行到光标位置等
    public static int simpleSum(int x,int y){
        int ret = x+y;
        return ret;
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        int ret = simpleSum(10, 20);
        System.out.println(ret);
    }

    public static void main2(String[] args) {
        //我们接着来讲数组的创建
        int [] array1 ={1,2,3,4,5};//直接初始化
        int [] array2 = new int []{1,2,3,4,5};//new对象来初始化,代码的意思是初始化一个数组,类型是int [],通过它创建一个数组对象
        //即new一个int []的类型,注意前后类型要一致,然后初始化数据成1~5,也可以这样:
        int [] array3;
        array3 = new int []{1,2,3,4,5};
        //array = {1,2,3,4,5};//不可以这样写,因为你还没有new一个对象呢,要么像之前写成一行,要么两行并且new一个
        //以上这些都是针对静态初始化,即在初始化时候给定了初始值,接下来我们讲动态初始化
        int [] array4 = new int[5];//这里创建的对象一定要给定大小,,即分配五个整型空间,里面初始化值都是0,通过调试我们也可以观察到
        //因此我们可以得知,动态初始化即初始化1时候未给定初始值,只给定了空间大小
        double [] array5 = new double [5];
        boolean [] array6 = new boolean [5];
        float [] array7 = new float [5];
        String [] array8 = new String[5];
        char [] array9 = new char[5];
        //通过调试看看,发现boolean类型默认初始化为false,引用类型String则为null(这个后面讲),char类型则为",",float是0.0,其他都是0
        //数组创建完我们要访问吧,我们可以跟C语言一样通过下标访问,如果发生越界,不会像C语言中随机值,而是会直接报错:越界异常
        System.out.println(array1[0]);//打印1
        //System.out.println(array1[5]);//报出.ArrayIndexOutOfBoundsException的越界异常
        //我们可以通过很多种方式遍历数组,比如使用循环,我们可以手动计算数组长度,像C语言那样,可是这里可是Java呀,自然有我们的独特方法
        for (int i = 0; i < array1.length; i++) {//这里的length就是计算了数组长度,这样我们数组大小在变化的时候不再需要我们自己改
            System.out.print(array1[i]+" ");
        }
        System.out.println();
        //或者使用for-each强行遍历数组,有个缺点,就是做不到对相应元素下标的一个操作,比如下标2的元素加上一个5
        for(int x:array1){
            System.out.print(x+" ");
        }
        System.out.println();
        //或者使用官方提供的转换成字符串打印的方法,"[1,2,3,4,5]"
        String ret = Arrays.toString(array1);//需要一个字符串类型接受,可以查看帮助文档，输入完Arrays先导包再进行功能选择
        System.out.println(ret);
    }

    //接下来我们将数组引用类型，请你观察下面代码的运行结果
    public static void func() {
        int[] array1 = new int[3];
        array1[0] = 10;
        array1[1] = 20;
        array1[2] = 30;
        int[] array2 = new int[]{1,2,3,4,5};
        array2[0] = 100;
        array2[1] = 200;
        array1 = array2;
        array1[2] = 300;
        array1[3] = 400;
        array2[4] = 500;
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }

    public static int [] funcs (int x){
        int [] simple = {1,2,3,4,5};
        if(x>20){
            return simple;//返回的数组
        }else{
            return null;
        }
    }

    public static void main3(String[] args) {
        func();//为什么是100,200,300,400，500
        //话说数组的创建即是创建了一个对象，我们在栈上创建了array1这个引用类型，里面存的是它所指向的对象（即array1数组）的首元素地址
        //那array1数组就存在堆中，分别是10,20,30
        //同理array2在栈上创建了一个引用类型，里面存的是它所指向的对象（即array2数组）的首元素地址
        //那么array2数组就存在堆中，分别是100,200,300,400,500
        //本来它们两之间都是各存各的，各指各的，但是由于这句代码：array1=array2这句代码的出现使得
        //array1本来是指向自己数组的对象，但是被赋予array2所指向的对象后，array1此时指向的对象就变了，不再是自己原来的array1
        //而是array2，对应的里面存的地址就变成array2首元素的地址了，这么讲应该很清晰了吧
        //因此通过array1和array2都可以访问和修改数组中元素

        //我们再来说一种数组异常，假设你这么写：
        int [] array1 = null;//此时的array1不指向任何对象，输出为null
        //System.out.println(array1.length);//此时会报错：NullPointerException，空指针问题异常，“指针”只是翻译有问题，Java无指针
        System.out.println();
        //数组也可以作为函数的返回值，挺神奇的
        int a = 30;
        int [] ret = funcs(a);
        for (int i = 0; i < ret.length; i++) {//必须通过循环打印，不然报错误值
            System.out.print(ret[i]+" ");
        }
    }

    public static void try1(int [] array){
        array = new int []{10,20,30,40,50};
    }

    public static void try2(int [] array){
        array[0]=100;
    }

    public static void main4(String[] args) {
        //我们再来看一个有意思的例子
        int [] array = {1,2,3,4,5};
        try1(array);
        try2(array);
        //请问结果分别是什么呢？
        //try1:1,23,4,5，try2:100,2,3,4,5，为什么？
        //原理和我之前讲的一样，数组创建，引用变量创建，地址指向这些就不过多叙述，重点在于两个方法中一个是new了一个新对象
        //一个则是通过下标改变了值，在try1方法中，确实接收的是array数组的首元素地址，里面也确实是存放的这个，可是此时你new了一个新对象
        //你让array指向了这个新对象，即array里面的地址发上来改变，指向了你刚刚创建的那么新对象的首元素地址，那在方法销毁后，由于
        //你刚刚创建的方法是一个形参数组，也会跟着一起销毁，形参array也跟着销毁了，那你的实参还是原来的实参呀，并未指向新的对象
        //反观try2方法，也是一样接收引用类型变量创建形参，这个形参指向的就是数组array的首元素地址，然后你通过这个形参访问数组中第一个
        //元素，并把它改成100，方法销毁后你实参的数组是不会销毁的，所以你刚刚做的改动依然有效
    }

    public static void toString (int [] array){//一定要这么写，如果到这些会导致错误
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i==4){
                System.out.print(array[i]);
            }else{
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("]");
    }

    public static void changeString(int [] array){
        int i = 0;
        int j = array.length-1;
        while(i<j){
            int temp = array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+" ");
        }
    }

    public static void main(String[] args) {
        //我们做两个练习，第一个是模拟实现toString，效果是“[1,2,3,4,5]”
        int [] array1 = {1,2,3,4,5};
        toString(array1);
        System.out.println();
        //第二个是有序数组的逆置
        changeString(array1);
    }

    public static void main6(String[] args) {
        //我们讲二维数组
        int [][] array = new int [][]{{1,2,3},{4,5,6}};
        System.out.println(array.length);//打印的是行数
        System.out.println(array[0].length);//指的是第一行列数
        int [][] array2 = new int [][]{{1,2},{4,5,6,7},{9,10}};//对于不规则数组，我们可以分别求对应行的列数
        System.out.println(array2[0].length);
        System.out.println(array2[1].length);
        System.out.println(array2[2].length);
        int [][] array3 = {
                {1,2,3},
                {4,5,6},
                {9,10},
                {12,14,16,18}
        };//也可以这么创建数组
    }
}
