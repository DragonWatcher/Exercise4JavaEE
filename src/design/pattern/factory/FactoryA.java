package design.pattern.factory;

public class FactoryA extends Factory{

    @Override
    public Product manufacture() {
        
        return new ProductA();
    }

}
