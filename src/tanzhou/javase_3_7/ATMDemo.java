package tanzhou.javase_3_7;

import java.util.Scanner;

/**
 * 作业第十题：<br>
 * 模拟银行取款功能，用户输入取款金额，若输入取款金额不大于零，提示<br>
 * “输入的金额不正确”，若取款金额大于零并且小于余额，则将余额更新，提示<br>
 * “取款成功”，并输出余额。若取款金额大于或等于余额，提示“余额不足”。假<br>
 * 设初始金额为5000元，银行要求账户余额不能低于1元。
 * 
 * @author Morty
 *
 */
public class ATMDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 初始余额为5000
        double sum = 5000;
        System.out.println("请输入取款金额：");
        double money = input.nextDouble();
        if (money <= 0) {
            System.out.println("对不起，您输入的金额有误！");
        }else if (money > (5000 - 1)) {// 银行规定，余额不得少于1元
            System.out.println("余额不足！");
        }else {
            System.out.println("取款成功！");
            System.out.println("余额为：" + (sum -= money));
        }
    }

}
