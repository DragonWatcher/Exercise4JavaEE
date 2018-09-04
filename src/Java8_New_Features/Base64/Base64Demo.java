package Java8_New_Features.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        try {
            String encoded = Base64.getEncoder().encodeToString("Will Smith = 威尔·史密斯".getBytes("UTF-8"));
            System.out.println(encoded);
            String decoded = new String(Base64.getDecoder().decode(encoded));
            System.out.println(decoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
