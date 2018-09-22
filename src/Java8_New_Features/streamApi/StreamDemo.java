package Java8_New_Features.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Integer[] nums = new Integer[] { 1, 2, 2, 3, 5 };
        List<Integer> numsList = Arrays.asList(nums);
        
        Stream<Integer> parallelStream = numsList.parallelStream();
        System.out.println(parallelStream);
    }

}
