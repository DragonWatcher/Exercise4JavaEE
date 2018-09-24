package Java8_New_Features.streamApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        Stream<Integer> stream = Arrays.stream(nums);
        System.out.println();
        // 2.Stream.of()
        // 内部调用了Arrays.stream()，但是对于基本类型数组，如int[]，Stream.of()无法正常使用,需要使用数值流，如IntStream
        IntStream intArrStream = IntStream.of(numx);
        Stream<Integer> of = Stream.of(nums);
        System.out.println();
        // range代表取[start, end)左闭右开区间，rangeClosed代表取[start, end]
        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Stream.of(1, 2, 2, 3, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        // 3. Collections
        List<Integer> numsList = Arrays.asList( 1, 2, 2, 3, 5 );
        // 使用parallelStream会将List进行分段并行处理，因此处理的顺序是不固定的。
        Stream<Integer> parallelStream = numsList.parallelStream();

        // -----------------------------------Terminal操作 一个 Stream只可以使用一次---------------------------------
        Stream<String> names = Arrays.asList("Tom", "Jerry", "Tim", "Morty").stream();
        // 1. Stream转Array
        String[] namesArr = names.toArray(String[]::new);
        // 2. Stream转Collection
//        List<String> list1 = names.collect(Collectors.toList());
//        List<String> list2 = names.collect(Collectors.toCollection(ArrayList::new));
//        Set<String> set = names.collect(Collectors.toSet());
//        Stack<String> stack = names.collect(Collectors.toCollection(Stack::new));
//        // 3. Stream转String
//        String str = names.collect(Collectors.joining());
        
        
        // -----------------------map将input stream中的每一个元素，映射成output
        // stream中的另外一个元素(一对一映射)---------------------
//        List<String> output = names.map(String::toUpperCase).collect(Collectors.toList());
        // ------------------flatMap（功能和map相同，只不过映射是一对多）-------------------
        /*
         * flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起
         */
        List<String> names1 = Arrays.asList("Tom", "Jerry", "Tim", "Morty");
        List<String> names2 = Arrays.asList("Tony", "Jack", "Tina", "Marry");
        List<String> collect = Stream.of(names1, names2).flatMap(ns -> ns.stream().map(String::toLowerCase))
                .collect(Collectors.toList());
        // ------------------filter对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream--------------------
        Integer[] sixNums = { 1, 2, 3, 4, 5, 6 };
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        // ----------forEach-----------
        /*
         * forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。
         * 但一般认为，forEach 和常规 for 循环的差异不涉及到性能，它们仅仅是函数式风格与传统 Java 风格的差别.
         * 当需要为多核系统优化时，可以 parallelStream().forEach().
         * 另外一点需要注意，forEach 是 terminal 操作。
         * 具有相似功能的 intermediate 操作 peek 可以达到上述目的。
         * 
         * 注意:forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环。
         */
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        // ---------------findFirst-----------------
        /*
         * 这是一个 termimal 兼 short-circuiting 操作，它总是返回 Stream 的第一个元素，或者空。
         * 注意，它的返回值类型：Optional。使用Optional的目的是尽可能避免 NullPointerException
         * 它提供的是编译时检查，能极大的降低 NPE 这种 Runtime Exception 对程序的影响。
         */
        Optional<String> firstName = names2.stream().findFirst();
        // ----------------reduce-----------------
        /*
         * 这个方法的主要作用是把 Stream 元素组合起来
         * 它提供一个起始值（种子），然后依照运算规则（BinaryOperator），
         * 和前面 Stream 的第一个、第二个、第 n 个元素组合。从这个意义上说，
         * 字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。
         * 
         * 下面代码例如第一个示例的 reduce()，第一个参数（空白字符）即为起始值，
         * 第二个参数（String::concat）为 BinaryOperator。
         * 这类有起始值的 reduce() 都返回具体的对象。
         * 而对于第四个示例没有起始值的 reduce()，由于可能没有足够的元素，
         * 返回的是 Optional，请留意这个区别。
         */
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        String s = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        
        //-----------limit/skip-------------
        /*
         * limit 返回 Stream 的前面 n个元素
            skip 则是扔掉前 n 个元素（它是由一个叫 subStream 的方法改名而来）。
         * 
         * 这是一个有 10000 个元素的 Stream，但在 short-circuiting 操作 limit 和 skip 的作用下，管道中 map 操作指定的 getName() 方法的执行次数为 limit 所限定的 10 次，而最终返回结果在跳过前 3 个元素后只有后面 7 个返回。
                                有一种情况是 limit/skip 无法达到 short-circuiting 目的的，就是把它们放在 Stream 的排序操作后，原因跟 sorted这个 intermediate 操作有关：此时系统并不知道 Stream 排序后的次序如何，所以 sorted 中的操作看上去就像完全没有被 limit 或者 skip 一样。
         */
        List<String> persons = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            persons.add(new String("name" + i));
        }
        List<String> personNameList = persons.stream()
                .map(String::toUpperCase)
                .limit(10)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(personNameList);
        System.out.println("==========");
        // --------------------sorted----------------------
        /*
         * 对 Stream 的排序通过 sorted 进行，它比数组的排序更强之处在于你可以首先对 Stream 进行各类 map、filter、limit、skip 甚至 distinct 来减少元素数量后，再排序，这能帮助程序明显缩短执行时间。
         */
        List<String> pList = persons.stream().limit(2).sorted((p1, p2) -> p1.toString().compareTo(p2.toString()))
                .collect(Collectors.toList());
        System.out.println(pList);
        // --------------------min/max/distinct----------------------------
        /*
         * min 和 max 的功能也可以通过对 Stream 元素先排序，再 findFirst 来实现，但前者的性能会更好，为 O(n)，而 sorted 的成本是 O(n log n)。同时它们作为特殊的 reduce 方法被独立出来也是因为求最大最小值是很常见的操作。
         */
//        BufferedReader br = new BufferedReader(new FileReader("c:\\noThisFile.txt"));
//        int longest = br.lines()
//                .mapToInt(String::length)
//                .max().getAsInt();
//        
//        br.close();
//        System.out.println(longest);
        // ------------Match------------
        /*
         * Stream 有三个 match 方法，从语义上说：
         * 
         * allMatch：Stream 中全部元素符合传入的 predicate，返回 true 
         * anyMatch：Stream中只要有一个元素符合传入的 predicate，返回 true 
         * noneMatch：Stream 中没有一个元素符合传入的predicate，返回 true
         * 
         * 它们都不是要遍历全部元素才能返回结果。例如 allMatch 只要一个元素不满足条件，就 skip 剩下的所有元素，返回 false。
         */
//        List<Person> persons = new ArrayList();
//        persons.add(new Person(1, "name" + 1, 10));
//        persons.add(new Person(2, "name" + 2, 21));
//        persons.add(new Person(3, "name" + 3, 34));
//        persons.add(new Person(4, "name" + 4, 6));
//        persons.add(new Person(5, "name" + 5, 55));
//        boolean isAllAdult = persons.stream()
//                .allMatch(p -> p.getAge() > 18);
//        System.out.println("All are adult? " + isAllAdult);
//        boolean isThereAnyChild = persons.stream()
//                .anyMatch(p -> p.getAge() < 12);
//        System.out.println("Any child? " + isThereAnyChild);
        
    }
        
}

class Person {
    public int no;
    private String name;

    public Person(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }
}
