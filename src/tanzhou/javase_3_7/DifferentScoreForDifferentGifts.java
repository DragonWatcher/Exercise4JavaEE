package tanzhou.javase_3_7;

import java.util.Scanner;

/**
 * 作业第九题：根据考试成绩输出对应的礼物，90分以上爸爸给买电脑，80分以上爸爸给买手机， 60分以上爸爸请吃一顿大餐，60分以下爸爸给买学习资料
 * 要求：该题使用多重if完成
 * 
 * @author Morty
 *
 */
public class DifferentScoreForDifferentGifts {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("请输入考试成绩：");
        // 用户输入有可能为字符串，因此需要捕获异常
        try {
            double score = input.nextDouble();
            if (score >= 90 && score <= 100) {
                System.out.println("成绩是：" + score + ",礼物是：电脑一台。");
            }else if(score >= 80 && score < 90){
                System.out.println("成绩是：" + score + ",礼物是：iPhone一部。");
            }else if (score >= 60 && score < 80) {
                System.out.println("成绩是：" + score + ",礼物是：大餐一顿。");
            }else if (score >= 0 && score < 60) {
                System.out.println("成绩是：" + score + ",礼物是：补习资料一套。");
            }else {
                System.out.println("对不起，您输入的数字有误，无法进行礼物计算！");
            }
        } catch (Exception e) {
            System.out.println("您输入的不是数字，请重新输入！");
        }
    }

}
