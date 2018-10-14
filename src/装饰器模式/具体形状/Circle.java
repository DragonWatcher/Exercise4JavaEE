package 装饰器模式.具体形状;

import 装饰器模式.Shape;

public class Circle implements Shape{
	@Override
	public void draw() {
		System.out.println("Shape : Circle");
	}
}
