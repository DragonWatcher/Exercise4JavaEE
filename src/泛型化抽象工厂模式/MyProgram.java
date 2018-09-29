package 泛型化抽象工厂模式;

import 泛型化抽象工厂模式.工厂.Factory;
import 泛型化抽象工厂模式.工厂.GenericFactory;
import 泛型化抽象工厂模式.汽车.Audi;
import 泛型化抽象工厂模式.汽车.Benz;
import 泛型化抽象工厂模式.汽车.Car;
import 泛型化抽象工厂模式.电视.SharpTV;
import 泛型化抽象工厂模式.电视.SonyTV;
import 泛型化抽象工厂模式.电视.Television;
/**
 * https://blog.csdn.net/u014745069/article/details/82902119
 * <br>类名：MyProgram<br>
 * 作者： mht<br>
 * 日期： 2018年9月29日-下午8:52:36<br>
 */
public class MyProgram {

    public static void main(String[] args) {
        Factory<Car> carFactory = new GenericFactory<>();
        Factory<Television> tvFactory = new GenericFactory<>();
        
        Car benz = carFactory.getProduct(Benz.class);
        Car audi = carFactory.getProduct(Audi.class);
        benz.run();
        audi.run();
        
        Television sonyTV = tvFactory.getProduct(SonyTV.class);
        Television sharpTV = tvFactory.getProduct(SharpTV.class);
        sonyTV.play();
        sharpTV.play();
    }
}
