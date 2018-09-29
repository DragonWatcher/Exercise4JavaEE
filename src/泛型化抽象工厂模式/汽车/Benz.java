package 泛型化抽象工厂模式.汽车;

public class Benz implements Car{
    @Override
    public void run() {
        System.out.println("Benz running...");
    }
}
