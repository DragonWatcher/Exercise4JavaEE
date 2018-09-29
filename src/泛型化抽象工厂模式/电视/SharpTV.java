package 泛型化抽象工厂模式.电视;

public class SharpTV implements Television{
    @Override
    public void play() {
        System.out.println("SharpTV playing...");
    }
}
