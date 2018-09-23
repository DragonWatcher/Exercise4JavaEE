package Java8_New_Features.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream、LongStream、DoubleStream。当然我们也可以用 Stream<Integer>、Stream
 * <Long>、Stream<Double>，但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
 * 
 * 对 Stream 的使用就是实现一个 filter-map-reduce 过程，产生一个最终结果，或者导致一个副作用（side effect） <br>
 * 类名：StreamDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月22日-下午12:58:23<br>
 */
public class StreamDemo {
    public static void main(String[] args) {

        // -------------------------Init------------------------
        Integer[] nums = new Integer[] { 1, 2, 2, 3, 5 };
        int[] numx = new int[] { 1, 2, 2, 3, 5 };
        // 1.Arrays : 不论是基本类型的数组，还是封装类型的数组都可以使用java.util.Arrays.stream()进行操作
        Arrays.stream(numx).forEach(n -> System.out.print(n + " "));
        System.out.println();
        // 2.Stream.of()
        // 内部调用了Arrays.stream()，但是对于基本类型数组，如int[]，Stream.of()无法正常使用,需要使用数值流，如IntStream
        IntStream.of(numx).forEach(n -> System.out.print(n + " "));
        System.out.println();
        // range代表取[start, end)左闭右开区间，rangeClosed代表取[start, end]
        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Stream.of(1, 2, 2, 3, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        // 3. Collections
        List<Integer> numsList = Arrays.asList(nums);
        // 使用parallelStream会将List进行分段并行处理，因此处理的顺序是不固定的。
        numsList.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // -----------------------------------Terminal 一个 Stream只可以使用一次---------------------------------
        List<String> names = Arrays.asList("Tom", "Jerry", "Tim", "Morty");
        // 1. Array
        String[] namesArr = names.stream().toArray(String[]::new);
        // 2. Collection
        List<String> list1 = names.stream().collect(Collectors.toList());
        List<String> list2 = names.stream().collect(Collectors.toCollection(ArrayList::new));
        Set set = names.stream().collect(Collectors.toSet());
        Stack stack = names.stream().collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = names.stream().collect(Collectors.joining());

    }

}
