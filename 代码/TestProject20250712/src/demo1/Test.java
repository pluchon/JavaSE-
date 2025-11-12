package demo1;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

/**
 * @author pluchon
 * @create 2025-07-12-15:59
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main1(String[] args) {
        Date date = new Date(100,1,1);
        System.out.println(date);
    }

    public static void main2(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2000,1,1,10,10,10);
        System.out.println(localDateTime1);
    }

    public static void main3(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int month = localDateTime.getMonth().getValue();
        System.out.println(year+" "+month);
    }

    public static void main4(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime ret = localDateTime.plusDays(1);
        LocalDateTime rets = localDateTime.minusDays(1);
        System.out.println(ret+" "+rets);
    }

    public static void main5(String[] args) {
        String date = "2025-07-13 10:10:10";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date,dateTimeFormatter);
        System.out.println(localDateTime);
    }

    public static void main6(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE a"));
        System.out.println(date);
    }

    public static void main7(String[] args) {
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime firstDayOfWeek = nowDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));//当前日期或之前的指定星期几
        LocalDateTime thirdDayOfWeek = nowDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
        LocalDateTime firstDyaOfWeekPlus = nowDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));//当前日期或之后的指定星期几
        LocalDateTime thirdDyaOfWeekPlus = nowDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        System.out.println(firstDayOfWeek+" "+thirdDayOfWeek);
        System.out.println("==========================分割线");
        System.out.println(firstDyaOfWeekPlus+" "+thirdDyaOfWeekPlus);
    }

    public static void main(String[] args) {
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime firstDayOfMonth = nowDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastDayOfMonth = nowDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(firstDayOfMonth+" "+lastDayOfMonth);
    }
}
