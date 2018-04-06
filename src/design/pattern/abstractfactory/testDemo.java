package design.pattern.abstractfactory;

public class testDemo {
    public static void main(String[] args) {
        // 创建形状工厂
        Factory shapeFactory = FactoryProducer.getFactory(ShapeFactory.class);
        // 创建形状产品
        Shape rect = (Shape) shapeFactory.getPruduct(Rectangle.class);
        Shape square = (Shape) shapeFactory.getPruduct(Square.class);
        Shape circle = (Shape) shapeFactory.getPruduct(Circle.class);
        // 使用产品
        rect.draw();
        square.draw();
        circle.draw();

        Factory colorFactory = FactoryProducer.getFactory(ColorFactory.class);

        Color red = (Color) colorFactory.getPruduct(Red.class);
        Color green = (Color) colorFactory.getPruduct(Green.class);
        Color blue = (Color) colorFactory.getPruduct(Blue.class);

        red.fill();
        green.fill();
        blue.fill();
    }
}
