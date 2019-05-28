package 编程面试题;

public class 换位算法 {
	
	public static void main(String[] args) {
		/* 1、加减换位法*/
		int a = 10;
		int b = 8;
		System.out.println("a = " + a + ", b = " + b);
		a = a + b; // 18
		b = a - b; // 10
		a = a - b; // 8
		System.out.println("a = " + a + ", b = " + b);
		System.out.println("---------------");
		
		/* 2、异或换位法*/
		int x = 10;
		int y = 8;
		System.out.println("x = " + x + ", y = " + y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x = " + x + ", y = " + y);
	}

}
