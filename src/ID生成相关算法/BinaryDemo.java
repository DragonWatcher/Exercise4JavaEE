package ID生成相关算法;

public class BinaryDemo {

    public static void main(String[] args) {
        Long num = 1L;
        Long year = (num << 41)/ (1000L * 60 * 60 * 24 * 365);
        System.out.println(year);
        Long num1 = 1L << 10;
        System.out.println(1L << 12);
        
        
        
        
    }

}
