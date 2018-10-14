package 装饰器模式.形状及抽象;

public class Rectangle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Shape : Rectangle");
	}
}
