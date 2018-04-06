package design.pattern.factory;

public class FactoryB extends Factory{

    @Override
    public Product manufacture() {
        return new ProductB();
    }

}
