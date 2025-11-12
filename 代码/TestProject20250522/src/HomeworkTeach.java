import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-05-22-10:17
 * 作者代码水平一般，难免难看，请见谅
 */
public class HomeworkTeach {
    public static int [] change (int [] array1){
        int [] copy = new int [array1.length];
        for (int i = 0; i < array1.length; i++) {
            copy[i] = array1[i]*2;
        }
        return copy;//返回拷贝后的数组
    }

    public static void main1(String[] args) {
        //改变原数组的值，这里有两种方案，第一个方案之前作业已经写到了，这里我给出不改变原数组的值的方案
        int [] array1 = {1,2,3,4};
        int [] ret = change(array1);
        System.out.println(Arrays.toString(array1));
        System.out.print(Arrays.toString(ret));
        //[1, 2, 3, 4] [2, 4, 6, 8] 可以看到原数组的值没有发生改变
        System.out.println();
        System.out.println("-------------");

        //奇数位在偶数位之前
        int [] array2 = {5,6,7,8,9};
        int [] array3 = {1,3,5,7,9};//如果全是奇数，更能直观的感受到数组越界，因为一直是奇数，i一直加，最后越界
        int i = 0;
        int j = array2.length-1;
        while(i<j){
            while(i<j&&array2[i] %2 != 0){
                i++;
            }
            while(i<j&&array2[j] %2 == 0){
                j--;
            }
            int temp = array2[i];
            array2[i]= array2[j];
            array2[j] = temp;
        }
        System.out.print(Arrays.toString(array2));
        System.out.println();
        System.out.println("-------------");
        //我们先理解代码原理，假如i下标对应的是奇数，满足奇数在前格式，不用排序，此时i++
        //同时j如果是偶数，满足偶数在后格式，不用排序，此时j--
        //因此你不用担心假如i和j下标对应的都是奇数或者是对应的都是偶数怎么办，不会发生那种情况
        //只有i下标对应的是偶数，j下标对应的是奇数，才会发生交换
        //我们可以看到代码中有非常关键的一步i<j，假如不这么写，i加到最后会产生越界

        //求两数之和，这里只讲我作业中的问题，对于第二层循环，j要从i的下一位开始
        //比如：[2,4,8,16]，我要找的两数之和是8，如果是j=i写法，会默认4+4也算，产生歧义

        //出现一次数字
        //使用异或方法，出现两次的数字会被异或两次，最终为0，而出现一次的“0^数字=数字”，比如：4^1^2^1^2=4^(1^1)^(2^2)=4^0=4

        //出现n/2次以上的数字，先使用sort排序，再取中间元素即可

        //存在三个连续的奇数
        //定义一个奇数的计数器，遇到奇数++一次，遇到偶数直接归零，直到计数器加到三说明存在，返回true
        //如果遍历完都没有返回true，说明就不存在
        int [] array4 = {1,2,4,5,7,9};
        int count = 0;
        for (int k = 0; k < array4.length; k++) {
            if(array4[k] %2 != 0){
                count++;
            }else{
                count = 0;
            }
        }
        if(count>=3){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
