package 装饰器模式.具体形状;

import 装饰器模式.Shape;

public class Rectangle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Shape : Rectangle");
	}
}
