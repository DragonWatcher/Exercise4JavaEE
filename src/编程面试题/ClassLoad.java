package 编程面试题;
/**
 * https://blog.csdn.net/u014745069/article/details/82655339
 * 类内部成员初始化顺序
 * <br>类名：Box<br>
 * 作者： mht<br>
 * 日期： 2018年9月12日-上午7:38:02<br>
 */
class A {
    private static int numA;
    private int numA2;
    
    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }
    
    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }
 
    public A() {
        System.out.println("A的构造器");
    }
    
    public A(int n) {
        System.out.println("A的有参构造");
        this.numA2 = n;
    }
}
 
class B extends A {
    private static int numB;
    private int numB2;
 
    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }
    
    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }
 
    public B() {
        System.out.println("B的构造器");
    }
    
    public B(int n) {
        System.out.println("B的有参构造");
        this.numB2 = n;
    }
}
 
public class ClassLoad {
    public static void main(String[] args) {
        A ab = new B();
        System.out.println("---");
        ab = new B();
        System.out.println("---");
        B anotherB = new B(1);// 思考有参构造的输出结果
    }
}
