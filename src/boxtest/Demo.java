package boxtest;

public class Demo {

    public static void main(String[] args) {

//        StringBuffer sb = new StringBuffer("A");
        String s = "123";
        String s1 = change(s);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
    
    }
    
    public static String change(String s){
//        System.out.println(s.hashCode());
//        s = "abc";
        return s;
        
    }
}

class A {
    public int age;
}
