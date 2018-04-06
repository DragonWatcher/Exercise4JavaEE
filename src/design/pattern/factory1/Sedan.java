package design.pattern.factory1;

/**
 * 轿车：实现骑车类的具体车类
 * <br>类名：Sedan<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-上午8:24:55<br>
 */
public class Sedan implements Car{

    @Override
    public void run() {
        System.out.println("轿车跑...");
    }

    @Override
    public void dift() {
        System.out.println("轿车漂移...更轻松...");
    }

}
