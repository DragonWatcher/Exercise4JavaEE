package boxtest;

public class demo01 {
    public static void main(String[] args) {
        String s1 = new String("ja") + new String("va");
        s1.intern();
        String s2 = "java";
        System.out.println(s1 == s2);
    }

}
