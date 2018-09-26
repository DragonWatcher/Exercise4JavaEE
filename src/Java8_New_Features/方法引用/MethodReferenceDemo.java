package Java8_New_Features.方法引用;

import java.util.Comparator;
import java.util.function.Supplier;

/**
 * 引用对象的实例方法 Object::instanceMethodName<br>
 * 引用类的静态方法 ClassName::staticMethodName<br>
 * 引用类的实例方法 ClassName::methodName<br>
 * 引用构造方法 ClassName::new <br>
 * 类名：MethodReferenceDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月26日-下午2:10:52<br>
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {
        /**
         * 引用对象的实例方法
         */
        Student stu = new Student("张三", 18, 85.0);
        // Supplier<String> supp=()->stu.getStuName();
        Supplier<String> supp = stu::getStuName;
        System.out.println(supp.get());

        /**
         * 引用类的静态方法
         */
        // Comparator<Integer> com=(x,y)->Integer.compare(x, y);
        Comparator<Integer> com = Integer::compare;
        Runnable runn = System.out::println;
        new Thread(runn);
        
        System.out.println(com.compare(1, 2));

    }
}
