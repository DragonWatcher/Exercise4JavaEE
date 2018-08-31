package test_6_17;

import java.time.LocalDateTime;

public class Java_8_datetime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yestoday = now.minusDays(2);
        try {
            assert(2 == 1) : "败！";
        } catch (Exception e) {
            System.out.println("catch");
        }
        
        System.out.println(yestoday.equals(now));
        
    }

}
