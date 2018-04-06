package design.pattern.abstractfactory;
/**
 * 形状工厂类
 * <br>类名：ShapeFactory<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:06:55<br>
 */
public class ShapeFactory implements Factory{

    @Override
    public Shape getPruduct(Class c) {
        if(c == null) return null;
        
        try {
            Shape shape = (Shape) Class.forName(c.getName()).newInstance();
            return shape;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }

}
