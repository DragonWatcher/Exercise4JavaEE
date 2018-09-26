package Java8_New_Features.lambda_experssion;

import java.util.Arrays;
import java.util.List;

public class LambdaExperssion {
    public static void main(String[] args) {
        Integer[] valuesInts = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        List<Integer> values = Arrays.asList(valuesInts);

        int result = values.stream()
                           .filter(e -> e > 3)
                           .filter(e -> e % 2 == 0)
                           .map(e -> e * 2)
                           .findFirst()
                           .orElse(0);
        System.out.println(result);

    }

}
