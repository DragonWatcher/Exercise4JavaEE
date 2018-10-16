package 装饰器模式;

import 装饰器模式.形状及抽象.Shape;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		super.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println(decoratedShape.getClass().getSimpleName() + " Border Color: Red");
	}
}
