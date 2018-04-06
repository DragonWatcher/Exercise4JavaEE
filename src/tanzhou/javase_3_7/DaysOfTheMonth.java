package tanzhou.javase_3_7;

import java.util.Scanner;

/**
 * 作业第八题：从键盘录入一个年份，再从键盘录入一个月份，
 * 
 * 要求 输出该月有多少天 <br>
 * 闰年的条件： 年%4==0&&年%100!=0 ||年%400==0 提示：先判断是否是闰年，闰年2月29天，平年2月28天，
 * 1，3，5，7，8，10，12月份31天 4,6,9,11月份30天
 * 
 * 
 * 运行效果图:
 ******************************************
 * 请输入年份 2008 请输入月份 2
 * 
 * 2008年2月共有29天
 *******************************************
 * 
 * @author Morty
 *
 */
public class DaysOfTheMonth {

    public static void main(String[] args) {
        calTheDays();
    }

    /**
     * 计算某个月的天数
     * 
     * @author Morty
     */
    public static void calTheDays() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = input.nextInt();
        int month;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("您输入的年份：" + year + "是闰年！");
            System.out.println("请输入月份");
            month = input.nextInt();
            if (month == 2) {
                System.out.println(year + "年2月共有29天");
            }
        }else{
            System.out.println("您输入的年份：" + year + "是平年！");
            System.out.println("请输入月份");
            month = input.nextInt();
            if (month == 2) {
                System.out.println(year + "年2月共有28天");
            }
        }
        if (month != 2) {
            switch (month) {
            case 4:
                System.out.println(year + "年"+month+"月份共有30天");
                break;
            case 6:
                System.out.println(year + "年"+month+"月份共有30天");
                break;
            case 9:
                System.out.println(year + "年"+month+"月份共有30天");
                break;
            case 11:
                System.out.println(year + "年"+month+"月份共有30天");
                break;
            default:
                System.out.println(year + "年"+month+"月份共有31天");
                break;
            }
        }
        
            

    }

}
