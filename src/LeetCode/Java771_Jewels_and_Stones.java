package LeetCode;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A". <br>
 * 类名：Java771_Jewels_and_Stones<br>
 * 作者： mht<br>
 * 日期： 2018年9月1日-上午9:26:48<br>
 */
public class Java771_Jewels_and_Stones {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == J.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int numJewelsInStones = numJewelsInStones("aA", "aAAdsjle");
        System.out.println(numJewelsInStones);// output:3
    }
}
