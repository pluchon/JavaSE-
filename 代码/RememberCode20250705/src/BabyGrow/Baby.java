package BabyGrow;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-07-09:33
 * 作者代码水平一般，难免难看，请见谅
 */
public class Baby extends Person implements IBaseEatable,IWalkable,IPlayGamesable,IChageTypeable {
    protected String gender;//婴儿性别
    protected double wisdom = 10.0;//智力,10.0~100.0
    protected double tire = 10.0;//疲劳值,0.0~50.0
    protected double hungry = 2.0;//饥饿值,0.0~20.0
    protected int month = 0;//时间值，用于成长
    protected double mystery;//神秘点
    protected boolean canEatVegetable = false;//用于更新吃蔬菜能力
    protected boolean canEatMeat = false;//用于更新吃肉能力
    protected boolean canPlayGames = false;//用于更新玩游戏能力
    protected boolean canRun = false;//用于更新跑步能力
    protected boolean canWalk = false;//用于更新行走能力

    public Baby(double weight, String name, double high, int age, String gender) {
        super(weight, name, high, age);
        this.gender = gender;
    }

    protected void display(){//展示面板
        System.out.println(name+"当前的信息如下\n============");
        System.out.println("姓名："+name);
        System.out.println("年龄："+age+"岁");
        System.out.println("性别："+gender);
        System.out.println("身高："+high+"cm");
        System.out.println("体重："+weight+"斤");
        System.out.println("智力："+wisdom);
        System.out.println("疲惫值："+tire);
        System.out.println("饥饿值："+hungry);
        System.out.println("年龄（月份）："+month);
        System.out.println("=================");
    }

    protected void triggerRandomEvent() {//成长随机事件
        int eventType = new Random().nextInt(3);
        switch(eventType) {
            case 0: // 遇到好老师
                month += 1;
                System.out.println("✨ " + name + "遇到好老师，额外获得1个月成长");
                break;
            case 1: // 发现新玩具
                month += 2;
                System.out.println("✨ " + name + "发现益智玩具，额外获得2个月成长");
                break;
            case 2: // 健康检查
                if(month > 0) {
                    int gain = new Random().nextInt(3);
                    month += gain;
                    System.out.println("✨ 健康检查良好，额外获得" + gain + "个月成长");
                }
                break;
        }
    }

