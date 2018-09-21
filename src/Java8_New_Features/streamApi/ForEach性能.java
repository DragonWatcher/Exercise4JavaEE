package Java8_New_Features.streamApi;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类为了研究Java8中的forEach函数效率问题
 * <br>类名：ForEach性能<br>
 * 作者： mht<br>
 * 日期： 2018年9月21日-下午2:29:58<br>
 */
public class ForEach性能 {

    public static void main(String[] args) {
        int times = 10000000;
        
        new Thread(() -> {
            List<String> names = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                names.add(String.valueOf("name" + i));
            }
            
            long start = System.currentTimeMillis();
            names.forEach(name -> name += name);
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("函数式编程：" + (end - start));
        },"函数式编程").start();
        
        new Thread(() -> {
            List<String> names = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                names.add(String.valueOf("name" + i));
            }
            
            long start2 = System.currentTimeMillis();
            for (String name : names) {
                name += name;
            }
            long end2 = System.currentTimeMillis();
            System.out.println();
            System.out.println("传统命令式编程：" + (end2 - start2));
        },"命令式编程").start();
    }
}
