package 马士兵高并发编程公开课.并发容器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedXxx {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        List<String> syncStrs = Collections.synchronizedList(strs);
    }

}