    protected void time(){//判断是否符合成长条件
        if (month >= 12) {
            System.out.println("恭喜" + name + "长大一岁");
            month -= 12;
            age++;
            Random random = new Random();// 随机获得10~15点智力
            int randomWisdom = 10 + random.nextInt(6); // 10~15
            wisdom += randomWisdom;
            System.out.println(name + "获得了" + randomWisdom + "点智力奖励！");
            mystery += randOne();// 随机给予神秘点（保持原有逻辑）
            display();
            return;
        }
        // 新增：每月随机事件（30%概率）
        if(new Random().nextInt(100) < 30) {
            triggerRandomEvent();
        }
        System.out.println("请问选择成长类型\n1.长大一岁\n2.智力兑换\n3.成长晋升\n4.其他");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                if(month>=12){
                    System.out.println("恭喜"+name+"长大一岁");
                    month -= 12;
                    age++;
                    mystery += randOne();//随机给予神秘点
                }else{
                    System.out.println(name+"不符合条件呢，继续努力哦");
                    display();
                }
                break;
            case 2:
                System.out.println("请选择你想兑换的类型\n1.智力换成长月数\n2.智力换身高\n3.智力抽奖\n4.退出");
                int choiceAgain = sc.nextInt();
                switch(choiceAgain){
                    case 1:
                        changeMonth();
                        break;
                    case 2:
                        changeHigh();
                        break;
                    case 3:
                        changeLuck();
                        break;
                    default:
                        System.out.println("输入错误，请重新输入");
                }
            case 3:
                grow();
                break;
            default:
                break;
        }
    }

    protected void grow(){//成长晋升
        if(wisdom>=30.0&&age==0){
            System.out.println("恭喜"+name+"晋升1岁啦");
            age++;
        }else if(wisdom>=60&&age<=2){
            System.out.println("恭喜"+name+"晋升3岁啦");
            age++;
        }else if(wisdom>=70&&age==5){
            System.out.println("恭喜"+name+"晋升6岁啦");
            age++;
        }else if(wisdom>=90&&age==8){
            System.out.println("恭喜"+name+"晋升9岁啦");
            age++;
        }else{
            System.out.println("条件不符合\n------------");
            display();//打印面板
        }
    }

    @Override
    protected void eat() {
        System.out.println(name+"正在吃东西\n============");
        while(true) {
            System.out.println("请选择吃的食物\n1.喝奶粉\n2.喝白稀饭（满一岁解锁）\n3.蔬菜/肉肉\n4.不吃东西");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(age<=2) {
                        System.out.println(name + "喝奶粉成功\n============");
                        hungry += 2.0;//喝了回复饥饿值
                        weight += 2.0;//喝了加体重
                        wisdom += 1.0;//喝了增加智力
                        tire -= 4.0;//喝了增加疲劳值
                        break;
                    }else{
                        System.out.println(name+"不需要喝奶粉啦\n============");
                        continue;
                    }
                case 2:
                    if(age>1) {
                        System.out.println(name + "喝白稀饭成功\n============");
                        hungry += 5.0;
                        weight += 4.0;
                        wisdom += 3.0;
                        tire -= 5.0;
                        break;
                    }else{
                        System.out.println("当前"+name+"年龄为"+age+"岁，不满一岁,请重新选择");
                        continue;
                    }
                case 3://这里可以添加吃额外食物
                    if(age<3){
                        System.out.println(name+"年龄不够,当前为"+age+"岁");
                        continue;
                    }else {
                        if (!canEatVegetable && !canEatMeat) {//用于第一次来获得吃肉和吃蔬菜能力
                            canVegetable();
                            canMeat();
                            canEatVegetable = true;
                            canEatMeat = true;
                        }
                        System.out.println("请选择吃什么：\n1.蔬菜\n2.肉肉\n3.不吃了");
                        int choiceAgain = sc.nextInt();
                        switch (choiceAgain) {
                            case 1:
                                vegetable();
                                break;
                            case 2:
                                meat();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("非法输入，请重新选择");
                                continue;
                        }
                    }
                default:
                    break;
            }
            System.out.println("是否继续/想进食？\n1.继续/想\n2.退出进食模式\n============");
            int choiceAgain = sc.nextInt();
            display();//展示当前数据
            if(choiceAgain != 1) {//判断
                break;
            }
        }
        //新增：进食后有20%概率获得1个月
        if (new Random().nextInt(5) == 0) { // 1/5概率
            month++;
            System.out.println(name + "通过健康饮食获得额外1个月成长！");
        }
    }

    @Override
    void sleep() {
        System.out.println(name + "正在睡觉\n============");
        while (true) {
            if(age>12){
                System.out.println(name+"已经度过了儿童时期\n============");
                break;
            }
            System.out.println("请输入你的睡觉时长");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if (age < 3) {//三岁以下
                if (input > 0 && input < 6) {
                    System.out.println(name + "睡眠时间不允许，请重新输入");
                } else if (input >= 6 && input < 10) {
                    System.out.println(name + "小憩一会");
                    if (tire == 0.0) {//判断目前疲劳值
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 2.0;
                        hungry -= 3.0;
                        break;
                    }
                } else if (input >= 10 && input <= 18) {
                    System.out.println(name + "正在睡觉");
                    if (tire == 0.0) {
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 4.0;
                        hungry -= 1.0;
                        break;
                    }
                } else {//处理非法输入
                    System.out.println("非法输入，请重新输入");
                }
            } else if (age < 6) {//3~6岁
                if (input > 0 && input < 5) {
                    System.out.println("睡眠时间不允许，请重新输入");
                } else if (input >= 5 && input < 9) {
                    System.out.println(name + "小憩一会");
                    if (tire == 0.0) {//判断目前疲劳值
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 1.5;
                        hungry -= 4.0;
                        break;
                    }
                } else if (input >= 9 && input <= 14) {
                    System.out.println(name + "正在睡觉");
                    if (tire == 0.0) {
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 3.0;
                        hungry -= 2.0;
                        break;
                    }
                }
            }else if(age<=12){//6~12岁
                if(input>0&&input<4){
                    System.out.println("睡眠时间不允许，请重新输入");
                }else if(input >=4&&input <8){
                    System.out.println("小憩一会");
                    if (tire == 0.0) {//判断目前疲劳值
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 1.0;
                        hungry -= 5.0;
                        break;
                    }
                }else if(input >=8 && input <=11){
                    System.out.println(name+"正在睡觉");
                    if (tire == 0.0) {//判断目前疲劳值
                        System.out.println(name + "不需要休息了，活力满满呢");
                        break;
                    } else {
                        tire -= 2.0;
                        hungry -= 3.0;
                        break;
                    }
                }
            }else{
                System.out.println(name+"的儿童成长生涯结束");
                break;
            }
            display();//打印面板信息
            System.out.println("是否继续睡觉？\n1.是\n2.否\n===========");
            int inputAgain = sc.nextInt();
            if(inputAgain != 1){
                break;
            }
        }
        // 新增：深度睡眠奖励
        if (tire <= 5) { // 疲劳值很低时
            month += new Random().nextInt(2) + 1; // 随机1-2个月
            System.out.println(name + "深度睡眠促进发育，获得额外成长！");
        }
    }

    @Override
    protected void sport(){
        System.out.println("正在运动\n============");
        while(true){
            System.out.println("请选择你要进行的运动\n1.走路\n2.跑步\n3.其他\n4.暂不进行运动");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (age < 2) {
                        System.out.println(name + "年龄太小，无法学习走路");
                    } else {
                        if (!canWalk) {
                            canWalk();
                            canWalk = true;
                        }
                        walk();
                        break;
                    }
                case 2:
                    if(age<3){
                        System.out.println(name+"年龄太小，无法学习跑步");
                    }else {
                        if (!canRun) {
                            canRun();
                            canRun = true;
                        }
                        run();
                        break;
                    }
                case 3://这里添加额外技能特长
                    break;
                case 4:
                    break;
                default:
                    System.out.println("非法输入，请重新输入");
            }
            System.out.println("是否继续运动？\n1.是\n2.否");
            int choiceAgain = sc.nextInt();
            if(choiceAgain !=1){
                break;
            }
        }
        display();
    }

    @Override
    protected void game(){
        System.out.println(name+"正在玩游戏");
        while(true){
            System.out.println("请选择游戏：\n1.原神\n2.我的世界\n3.退出");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(age<6){
                        System.out.println(name+"还没到玩游戏的年龄呢");
                    }else {
                        if (!canPlayGames) {
                            canPlaGame();
                            canPlayGames = true;
                        }
                        yuanShen();
                        break;
                    }
                case 2:
                    if(age<6){
                        System.out.println(name+"还没到玩游戏的年龄呢");
                    }else {
                        if (!canPlayGames) {
                            canPlaGame();
                            canPlayGames = true;
                        }
                        Minecraft();
                        break;
                    }
                default:
                    break;
            }
            System.out.println("是否继续玩游戏呢？\n1.继续\n2.不了");
            int choiceAgain = sc.nextInt();
            if(choiceAgain != 1){
                break;
            }
        }
        display();
    }

    @Override
    void cry() {
        System.out.println(name+"正在哭闹");
        tire += 0.5;
    }

    @Override
    void makeVocie() {
        System.out.println(name+"正在发出声音");
    }

    @Override
    public void canVegetable() {
        System.out.println(name+"学会了吃蔬菜");
        wisdom += 2.0;
    }

    @Override
    public void canMeat() {
        System.out.println(name+"学会了吃肉肉");
        wisdom += 2.0;
    }

    @Override
    public void vegetable() {
        System.out.println(name+"在吃蔬菜");
        tire += 1.0;
        hungry += 2.0;
        wisdom += 6.0;
        weight += 1.0;
    }

    @Override
    public void meat() {
        System.out.println(name+"在吃肉肉");
        tire += 2.0;
        hungry += 5.0;
        wisdom += 2.0;
        weight += 7.0;
    }

    @Override
    public void canWalk() {
        System.out.println(name+"学会走路啦");
        wisdom += 5.0;
    }

    @Override
    public void canRun() {
        System.out.println(name+"学会奔跑啦");
        wisdom += 10.0;
    }

    @Override
    public void walk() {
        System.out.println(name+"正在走路");
        tire += 5.0;
        hungry -= 2.0;
        weight -= 1.0;
    }

    @Override
    public void run() {
        System.out.println(name+"正在奔跑");
        tire += 10.0;
        hungry -= 5.0;
        weight -= 2.5;
    }

    @Override
    public void canPlaGame() {
        System.out.println(name+"学会了玩游戏");
        wisdom += 20.0;
    }

    @Override
    public void yuanShen() {
        System.out.println(name+"在玩原神");
        tire += 10.0;
        hungry -= 0.5;
        weight -= 0.5;
    }

    @Override
    public void Minecraft() {
        System.out.println(name+"在玩我的世界");
        tire += 8.0;
        hungry -= 1.0;
        weight -= 1.0;
        wisdom += 2.0;
    }

    @Override
    public void changeMonth() {//1个月=4智力
        System.out.println("请选择你想换的月数（1~12月之间）\n1.2个月\n2.4个月\n3.6个月\n4.12个月（有优惠）\n5.30智力换随机3-6个月");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                if(wisdom>=8.0) {//检测是否符合兑换条件
                    System.out.println("需要8个智力，您目前有" + wisdom + "智力，请确认是否兑换\n1.确认\n2.退出");
                    int choiceAgain = sc.nextInt();
                    if (choiceAgain == 1) {
                        wisdom -= 8.0;
                        month += 2;
                        break;
                    }
                    break;
                }else{
                    System.out.println(name+"不符合兑换条件呢");
                    display();
                    break;
                }
            case 2:
                if(wisdom >= 16.0) {
                    System.out.println("需要16个智力，您目前有" + wisdom + "智力，请确认是否兑换\n1.确认\n2.退出");
                    int choiceAgains = sc.nextInt();
                    if (choiceAgains == 1) {
                        wisdom -= 16.0;
                        month += 4;
                        break;
                    }
                    break;
                }else{
                    System.out.println(name+"不符合兑换条件呢");
                    display();
                    break;
                }
            case 3:
                if(wisdom>=24.0) {
                    System.out.println("需要24个智力，您目前有" + wisdom + "智力，请确认是否兑换\n1.确认\n2.退出");
                    int choiceAgainss = sc.nextInt();
                    if (choiceAgainss == 1) {
                        wisdom -= 24.0;
                        month += 6;
                        break;
                    }
                    break;
                }else{
                    System.out.println(name+"不符合兑换条件呢");
                    display();
                    break;
                }
            case 4:
                if(wisdom>=40.0) {
                    System.out.println("需要40(原48)个智力，您目前有" + wisdom + "智力，请确认是否兑换\n1.确认\n2.退出");
                    int choiceAgainsss = sc.nextInt();
                    if (choiceAgainsss == 1) {
                        wisdom -= 40.0;
                        month += 12;
                        break;
                    }
                    break;
                }else{
                    System.out.println(name+"不符合兑换条件呢");
                    display();
                    break;
                }
            case 5: // 新增随机月份兑换
                if(wisdom >= 30) {
                    wisdom -= 30;
                    int randomMonths = 3 + new Random().nextInt(4); // 3-6个月
                    month += randomMonths;
                    System.out.println(name + "兑换了" + randomMonths + "个月！");
                    break;
                }else {
                    System.out.println(name+"智力点不足！");
                    break;
                }
            default:
                System.out.println("输入错误，请重新输入");
        }
    }

    @Override
    public void changeHigh() {
        System.out.println("请输入消耗的智力点（请输入0.0格式）\n"+name+"目前有"+wisdom+"智力点");
        System.out.println("1智力=0.5身高（cm）");
        Scanner sc = new Scanner(System.in);
        double input = sc.nextInt();
        wisdom -= input;
        high += input/2.0;
        display();
    }

    @Override
    public void changeLuck() {
        System.out.println("===================抽奖系统========================");
        System.out.println(name+"目前有"+wisdom+"个智力点，请选择你的抽奖类型\n1.低风险低回报\n2.高风险高回报\n3.神秘抽奖\n4.退出");
        System.out.println("关于低风险低回报和高风险高回报抽奖：单抽消耗2点智力，十连抽消耗16点（原20点）智力");
        System.out.println("关于神秘抽奖：宝宝每成长一岁随机获得8~10个神秘点，消耗2个单抽，消耗16个十连抽（原20个）");
        System.out.println("===================================================");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                lowChouJiang();
                break;
            case 2:
                highChouJiang();
                break;
            case 3:
                myMystery();
                break;
            default:
                break;
        }
    }

    protected void highChouJiang(){//高风险高回报抽奖
        System.out.println("请选择单抽/十连抽\n1.单抽\n2.十连抽");
        System.out.println("您目前有"+wisdom+"智力点");
        displayChouJiangHigh();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                if(wisdom<2){
                    System.out.println("您的智力点不足");
                    break;
                }
                int result = randTwo();
                resultChouJiangHigh(result);
                break;
            case 2:
                if(wisdom<16){
                    System.out.println("您的智力点不足");
                    break;
                }
                int counts = 0;//抽奖计数器
                while (counts < 10) {
                    int results = randTwo();
                    resultChouJiangHigh(results);
                    counts++;
                }
                break;
            default:
                System.out.println("选择错误");
                break;
        }
    }

    protected void displayChouJiangHigh(){
        System.out.println("==============================");
        System.out.println("    1.智力+5     2.智力+7");
        System.out.println("6.月数+8              3. 智力-9");
        System.out.println("    5.智力+12     4.疲劳值+6");
        System.out.println("==============================");
    }

    protected void resultChouJiangHigh(int result){
        switch(result){
            case 1:
                wisdom += 5.0;
                System.out.println("智力增加了5点");
                break;
            case 2:
                wisdom += 7.0;
                System.out.println("智力增加了7点");
                break;
            case 3:
                wisdom -= 9.0;
                System.out.println("智力减少了9点");
                break;
            case 4:
                tire += 6.0;
                System.out.println("疲劳值增加了6点");
                break;
            case 5:
                wisdom -= 12.0;
                System.out.println("智力减少了12点");
                break;
            case 6:
                month += 8;
                System.out.println("月份增加了八个月");
                break;
            default://判断随机数范围
                System.out.println("抽奖系统有误");
                break;
        }
    }

    protected void lowChouJiang(){//低风险低回报抽奖
        System.out.println("请选择单抽/十连抽\n1.单抽\n2.十连抽");
        System.out.println("您目前有"+wisdom+"智力点");
        displayChouJiangLow();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                if(wisdom<2){
                    System.out.println("您的智力点不足");
                    break;
                }
                int result = randTwo();
                resultChouJiangLow(result);
                break;
            case 2:
                if(wisdom<16){
                    System.out.println("您的智力点不足");
                    break;
                }
                int counts = 0;//抽奖计数器
                while (counts < 10) {
                    int results = randTwo();
                    resultChouJiangLow(results);
                    counts++;
                }
                break;
            default:
                System.out.println("选择错误");
                break;
        }
    }

    protected void displayChouJiangLow(){//展示低风险奖池
        System.out.println("==============================");
        System.out.println("    1.智力+2     2.智力+3");
        System.out.println("6.月数+1              3. 智力-1");
        System.out.println("    5.智力-0.5     4.疲劳值+2");
        System.out.println("==============================");
    }

    protected void resultChouJiangLow(int result){
        switch(result){
            case 1:
                wisdom += 2.0;
                System.out.println("智力增加了2点");
                break;
            case 2:
                wisdom += 3.0;
                System.out.println("智力增加了3点");
                break;
            case 3:
                wisdom -= 1.0;
                System.out.println("智力减少了1点");
                break;
            case 4:
                tire += 2.0;
                System.out.println("疲劳值增加了2点");
                break;
            case 5:
                wisdom -= 0.5;
                System.out.println("智力减少了0.5点");
                break;
            case 6:
                month += 1;
                System.out.println("月份增加了一个月");
                break;
            default://判断随机数范围
                System.out.println("抽奖系统有误");
                break;
        }
    }

    protected void myMystery(){
        System.out.println("请选择单抽/十连抽\n1.单抽\n2.十连抽");
        displayChouJiangMyMystery();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                if(mystery>=2) {
                    mystery -= 2;
                    int result = randTwo();//接受随机值
                    resultChouJiangMyMystery(result);
                    break;
                }else{
                    System.out.println(name+"目前神秘点为："+mystery+"，不符合要求");
                    break;
                }
            case 2:
                if(mystery>=16) {
                    int counts = 0;//抽奖计数器
                    while (counts < 10) {
                        int results = randTwo();
                        resultChouJiangMyMystery(results);
                        counts++;
                    }
                    break;
                }else{
                    System.out.println(name+"目前神秘点为："+mystery+"，不符合要求");
                    break;
                }
            default:
                break;
        }
    }

    protected void displayChouJiangMyMystery(){//神秘抽奖卡池
        System.out.println("==============================");
        System.out.println("    1.智力+5     2.智力+8");
        System.out.println("6.月数+8              3. 智力-4");
        System.out.println("    5.智力-2     4.饥饿度+10");
        System.out.println("==============================");
    }

    protected void resultChouJiangMyMystery(int result){//神秘抽奖卡池实行抽奖结果
        switch (result){
            case 1:
                wisdom += 5.0;
                System.out.println("智力增加了5点");
                break;
            case 2:
                wisdom += 8.0;
                System.out.println("智力增加了8点");
                break;
            case 3:
                wisdom -= 4.0;
                System.out.println("智力减少了4点");
                break;
            case 4:
                hungry += 10.0;
                System.out.println("饥饿度增加了10点");
                break;
            case 5:
                wisdom -= 2.0;
                System.out.println("智力减少了2点");
                break;
            case 6:
                month += 8;
                System.out.println("月份增加了8个月");
                break;
            default://判断随机数生成范围
                System.out.println("抽奖系统有错误，请修复");
        }
    }

    double randOne(){//对于神秘点随机数生成，仅保留一位小数
        Random random = new Random();
        double raw = 4.0 + (6.0 - 4.0) * random.nextDouble(); // 原始随机值
        double result;
        result = Math.round(raw * 10) / 10.0;
        return result;
    }

    int randTwo(){//随机生成1~6整数用于抽奖
        Random rand = new Random();
        int randNum;
        randNum = rand.nextInt(6) + 1;
        return randNum;
    }
}
