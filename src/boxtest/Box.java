package boxtest;

class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}

public class Box {

    public static void main(String[] args) {
        // String转int
        int num = Integer.parseInt("100");
        // String转double或float
        double num2 = Double.parseDouble("100.5");
        // String转char
        char ch = "中".charAt(0);
        // String转boolean
        boolean flag = Boolean.parseBoolean("true");
        char[] chs = {'一','个','叉','数','组'};
//        String myName = new String(new char[1]);
//        System.out.println(myName);
        System.out.println(new String(new char[0]).equals(""));
    }
}
