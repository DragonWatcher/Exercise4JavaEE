package design.pattern.abstractfactory;
/**
 * 蓝色类
 * <br>类名：Blue<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:05:30<br>
 */
public class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Blue filling...");
    }
}
