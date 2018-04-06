package tanzhou.javase_3_7;

import java.util.Scanner;

/**
 * 作业第一题：淡旺季机票的价格，原价机票价格为5000元， <br>
 * 淡季头等舱打5折，经济舱打4折 <br>
 * 旺季头等舱打9折，经济舱打8折<br>
 * 
 * 要求<br>
 * 编写程序实现：<br>
 * 输入任意的月份与舱位来计算机票的价格<br>
 * 
 * 1代表头等舱，2代表经济舱<br>
 * 4-10月为旺季，其他月份为淡季<br>
 * 
 * @author Morty （九日组）
 * @since 3.8
 *
 */
public class AirTicket {
    // 正整数正则
    private static final String reg = "^[1-9]\\d*$";

    public static void main(String[] args) {
        // 原始票价
        int primitiveTicket = 5000;
        // 获取月份信息
        int month = getMonth();
        // 获取仓位信息
        int space = getSpace();
        // 计算折扣
        double price = calTicket(primitiveTicket, month, space);

        System.out.println("您查询的" + month + "月," + (space == 1 ? "头等舱" : "经济舱") + "票价为：" + price + "￥");
    }

    private static double calTicket(int ticket, int month, int space) {
        // 最终票价
        double t = 0;
        // 旺季
        if (month >= 4 && month <= 10) {
            // 头等舱
            if (space == 1) {
                t = ticket * 0.9;
            } else if (space == 2) {// 经济舱
                t = ticket * 0.8;
            } else {
                System.out.println("未知错误！");
            }
        } else {// 淡季
                // 头等舱
            if (space == 1) {
                t = ticket * 0.5;
            } else if (space == 2) {// 经济舱
                t = ticket * 0.4;
            } else {
                System.out.println("未知错误！");
            }
        }

        return t;
    }

    /**
     * 验证月份信息
     * 
     */
    private static int getMonth() {
        // 用户输入月份
        Scanner input = new Scanner(System.in);
        // 月份 ，仓位
        int mon;
        do {
            System.out.println("请输入选择的月份：");
            // 接收控制台数据
            String monStr = input.nextLine();
            // 正整数验证
            if (monStr.matches(reg)) {
                mon = Integer.valueOf(monStr);
                // 月份验证
                if (mon < 13) {
                    System.out.println("月份是：" + mon);
                    break;
                } else {
                    System.out.println("您输入的数字不在1到12之间，请重新输入！");
                }
            } else {
                System.out.println("您输入不是整数月份！");
            }
        } while (true);

        return mon;
    }

    /**
     * check仓位
     * 
     */
    private static int getSpace() {
        // 用户输入仓位
        Scanner input = new Scanner(System.in);
        // 月份 ，仓位
        int space;
        do {
            System.out.println("请输入选择的仓位：");
            // 接收控制台数据
            String spaceStr = input.nextLine();
            // 正整数验证
            if (spaceStr.matches(reg)) {
                space = Integer.valueOf(spaceStr);
                // 月份验证
                if (space < 3) {
                    break;
                } else {
                    System.out.println("您输入的数字不在1到2之间，请重新输入！");
                }
            } else {
                System.out.println("您输入不是有效仓位");
            }
        } while (true);

        return space;
    }
}
