package design.pattern.factory1;

/**
 * 卡车类：实现车接口的具体车类
 * <br>类名：Truck<br>
 * 作者： mht<br>
 * 日期： 2018年3月20日-下午11:45:03<br>
 */
public class Truck implements Car{

    @Override
    public void run() {
        System.out.println("卡车跑...");
    }

    @Override
    public void dift() {
        System.out.println("卡车漂移...不作不死...");
    }

}
