package tanzhou.javase_3_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 作业第二题：输入一批整数，使用循环求出最大值与最小值，输入0时结束
 * 
 * @author Morty
 *
 */
public class MaxAndMin {
    // 整数匹配正则
    public static final String reg = "^-?[0-9]\\d*$";

    public static void main(String[] args) {
        List<Integer> nums = getNums();
        int[] intNums = new int[nums.size()];
        // 不使用API手动转化为int数组
        for (int i = 0; i < nums.size(); i++) {
            intNums[i] = nums.get(i);
        }

        // 冒泡排序，最大置前
        for (int i = 0; i < intNums.length - 1; i++) {
            for (int j = 0; j < intNums.length - 1 - i; j++) {
                if (intNums[j] < intNums[j + 1]) {
                    // 追尾调回
                    int temp = intNums[j];
                    intNums[j] = intNums[j + 1];
                    intNums[j + 1] = temp;
                }
            }
        }
        System.out.println("最大值为：" + intNums[0]);
        System.out.println("最小值为：" + intNums[intNums.length - 1]);

    }

    private static List<Integer> getNums() {
        Scanner input = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        do {
            System.out.println("请输入一个整数（输入0结束）");
            String numStr = input.nextLine();
            // 验证整数
            if (numStr.matches(reg)) {
                if (Integer.valueOf(numStr) == 0) {
                    break;
                } else {
                    numList.add(Integer.valueOf(numStr));
                }
            } else {
                System.out.println("您输入的不是数字或不是整数！");
                continue;
            }
        } while (true);

        return numList;
    }

}
