package design.pattern.factory1;

/**
 * 公交车：实现车类的具体车类
 * <br>类名：Bus<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-上午8:24:19<br>
 */
public class Bus implements Car{

    @Override
    public void run() {
        System.out.println("公交车跑...");
    }

    @Override
    public void dift() {
        System.out.println("公交车漂移...不作不死！");
    }

}
