import com.sun.jdi.IntegerValue;

import javax.lang.model.element.NestingKind;
import java.awt.print.Printable;
import java.net.SocketTimeoutException;

/**
 * @author pluchon
 * @create 2025-05-11-16:50
 * 作者代码水平一般，难免难看，请见谅
 */

//我发现每个整数类型的包装名都要大写，包括整型，但是为什么老师的那个不用呢？难道是编译器不同导致的吗
public class TryNewThing {
    public static void main1(String[] args) {//这样可以把其他的main方法注释掉
        int a = 10;
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);//没想到Java求最大值和最小值要写integer，我还捣鼓半天呢哈哈
        System.out.println(Integer.MIN_VALUE);
    }

    public static void main2(String[] args) {//这里也是一样，可以通过这种方式注释掉
        long num1 = 10L;//推荐大写的L啦，小写的也可以，但是小写的经常被误认为数字1啦
        System.out.println(num1);
        System.out.println(Long.MAX_VALUE);//wow，打印长整型的最大值和最小值直接用首字符大写的Long呀
        System.out.println(Long.MIN_VALUE);
    }

    public static void main3(String[] args) {
        short num2 = 32767;
        System.out.println(num2);
        System.out.println(Short.MAX_VALUE);//原来短整型也是这么个包装名
        System.out.println(Short.MIN_VALUE);
    }

    public static void main4(String[] args) {
        byte num3 = 127;//哇塞，byte类型表示的范围真的很小呢
        System.out.println(num3);
        System.out.println(Byte.MAX_VALUE);//这个也是一样的包装名呢
        System.out.println(Byte.MIN_VALUE);
    }

    public static void main5(String[] args) {//我们来针对浮点型分析代码
        int simple1 = 1;
        int simple2 = 2;
        System.out.println(simple1 / simple2);//输出0，因为毕竟是整型，舍弃了小数部分
        double num4 = 1.0;//小数默认是double型
        double num5 = 2.0;//当然这里的两个num数据写1和2也可以，相除后仍是0.5
        System.out.println(num4 / num5);//只有同时写成double型，才会输出0.5，否则是0
        System.out.println(Double.MAX_VALUE);//可以看到是一个科学计数法
        System.out.println(Double.MIN_VALUE);
    }

    public static void main6(String[] args) {
        float num6 = 12.5f;//若不加f，默认是double，而你的类型是float，空间不够存不下
        float simple3 = 1.0f / 3.0f;
        double simple4 = 1.0 / 3.0;
        System.out.println(simple3);//结果是0.33333334
        System.out.println(simple4);//结果是0.3333333333333333
        System.out.println(Float.MAX_VALUE);//可以看到也是是一个科学计数法，好像跟double类型范围是一样的
        System.out.println(Float.MIN_VALUE);//但是，它们表示的小数范围是不一样的，精确度不一样，因此我们知道了double类型相比于float类型，精度更高
    }

    public static void main7(String[] args) {
        char ch = 'A';
        char ch2 = '早';//你没看错，因为Java中char类型是两个字节，也就是说它可以存中文字符（中文字符默认两个字节）
        char ch3 = 97;
        System.out.println(ch);
        System.out.println(ch2);
        //注意char类型的包装名是Character
        System.out.println(Character.MAX_VALUE);//最大值有的是不可打印字符，所以没有打印出来
        System.out.println(Character.MAX_VALUE);//跟上面一样，有的是不可打印字符，打印不出来
        System.out.println(ch3);//打印的就是Unicode编码里的97对应的字符
    }

    public static void main8(String[] args) {
        //注意在Java中不存在true表示1，false表示0的用法，打印输出也只是打印输出true和false，并且还不能进行加减
        boolean sign1 = true;
        boolean sign2 = false;
        //boolean simple5 = sign1+sign2;//这行代码直接报错
        System.out.println(sign1);
        System.out.println(sign2);
    }

    public static void main9(String[] args) {
        //我们接着来介绍强制类型转换
        //首先是自动的，是隐式转换，自动的无需我们自己处理，针对的是小的类型转成大的类型
        int num7 = 5;
        long num8 = num7;//这里就把5从整型转换成长整型
        float f = 12.5f;//这里就把12.5从float类型转换成double类型
        double fPro = f;
        System.out.println(num8);
        System.out.println(fPro);
        //假如是大的类型转换层小的类型呢，会发生什么
        double num9 = 12.12345678;
        float num10 = (float) num9;//float类型存储小数点后六位，但是如果超过范围
        //强制类型转换的，会导致你小数精度丢失，自然，四舍五入就为12.123457
        System.out.println(num10);
        byte num11 = (byte) 128;//类似于C语言中的截断机制，注意在内存中是以补码的形式存输的
        System.out.println(num11);
    }

    public static void main10(String[] args) {
        //我们再来将整型提升问题，小的类型向大的类型提升
        int num12 = 20;
        long num13 = 40;
        long ret = num12 + num13;//这里我们必须要用long类型变量来接收，因为int类型小于long类型
        //发生整型提升，因此结果我们也要用long类型来接收
        System.out.println(ret);
        byte num14 = 10;
        byte num15 = 30;
        int ret2 = num14 + num15;//在进行加减运算时，因为CPU运算逻辑，默认提升为整型进行计算，因此接收也要用整型来接收
        System.out.println(ret2);
        //但是你想强行转换也可以，但可能产生数据丢失问题（数据超出类型范围的时候）
        byte ret3 = (byte) (num14 + num15);
        System.out.println(ret3);
    }

    public static void main11(String[] args) {
        //我们接下来讲字符串类型,它不属于我们的基本四大类型,首字母必须大写
        String str1 = "hello world ";
        System.out.println(str1);
        //有一点比较特殊，在Java中，字符串之间使用加号，表示拼接的意思
        String str2 = "hello everyone";
        String ret4 = str1 + str2;
        System.out.println(ret4);//打印的就是两个字符串拼接起来的内容：hello world hello everyone
        //但是有个细节需要我们注意，+确实是在字符串中表示拼接作用，但是如果你+号两侧中字符串类型的位置不一样，会导致结果不同
        int num16 = 10;
        int num17 = 40;
        System.out.println(str2 + num16 + num17);//运行结果是hello everyone1040
        System.out.println(num16 + num17 + str2);//运行结果是50hello everyone
        //为什么两者的情况不同呢？原来是字符串变量在前面，执行拼接指令，在后面则等前面的变量值执行完了，再执行后面
        //但如果你就是向字符串在前的时候拼接上比如变量相加的结果呢？很简单，加个括号就可以了
        System.out.println(str2 + (num16 + num17));//打印结果就是hello everyone50了
    }

    public static void main12(String[] args) {
        //其与其他类型的转换
        //int转string，我们可以给字符的结果加上“”或者是使用Srring方法中的valueof功能
        int num18 = 10;
        String str3 = num18 + "";
        System.out.println(str3);
        System.out.println(String.valueOf(num18));//这样也可以强制转换
        //String转int
        String strOther = "hello world";
        int otherInt = Integer.parseInt(strOther);
    }

    public static void main13(String[] args) {
        //我们接着来介绍运算符吧
        int num19 = 50;
        int num20 = 0;
        //System.out.println(num19/num20);//这段代码会报错，因为num20是一个0的值，计算异常，也就是0不能作为除数
        //Java中有一种特殊求余的方式，小数点求余，这是在C/C++中所没有的
        System.out.println(11.0 % 2.0);//结果是1.0
    }

    public static void main14(String[] args) {
        //接下来我们看增量运算符问题，这里的例子涉及到的是隐式强行转换
        int num21 = 10;
        num21 += 1.5;
        System.out.println(num21);//为何打印的结果是11呢？
        //因为你num21是一个整型类型，你加上一个1.5相当于是double类型，10会发生整型提升
        //计算后的结果本应该是11.5，但是你的num21是int类型，会进行强制转化，舍弃小数部分，不会四舍五入，因此上述计算式子等同于
        num21 = (int) (num21 + 1.5);
        System.out.println(num21);//这里的打印结果就是12了
    }

    public static void main15(String[] args) {
        int num22 = 4;
        //在C语言中，这段代码：3<num22<5的最终结果是true为真，但是在Java中无法通过编译，这是因为第3<5判断后，返回的类型是true
        //而true和5不是同一个类型，无法比较，Java中对类型的检查非常严格
        //接下来的短路求值，这基本上就跟C语言差不多了，但是在Java中如果是按位与和按位或，则不会短路
        int num23 = 2;
        boolean ret5 = num22 > num23 && 1 > 2;
        System.out.println(ret5);//打印结果是false，因为两边同时为真整个式子才为真
        boolean ret6 = num22 > num23 || 1 > 2;
        System.out.println(ret6);//打印结果为true，只要两边有一边为真整个式子就是真
        int erroSimple = 0;
        boolean reterror = num22>num23&(1/erroSimple)>2;//如果你不使用短路，会发生程序抛出异常
        //报错信息→→Exception in thread "main" java.lang.ArithmeticException: / by zero
        boolean retError2 = num22>num23|(1/erroSimple)>2;
        //同理会发生程序抛出异常，Exception in thread "main" java.lang.ArithmeticException: / by zero
        //System.out.println(retError);
        //System.out.println(retError2);
        //针对程序抛出异常，我们使用短路来确保安全
        boolean retError3 = num22 > num23 || (1 / erroSimple) > 2;
        System.out.println(retError3);//输出为true，右边式子不会计算，不会执行右边的抛出异常
    }

    public static void main16(String[] args) {
        //位运算符之前在C语言中已经计算过了，这里不做过多介绍，这里举一个例子来看看
        int num24 = 0xf;//这是十六进制数字，f代表15
        int ret7 = ~0xf;
        System.out.println(ret7);//诶，打印结果是-16，为什么呢？这个我们在博客中展开来讲把，取反是按原码取反
        //同样移位操作符也讲过，这里我举一个特殊例子
        int num25 = -1;
        int ret8 = num25 >> 1;
        System.out.println(ret8);
        //但是在Java中有一种特殊的右移，无符号右移，就是右移后甭管你是正数还是负数，一律添上0
        int ret9 = num25 >>> 1;
        System.out.println(ret9);//结果是2147483647，一个非常大的数，我们会在博客中进行拆解分析
    }

    public static void main(String[] args) {
        //接下来我们讲条件操作符，跟C语言有些类似，但是这个操作符的值必须是有其他值去接收结果值来接收
        int ret10 = 1 > 0 ? 2 : 4;//问号左边式子必须是布尔类型的判断
        System.out.println(ret10);
        //至于运算符优先级，与其记那些规则，还不如直接添加括号，想让哪个部分先算就把哪个部分加括号即可
    }
}











