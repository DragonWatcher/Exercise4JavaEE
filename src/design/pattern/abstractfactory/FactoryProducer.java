package design.pattern.abstractfactory;
/**
 * 工厂生成类
 * <br>类名：FactoryProducer<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午9:08:08<br>
 */
public class FactoryProducer {
    
    public static Factory getFactory(Class c){
        if(c == null) return null;

        try {
            Factory f = (Factory) Class.forName(c.getName()).newInstance();
            return f;
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
