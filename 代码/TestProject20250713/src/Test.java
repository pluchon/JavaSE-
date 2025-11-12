import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * @author pluchon
 * @create 2025-07-13-13:26
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main1(String[] args) {
        LocalDate date1 = LocalDate.of(2012, 9, 30);
        LocalDate date2 = LocalDate.of(2025, 7, 13);
        LocalDate date3 = LocalDate.of(2025,7,13);
        boolean ret = date1.isAfter(date2);
        System.out.println("判断date1是否在date2之后："+ret);
        boolean ret2 = date1.isBefore(date2);
        System.out.println("判断date1是否在date2之前："+ret2);
        boolean ret3 = date2.isEqual(date3);
        System.out.println("判断date2是否与date3同一天："+ret3);
        boolean ret4 = date1.isLeapYear();
        System.out.println(date1+"是否是闰年："+ret4);
    }

    public static void main2(String[] args) {
        LocalDate date1 = LocalDate.of(2025,7,13);
        int ret1 = date1.lengthOfMonth();
        int ret2 = date1.lengthOfYear();
        System.out.println(date1+"月份长度和年份长度是"+ret1+" "+ret2);
    }

    public static void main3(String[] args) {
        LocalDate date1 = LocalDate.of(2025,7,13);
        String str = date1.toString();
        System.out.println(str);
    }

    public static void main4(String[] args) {
        LocalDate localDate = LocalDate.now();//2025-7-13
        //获取下周五
        LocalDate nextFriday = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        //获取下周一
        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextFriday+" "+nextMonday);
    }

    public static void main5(String[] args) {
        LocalDate localDate = LocalDate.of(2025,7,13).with(ChronoField.MONTH_OF_YEAR,12);
        System.out.println(localDate);
    }

    public static void main6(String[] args) {
        LocalDate localDate = LocalDate.parse("2025-07-13").withDayOfMonth(15);
        System.out.println(localDate);
    }

    public static void main7(String[] args) {
        LocalDate localDate = LocalDate.of(2025,1,1).withDayOfYear(150);
        System.out.println(localDate);
    }

    public static void main8(String[] args) {
        LocalDate localDate = LocalDate.parse("2025-07-31").withMonth(9);
        System.out.println(localDate);
    }

    public static void main9(String[] args) {
        LocalDate localDate = LocalDate.parse("2024-02-29").withYear(2023);
        System.out.println(localDate);
    }

    //讲BigDecimal类
    public static void main10(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(3.14);
        BigDecimal bigDecimal1 = new BigDecimal("3.14");
        System.out.println(bigDecimal+"\n"+bigDecimal1);
    }

    public static void main11(String[] args) {
        Long max = Long.MAX_VALUE;
        BigDecimal bigDecimal = new BigDecimal(max);
        BigDecimal bigDecimal1 = new BigDecimal("9223372036854775808");
        System.out.println("最大长整型"+bigDecimal+"\n最大长整型数字加一"+bigDecimal1);
    }

    public static void main12(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("12");
        BigDecimal bigDecimal2 = new BigDecimal("40");
        BigDecimal bigDecimal3 = new BigDecimal("10.5");
        BigDecimal ret = bigDecimal1.add(bigDecimal2);
        BigDecimal ret2 = bigDecimal1.subtract(bigDecimal2);
        BigDecimal ret3 = bigDecimal1.multiply(bigDecimal2);
        BigDecimal ret4 = bigDecimal1.add(bigDecimal3);
        BigDecimal ret5 = bigDecimal1.subtract(bigDecimal3);
        BigDecimal ret6 = bigDecimal1.multiply(bigDecimal3);
        System.out.println("加："+ret);
        System.out.println("减："+ret2);
        System.out.println("乘："+ret3);
        System.out.println("不同类型加："+ret4);
        System.out.println("不同类型减："+ret5);
        System.out.println("不同类型乘："+ret6);
        System.out.println("====请类比一般的浮点计算====");
        double num3 = 10.25;
        double num4 = 10.55;
        double ret11 = num3+num4;
        System.out.println(+ret11);
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("3.5");
        BigDecimal bigDecimal1 = new BigDecimal("0.5");
        BigDecimal bigDecimal2 = new BigDecimal("1.1");
        BigDecimal ret1 = bigDecimal.divide(bigDecimal1);
        //BigDecimal ret2 = bigDecimal.divide(bigDecimal2);
        System.out.println("正常除法："+ret1);
        //System.out.println("无限循环小数除法："+ret2);

        System.out.println("==================");
        BigDecimal result = bigDecimal.divide(bigDecimal2,2,RoundingMode.HALF_UP);//四舍五入法
        BigDecimal result2 = bigDecimal.divide(bigDecimal2,2,RoundingMode.HALF_EVEN);//银行家舍入
        BigDecimal result3 = bigDecimal.divide(bigDecimal2,2,RoundingMode.DOWN);//向0舍入
        BigDecimal result4 = bigDecimal.divide(bigDecimal2,2,RoundingMode.UP);//远离0舍入
        BigDecimal result5 = bigDecimal.divide(bigDecimal2,2,RoundingMode.CEILING);//向正无穷舍入
        BigDecimal result6 = bigDecimal.divide(bigDecimal2,2,RoundingMode.FLOOR);//向负无穷舍入
        BigDecimal result7 = bigDecimal.divide(bigDecimal2,2,RoundingMode.DOWN);//五舍六入，少用
        //BigDecimal result8 = bigDecimal.divide(bigDecimal2,2,RoundingMode.UNNECESSARY);//禁止舍入
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
    }
}