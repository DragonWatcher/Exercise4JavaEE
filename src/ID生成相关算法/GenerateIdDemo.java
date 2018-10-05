package ID生成相关算法;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GenerateIdDemo {
    public static void main(String[] args) {
        String uuid = getUUID();
        System.out.println(uuid);
        Long now;
        for (int i = 0; i < 100; i++) {
            now = System.currentTimeMillis();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(now));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        System.out.println("0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000");
        return uuid.replaceAll("-", "");
    }
}
