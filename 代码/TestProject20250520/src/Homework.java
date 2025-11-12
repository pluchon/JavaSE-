import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-05-20-17:23
 * 作者代码水平一般，难免难看，请见谅
 */

public class Homework {
    //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2
    //并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static int[] transform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        return array;
    }

    public static void main1(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] ret = transform(array1);
        String ret2 = Arrays.toString(array1);
        System.out.println(ret2);
    }

    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    //如数组：[1,2,3,4,5,6]
    //调整后可能是：[1, 5, 3, 4, 2, 6]
    public static void funcation(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] % 2 == 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            //else{
            //    continue;
            //}
            //上面这个代码continue会导致无法更新i和j的值
            i++;
            j--;
        }
    }

    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        funcation(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void findArr(int[] array, int find) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//每次循环更新中间值
            if (array[mid] > find) {
                right = mid - 1;
            } else if (array[mid] < find) {
                left = mid + 1;
            } else {
                System.out.println("找到了，下标是：" + mid);
                break;
            }
        }
        if (left > right) {
            System.out.println("未找到");
        }
    }

    public static void main3(String[] args) {
        //给定一个有序整型数组, 实现二分查找，假设是升序
        int[] array = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        findArr(array, input);
    }

    public static void bubbleSort(int[] array) {
        int flag = 1;//假设表明是有序数组
        for (int i = 0; i < array.length; i++) {//一次内部比较
            for (int j = 0; j < array.length - 1 - i; j++) {//此次内部比较的内部，只需要比较后面剩下的元素即可，因此终止条件要变化
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 0;//说明发生了交换
                }
            }
            if (flag == 1) {
                break;//这一次如果未发生交换我们直接跳出循环，这是针对数字内部分元素有序
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main4(String[] args) {
        //给定一个整型数组, 实现冒泡排序(升序排序)，以逆序变成升序为例
        int[] array = {6, 5, 4, 1, 2, 3, 0};//博客中可以画图讲讲每一步原理
        bubbleSort(array);
    }

    public static void addNum(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++) {//只需要便利到倒数第一个元素之前的那个元素
            for (int j = i; j < array.length; j++) {//防止越界
                if (array[i] + array[j] == target) {
                    System.out.println("下标是[" + i + "," + j + "]");
                    return;//跳出多层循环
                }
            }
        }
    }

    public static void main5(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
        //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        //你可以按任意顺序返回答案。
        //示例 1：
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int input = sc.nextInt();//输入数组长度
        int[] arr = new int[input];//初始化数组大小成你输入数字大小
        System.out.print("请初始化你的数组：");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("请输入你想求的和：");
        int target = sc.nextInt();
        addNum(arr, target);
    }

    public static int timeOneNum(int[] array) {
        int single = 0;
        for (int num : array) {
            single ^= num;//4⊕1⊕2⊕1⊕2=4⊕(1⊕1)⊕(2⊕2)=4⊕0⊕0=4，
            //每个出现两次的元素，会被异或两次，结果为0
            //剩下的就是那个只出现一次的元素x
        }
        return single;
    }

    public static void main6(String[] args) {
        //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int input = sc.nextInt();//输入数组长度
        int[] arr = new int[input];//初始化数组大小成你输入数字大小
        System.out.print("请初始化你的数组：");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        int ret = timeOneNum(arr);
        System.out.println("结果是："+ret);
    }

    public static void issodd(int[] array) {
        boolean flag = false;//假设不存在三个连续奇数
        int left = 0;
        int right = array.length - 1;
        for (int i = 0; i < array.length - 2; i++) {
            if ((array[i] % 2 == 1) && (array[i + 1] % 2 == 1) && (array[i + 2] % 2 == 1)) {//要用括号括起来，各个小部分也是
                flag = true;
                System.out.println(flag);
                return;
            }
        }
        System.out.println(flag);
    }

    public static void main7(String[] args) {
        //存在连续三个奇数的数组
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int input = sc.nextInt();//输入数组长度
        int[] arr = new int[input];//初始化数组大小成你输入数字大小
        System.out.print("请初始化你的数组：");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        issodd(arr);
    }

    public static void main8(String[] args) {
        //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
        //输入：[3,2,3]
        //输出：3
        //输入：[2,2,1,1,1,2,2]
        //输出：2
        //我们可以先排序，再取中间元素
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int input = sc.nextInt();//输入数组长度
        int[] arr = new int[input];//初始化数组大小成你输入数字大小
        System.out.print("请初始化你的数组：");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);//如果不这么写，需要使用到投票算法，这个已经超出了我的接受范围，所以就用内置的方法
        int mid = arr.length/2;
        System.out.println("结果是："+arr[mid]);
    }
}