package java8timeapi;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeApi {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("时间：" + date);
//        System.out.println("年：" + date.getYear());
//        System.out.println("月：" + date.getMonth().getValue());
//        System.out.println("日：" + date.getDayOfMonth());
//        System.out.println("星期：" + date.getDayOfWeek().getValue());
//        System.out.println("时：" + date.getHour());
//        System.out.println("分：" + date.getMinute());
//        System.out.println("秒：" + date.getSecond());
        System.out.println(date.getYear() / 100);
        System.out.println(date.getYear() - (date.getYear() / 100 * 100));
        
        
        
                
    }

}
