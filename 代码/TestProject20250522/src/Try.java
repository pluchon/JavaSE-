import com.sun.tools.javac.Main;

import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-05-22-08:43
 * 作者代码水平一般，难免难看，请见谅
 */
public class Try {
    public static void main1(String[] args) {
        //今天我们接着来讲数组拷贝
        int [] array = {1,2,3,4,5};
        //再定义拷贝数组
        int [] copy = new int [array.length];//拷贝数组长度跟原数组保持一致
        for (int i = 0; i < array.length; i++) {//再利用循环给上值
            copy [i] = array [i];//再把拷贝数组的每一项赋予array数组的值
        }
        for(int x:copy){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");

        //我们再来看一个例子，请你判断下是否拷贝
        int [] copy2 = array;
        for(int x:copy2){
            System.out.print(x+" ");
        }
        //那我问你，虽然结果是正确的，那请问有没有拷贝呢？答案是没有发生
        //这个只是引用了数组，而并未产生新的内容，你copy2数组本质上还是指向array数组，连IDEA都说这个是冗余的
        System.out.println();
        System.out.println("-------------");

        //那真正的拷贝数组是咋样的呢？在Arrays数组方法中有很多功能，其中一个就是copyOf，这个功能也有很多重载，能拷贝很多的类型
        //其返回值是一个数组，我们使用对应数组类型来接收
        int [] copy3 = Arrays.copyOf(array,array.length);//拷贝的长度就是原数组长度
        for(int x:copy3){
            System.out.print(x+" ");
        }
        //我们可以去研究下这个拷贝的源码
        System.out.println();
        System.out.println("-------------");

        //我们发现，即使你拷贝数组大小是小雨原数组的，也可以进行拷贝
        int [] copy4 = Arrays.copyOf(array,array.length/2);
        for(int x:copy4){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");

        //继续回到源码，我们看到源码调用的那个方法我们是不是可以直接拿出来用就好了
        int [] copy5 = new int [array.length];//先初始化你的拷贝数组
        System.arraycopy(array,0,copy5,0,array.length);//代码可以理解为从array原数组下标为0处开始拷贝
        //拷贝到你新定义的copy5拷贝数组下标为0处，拷贝原数组长度那么长
        System.out.print("拷贝后的数组: " + Arrays.toString(copy5));
        System.out.println();
        System.out.println("-------------");
        //由于源码是C/C++写的，我们看不到具体实现方法，一般来说，native类型底层就是这个，调用后是在本地方法栈上进行的
        //那这样写和你原调用copyOf那么些有什么区别吗？区别不大，但硬要说native效率高一点，总的来说没啥差别，可忽略不计

        //拷贝数组，你可以进行扩容操作
        int [] copy6 = Arrays.copyOf(array,array.length*2);
        for(int x:copy6){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");
        //你会发现扩容后的拷贝数组超出原数组范围界限的是默认初始值，此时你让原数组引用你拷贝的数组，那么其原数组也会发生扩容
        //即此时你的原数组array不再指向原来的对象，而是指向拷贝数组所指向的对象
        array = copy6;
        System.out.print("原数组变化为：");
        for(int x:array){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");

        //部分拷贝数组
        int [] copy7 = Arrays.copyOfRange(array,0,3);//请注意在Java中下标的范围一般是左闭右开区间
        //所以并不会拷贝下标是3的元素[0,3)
        for(int x:copy7){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");
        //我们转到其源码看看其底层逻辑如何，同样如果超出范围侧抛出默认初始值

        //我们再来理解深拷贝和浅拷贝，这里不好写示范代码，我们通过画图来讲

        //二分查找数组不有序，我们可以使用sort功能进行排序
        int [] array2 = {1,5,4,3,9,6};
        Arrays.sort(array2);//注意返回类型是void。无需数组类型接收，其底层原理很复杂
        for(int x:array2){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");

        //当然我们也可以对数组进行部分的排序
        int [] array3 = {1,5,4,3,9,6};
        Arrays.sort(array3,1,4);//我们可以看到对下标1到下标3的元素进行了排序，同样是左闭右开区间
        for(int x:array3){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");
    }

    public static void bubbleSortStart(int [] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j <array.length-1 ; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i]= array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortEnd (int [] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flag = false;
            for (int j = i+1; j <array.length-1-i ; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i]= array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }

    public static void main2(String[] args) {
        //接下来再深入讲解下冒泡排序
        int [] array1 = {1,3,4,8,9};//前提必须是有序的数组，具体原理画图讲解
        //bubbleSortStart(array1);
        bubbleSortEnd(array1);//通过这种方法可大大提高我们开发效率
        for(int x:array1){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");

        //对于二分查找，我们也可以使用Arrays方法中的binaryResearch
        int ret = Arrays.binarySearch(array1,3);//结果返回的是下标
        System.out.println(ret);
        System.out.println();
        System.out.println("-------------");
        int ret2 = Arrays.binarySearch(array1,50);
        System.out.println(ret2);//为什么返回的是-6呢？我们转到源码进行分析
        //我们可以看到返回的是最后一次查找的起始值（下标）+1再添负号
        System.out.println();
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        //接下来我们再讲下Arrays方法中常用的功能有哪些

        //判断两个数组是否相等
        int [] array1 = {1,2,3,4,5};
        int [] array2 = {1,2,3,4,5};
        boolean ret = Arrays.equals(array1,array2);//我们可以看到返回值是布尔类型
        System.out.println(ret);//返回true
        System.out.println();
        System.out.println("-------------");

        //填充数组的内容
        int [] array3 = new int [10];
        Arrays.fill(array3,20);
        for(int x:array3){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("-------------");
        //我们还可以进行指定范围内的填充
        int [] array4 = new int [5];
        Arrays.fill(array4,1,3,20);
        for(int x:array4){
            System.out.print(x+" ");
        }
    }

    public static void main4(String[] args) {
        //再补充下二维数组的一点知识
        int [] [] array = {{1,2},{3,4,5}};//Java中得自己确定行列数
        System.out.println(array[1][1]);//得这么打印
    }
}
