package tanzhou.javase_3_7;

/**
 * 作业第四题：实现输出1--100之间所有不能被7整除的数，并求和 要求：每输出4个数据换行显示
 * 
 * @author Morty
 *
 */
public class NotExactDivisionSevenAndAmount {

    public static void main(String[] args) {
        // 累加器
        int amount = 0;
        // 1-100循环
        for (int i = 1; i <= 100; i++) {
            if (i % 7 != 0) {
                System.out.print(i + " ");
                // 累加
                amount += i;
            }
            if (i == 100) {
                System.out.println();
            }
        }
        // 输出总和
        System.out.println("总和为：" + amount);
    }
}
