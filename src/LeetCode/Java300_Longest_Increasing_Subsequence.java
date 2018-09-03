package LeetCode;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence. <br>
 * 类名：Java300_Longest_Increasing_Subsequence<br>
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4 作者： mht<br>
 * 日期： 2018年9月3日-下午7:46:27<br>
 */
public class Java300_Longest_Increasing_Subsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;

        for (int n : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (n > tail[mid]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            // i is the index to insert
            tail[i] = n;
            // if x is larger than all tails, append it, increase the size by 1
            if (i == size)
                ++size;
        }

        return size;
    }

    
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {10,9,2,5,3,4};
        int max = lengthOfLIS(nums);
        System.out.println(max);
    }
}
