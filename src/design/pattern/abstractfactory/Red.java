package design.pattern.abstractfactory;
/**
 * 红色类
 * <br>类名：Red<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:04:23<br>
 */
public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Red filling....");
    }
}
