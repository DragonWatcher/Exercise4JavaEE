package design.pattern.abstractfactory;
/**
 * 矩形类
 * <br>类名：Rectangle<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:02:26<br>
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle drawing...");
    }

}
