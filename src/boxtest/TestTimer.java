package boxtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    public static void main(String[] args) {
//        ctrlAllInGivenTime(13, 00, "on");
//        System.out.println("结束");
        System.out.println("ddd:" + null);
        Integer is = new Integer(37);
        List<String> list = new ArrayList<String>();
    }
    
    public static void ctrlAllInGivenTime(Integer hour, Integer min, String operate) {
        // 当前时间
        Long milis = System.currentTimeMillis();
        Timer timer = new Timer();// 新建Timer类
        Calendar cal = Calendar.getInstance();
        // 每天定点执行
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, 0);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long period = 5 * 1000; 
        // (System.currentTimeMillis() < cal.getTimeInMillis()) ? cal.getTime() : (new Date(cal.getTimeInMillis() + period))
        timer.schedule(new TimerTask() {// 每天执行输出时间
            @Override
            public void run() {
                if (System.currentTimeMillis() < cal.getTimeInMillis()) {
                    System.out.println("操作是：" + operate);
                }else{
                    System.out.println("不执行任何操作。");
                }
            }
        }, period);
    }
}
