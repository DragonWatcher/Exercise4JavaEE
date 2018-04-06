package design.pattern.factory1;

public class CarFactory {

    /**
     * 获得汽车方法 <br>
     * 作者： mht<br>
     * 时间：2018年3月20日-下午11:52:54<br>
     */
    public static Car getCar(Class c) {
        if (c == null)
            return null;
        try {
            /**
             * 通过newInstance()方法，可以避免工厂类的抽象，将生产过程通过产品的类信息而<br>
             * 使工厂类达到"一般化"的效果。单独抽象工厂类，然后在生产产品的时候用new的原始方式，<br>
             * 需要额外扩展对应具体产品的工厂类，而这种newInstance()方式，实际上简化了这种复杂性，<br>
             * 却同样解决了新增产品需要修改工厂类逻辑的问题。
             */
            Car car = (Car) Class.forName(c.getName()).newInstance();
            return car;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
