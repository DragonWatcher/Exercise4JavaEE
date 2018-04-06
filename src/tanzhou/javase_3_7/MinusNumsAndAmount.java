package tanzhou.javase_3_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 作业第三题：编写一个程序，从控制台接收10个数，统计并输出其中负数的个数与负数之和
 * @author Morty
 *
 */
public class MinusNumsAndAmount {
    private static final String reg = "^-?[0-9]\\d*$";
    
    public static void main(String[] args) {
        int[] arr = getNums();
        int amount = 0;
        for (int i = 0; i < arr.length; i++) {
            amount += arr[i];
        }
        System.out.println("负数的个数是：" + arr.length + ",负数的和为：" + amount);
    }
    
    /*
     * 返回输入的负数数组
     */
    private static int[] getNums() {
        Scanner input = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        List<Integer> minusNums = new ArrayList<>();
        int count = 1;
        do {
            if (numList.size() == 10) {
                break;
            }
            System.out.println("请输入第" + count + "个整数");
            String num = input.nextLine();
            // 校验整数
            if (num.matches(reg)) {
                // 转化int
                int intNum = Integer.valueOf(num);
                // 放入到输入控制list
                numList.add(intNum);
                count++;
                // 判断是否是负数
                if (intNum < 0) {
                    // 放入到负数List
                    minusNums.add(intNum);
                }
            }else{
                System.out.println("您输入的不是整数，请重新输入！");
            }
        } while (true);
        
        int[] array = new int[minusNums.size()];
        for (int i = 0; i < minusNums.size(); i++) {
            array[i] = minusNums.get(i);
        }
        
        return array;
    }

}
