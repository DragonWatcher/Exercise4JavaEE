package boxtest;

public class Demo {

    public static void main(String[] args) {
//        A a = new A();
//        System.out.println(a.age);// 0 
//        change(a);
//        System.out.println(a.age);// 10 Wrapper类A将age进行封装
        System.out.println("jvm 实现版本：\t" + System.getProperty("java.vm.version"));
        System.out.println("jvm 规范版本：\t" + System.getProperty("java.vm.specification.version"));
    }
    
    public static void change(A a){
        String s = "qqq";
        a.age = 10;
    }
}

class A {
    public int age;
}
