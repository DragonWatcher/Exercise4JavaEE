package boxtest;

public class Demo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("A");
        change(sb);
        System.out.println(sb);
    
    }
    
    public static void change(StringBuffer sb){
        sb.append("B");
    }
}

class A {
    public int age;
}
