package 装饰器模式;

import 装饰器模式.形状及抽象.Circle;
import 装饰器模式.形状及抽象.Rectangle;
import 装饰器模式.形状及抽象.Shape;

public class DecoratorPatternDemo {

	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal border : ");
		circle.draw();

		System.out.println("\nCircle with red border : ");
		redCircle.draw();

		System.out.println("\nRectangle with red border : ");
		redRectangle.draw();
	}
}
