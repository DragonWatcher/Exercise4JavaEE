package 编程面试题;

import java.util.Arrays;
/**
 * 冒泡排序
 * https://blog.csdn.net/u014745069/article/details/82560778
 * <br>类名：Bubble<br>
 * 作者： mht<br>
 * 日期： 2018年9月9日-下午6:30:39<br>
 */
public class Bubble {
    public static void BubbleSort(int[] arr) {
        int temp;
        // 冒泡趟数：每循环一趟，就会得出一个最大值
        for (int i = 0; i < arr.length - 1; i++) {
            // 下标范围：数组长度-每趟已被排序的个数-（不需要再比较的）最后一个数
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 升序（或降序）
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 3, 5 };
        Bubble.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        // output : [1, 2, 3, 4, 5]
    }
}
