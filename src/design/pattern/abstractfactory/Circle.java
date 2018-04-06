package design.pattern.abstractfactory;
/**
 * 圆形类
 * <br>类名：Circle<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:03:43<br>
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle drawing...");
    }
}
