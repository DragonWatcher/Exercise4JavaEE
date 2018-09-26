package Java8_New_Features.Supplier;

import java.util.function.Supplier;
/**
 * Supplier是一个函数接口，接收任意对象，并通过get返回一个对象，相当于一个工厂方法。
 * <br>类名：SupplierDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月26日-下午2:29:52<br>
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Object> supplier = Object::new;
        // 输出如下代码，查看结果
        for (int i = 0; i < 5; i++) {
            System.out.println(supplier.get().toString());
        }
    }
}
