package 泛型化抽象工厂模式.电视;

public class SonyTV implements Television{
    @Override
    public void play() {
        System.out.println("SonyTV playing...");
    }
}
