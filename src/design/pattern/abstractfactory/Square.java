package design.pattern.abstractfactory;
/**
 * 正方形类
 * <br>类名：Square<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:03:13<br>
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square drawing...");
    }
    
    
}
