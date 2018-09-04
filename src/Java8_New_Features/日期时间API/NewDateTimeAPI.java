package Java8_New_Features.日期时间API;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewDateTimeAPI {

    public static void main(String[] args) {
        NewDateTimeAPI timeApi = new NewDateTimeAPI();
        timeApi.testLocalDateTime();
    }

    public void testLocalDateTime() {
        // 三个LocalXXX类：LocalDate、LocalTime、LocalDateTime
        System.out.println("============Class Summary============");
        System.out.println("--------------------LocalDate-----------------");
        LocalDate date = LocalDate.now();
        System.out.println("LocalDate.now() = " + date);
        System.out.println("今天是星期几  = "+date.getDayOfWeek());
        // 获取当前时间（时分秒.毫秒）
        System.out.println("-------------------LocalTime------------------");
        LocalTime nowTime = LocalTime.now();
        System.out.println("LocalTime.now() = " + nowTime);
        System.out.println("当前时 = " + nowTime.getHour() + ",当前分 = " + nowTime.getMinute() + ", 当前秒 = " + nowTime.getSecond());
        // 获取当前的日期时间
        System.out.println("--------------------LocalDateTime-----------------");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime.now() = " + now);
        System.out.println("注意：LocalDateTime中包含了两个final变量：LocalDate 和 LocalTime，对LocalDateTime的操作，是一种对前两者操作的封装");
        System.out.println("-----------指定日期生成LocalDateTime-----------");
        System.out.println("-----------①数字指定-----------");
        LocalDateTime nationalDay = LocalDateTime.of(2018, Month.OCTOBER, 1, 14, 30);
        System.out.println("LocalDateTime.of(2018, Month.OCTOBER, 1, 14, 30) = " + nationalDay);
        System.out.println("-----------①字符串指定-----------");
        String nationalDayStr = "2018-10-01 14:30:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = now.format(formatter);
        System.out.println("日期格式化 " + nowStr);
        System.out.println("LocalDateTime.parse(\"2018-10-01 14:30:30\", formatter) = " + LocalDateTime.parse(nationalDayStr, formatter));
        System.out.println("------------------获取指定时间的相关信息--------------");
        System.out.println("nationalDay.getDayOfWeek() = " + nationalDay.getDayOfWeek() + ";nationalDay.getDayOfWeek().getValue() = " + nationalDay.getDayOfWeek().getValue());
        System.out.println("nationalDay.getLong(ChronoField.MINUTE_OF_HOUR)  = " + nationalDay.getLong(ChronoField.MINUTE_OF_HOUR));
        System.out.println("------------------比较两个时间的相差天数（举一反三:相差分钟，相差小时...）-----------------");
        System.out.println("ChronoUnit.MILLIS.between(now, nationalDay) = " + ChronoUnit.DAYS.between(now, nationalDay));
        
        System.out.println("-----------比较两个LocalDateTime时间前后-----------");
        boolean nowIsAfter = LocalDateTime.now().isAfter(nationalDay);
        System.out.println("****" + nowIsAfter);
        System.out.println("now.isBefore(nationalDay) = " + now.isBefore(nationalDay));
        // 获取当前年
        System.out.println("--------------------Year-----------------");
        Year year = Year.now();
        System.out.println("Year.now() = " + year);
        // 获取当前年-月
        System.out.println("--------------------YearMonth-----------------");
        YearMonth ym = YearMonth.now();
        System.out.println("YearMonth.now() = " + ym);
        // 获取当前月-日
        System.out.println("-------------------MonthDay------------------");
        MonthDay monthDay = MonthDay.now();
        System.out.println("MonthDay.now() = " + monthDay);
        
        System.out.println("============Enum Summary============");
        
        DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
        System.out.println("DayOfWeek.TUESDAY = " + dayOfWeek);
        
        Month month = Month.SEPTEMBER;
        System.out.println("Month.SEPTEMBER = " + month);
        
        ZoneId localZone = ZoneId.systemDefault();
        System.out.println(localZone);
        System.out.println(localZone.getRules());
    }
}
