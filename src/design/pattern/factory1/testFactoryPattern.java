package design.pattern.factory1;

public class testFactoryPattern {

    public static void main(String[] args) {
        Car bus = CarFactory.getCar(Bus.class);
        bus.run();
        bus.dift();
        Car truck = CarFactory.getCar(Truck.class);
        truck.run();
        truck.dift();
        Car sedan = CarFactory.getCar(Sedan.class);
        sedan.run();
        sedan.dift();
    }
}
