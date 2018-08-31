package understanding_jvm;

import java.util.ArrayList;
import java.util.List;

public class test_mamory {

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
    
    
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
    
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

}
