package Java8_New_Features.streamApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StreamDemo {
    public static void main(String[] args) {
        Collections.sort(Arrays.asList(1,2,3,4,5), new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

}
