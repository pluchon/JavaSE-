package BabyGrow;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author pluchon
 * @create 2025-07-07-09:46
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void printGameRules() {//游戏规则说明
        System.out.println("============= 婴儿成长模拟器 - 游戏规则 =============");
        System.out.println();
        System.out.println("🌟 游戏目标：");
        System.out.println("  培养一个健康的婴儿，通过合理选择行为促进其成长");
        System.out.println("  最终目标是让婴儿成长为12岁的健康儿童");
        System.out.println();
        System.out.println("📊 核心属性：");
        System.out.println("  1. 年龄(age): 以岁为单位，0-12岁");
        System.out.println("  2. 月份(month): 每满12个月自动增加1岁");
        System.out.println("  3. 智力(wisdom): 影响学习能力和成长速度");
        System.out.println("  4. 身高(high): 反映身体发育状况");
        System.out.println("  5. 体重(weight): 反映营养健康状况");
        System.out.println("  6. 饥饿值(hungry): 需通过进食维持");
        System.out.println("  7. 疲劳值(tire): 需通过睡眠恢复");
        System.out.println("  8. 神秘点(mystery): 用于特殊抽奖");
        System.out.println();
        System.out.println("🎮 主要行为：");
        System.out.println("  1. 进食(eat): 增加饱腹感，但可能增加体重");
        System.out.println("  2. 睡觉(sleep): 恢复精力，降低疲劳值");
        System.out.println("  3. 运动(sport): 消耗能量，控制体重增长");
        System.out.println("  4. 学习(study): 提升智力，但增加疲劳");
        System.out.println("  5. 玩游戏(play): 降低疲劳，但可能影响学习");
        System.out.println();
        System.out.println("✨ 特殊机制：");
        System.out.println("  1. 月份积累：");
        System.out.println("     - 每积累12个月自动增加1岁");
        System.out.println("     - 每次成长获得10-15点智力奖励");
        System.out.println("  2. 智力兑换：");
        System.out.println("     - 可用智力兑换成长月份或身高");
        System.out.println("     - 兑换比例：8智力=2个月，16智力=4个月");
        System.out.println("  3. 抽奖系统：");
        System.out.println("     - 低风险抽奖：消耗2点智力/神秘点");
        System.out.println("     - 高风险抽奖：消耗5点智力/神秘点");
        System.out.println("     - 可能获得月份、智力或神秘点奖励");
        System.out.println();
        System.out.println("🏆 成长阶段：");
        System.out.println("  0-1岁: 基础生存能力发展");
        System.out.println("  1-3岁: 语言和运动能力爆发");
        System.out.println("  3-6岁: 逻辑思维和社交能力发展");
        System.out.println("  6-12岁: 抽象思维和自主学习能力形成");
        System.out.println();
        System.out.println("⚖️ 平衡提示：");
        System.out.println("  1. 过度进食会导致肥胖，影响运动能力");
        System.out.println("  2. 长期疲劳会降低学习效率");
        System.out.println("  3. 智力是稀缺资源，请合理分配");
        System.out.println("  4. 每月随机事件可能带来意外收获");
        System.out.println();
        System.out.println("🚀 进阶技巧：");
        System.out.println("  1. 合理利用抽奖系统以小博大");
        System.out.println("  2. 注意年龄阶段解锁的特殊能力");
        System.out.println();
        System.out.println("==============================================");
        System.out.println("  愿你的小天使健康快乐地成长！");
        System.out.println("==============================================");
    }

    // 单位换算常量（1公斤=2斤）
    private static final double KG_TO_JIN = 2.0;
    private static final DecimalFormat df = new DecimalFormat("#.#");

    //身高（单位：厘米）
    private static final double BOY_MIN_CM = 46.1;
    private static final double BOY_MAX_CM = 54.9;
    private static final double GIRL_MIN_CM = 45.4;
    private static final double GIRL_MAX_CM = 54.2;

    public static double generateBoyHeight() {//男儿
        System.out.println("接下来开始随机抽取身高");
        return formatHeight(
                ThreadLocalRandom.current().nextDouble(BOY_MIN_CM, BOY_MAX_CM)
        );
    }

    public static double generateGirlHeight() {//女儿
        System.out.println("接下来开始随机抽取身高");
        return formatHeight(
                ThreadLocalRandom.current().nextDouble(GIRL_MIN_CM, GIRL_MAX_CM)
        );
    }

    private static double formatHeight(double height) {//格式化身高，保留一位小数
        return Double.parseDouble(df.format(height));
    }

    public static double weightChouQuBoy(){//男孩子
        System.out.println("接下来开始随机抽取体重");
        double minKg = 2.5;
        double maxKg = 4.3;
        // 转换为斤并保留1位小数
        double weightJin = ThreadLocalRandom.current().nextDouble(minKg * KG_TO_JIN, maxKg * KG_TO_JIN);
        return Double.parseDouble(df.format(weightJin));
    }

    public static double weightChouQuGirl(){
        System.out.println("接下来开始随机抽取体重");
        double minKg = 2.4;
        double maxKg = 4.2;
        double weightJin = ThreadLocalRandom.current().nextDouble(minKg * KG_TO_JIN, maxKg * KG_TO_JIN);
        return Double.parseDouble(df.format(weightJin));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("婴儿成长模拟器要开始了，请问是否先查看规则？\n1.查看\n2.老子不看\n");
        int choice = sc.nextInt();
        if(choice == 1){
            printGameRules();
        }
        System.out.println("请输入你的小可爱姓名：");
        String name = sc.next();
        System.out.println("请输入你想要男孩子还是女孩子（输入男/女）：");
        String gender = sc.next();
        double weight = 0.0;
        double height = 0.0;
        if (Objects.equals(gender, "男")) {
            weight += weightChouQuBoy();
            height += generateBoyHeight();
        } else if (Objects.equals(gender, "女")) {
            weight += weightChouQuGirl();
            height += generateGirlHeight();
        } else {
            System.out.println("输入错误");
        }
        if (Objects.equals(gender, "男") || (Objects.equals(gender, "女"))) {//验证
            Baby baby = new Baby(weight, name, height, 0, gender);
            baby.display();
            while (true) {
                System.out.println("请选择行为\n1.进食\n2.睡觉\n3.运动\n4.玩游戏\n5.成长\n6.展示面板\n7.退出");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        baby.eat();
                        break;
                    case 2:
                        baby.sleep();
                        break;
                    case 3:
                        baby.sport();
                        break;
                    case 4:
                        baby.game();
                        break;
                    case 5:
                        baby.time();
                    case 6:
                        baby.display();
                    default:
                        break;
                }
                System.out.println("是否继续游戏？\n1.继续\n2.退出");
                int inputAgain = sc.nextInt();
                if (inputAgain != 1) {
                    break;
                }
            }
            System.out.println(baby.name + "的基础面板：");
            baby.display();
        }else{
            System.out.println("您输入了错误的性别结果，程序结束");
        }
    }
}

//下一步完善：饥饿值与疲劳值范围对应的机制，
