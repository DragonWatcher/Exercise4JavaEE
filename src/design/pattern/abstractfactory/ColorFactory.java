package design.pattern.abstractfactory;
/**
 * 颜色工厂类
 * <br>类名：ColorFactory<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:07:29<br>
 */
public class ColorFactory implements Factory{

    @Override
    public Color getPruduct(Class c) {
        if(c == null) return null;
        
        try {
            Color color = (Color) Class.forName(c.getName()).newInstance();
            return color;
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
