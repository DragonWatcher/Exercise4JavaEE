package JVM调优;

import java.util.ArrayList;
import java.util.List;

/**
 * jvm调优：<br>
 * Jvisualvm的简单使用<br>
 * 虚拟机参数：<br>
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\mht\Desktop\jvm.log
 * -XX:+PrintGCDetails -Xms10M -Xmx10M <br>
 * 类名：T04<br>
 * 作者： mht<br>
 * 日期： 2018年10月6日-下午8:35:15<br>
 */
public class T04 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 100000000; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }
}
