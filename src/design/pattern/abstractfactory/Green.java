package design.pattern.abstractfactory;
/**
 * 绿色类
 * <br>类名：Green<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:05:08<br>
 */
public class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Green filling...");
    }
}
