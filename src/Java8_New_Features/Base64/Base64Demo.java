package Java8_New_Features.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        try {
            String encodedUrl = Base64.getUrlEncoder().encodeToString("/test/base64?name=威尔·史密斯".getBytes("UTF-8"));
            System.out.println(encodedUrl);
            String decodedUrl = new String(Base64.getUrlDecoder().decode(encodedUrl));
            System.out.println(decodedUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
