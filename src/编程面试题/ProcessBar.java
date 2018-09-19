package 编程面试题;
/**
 * https://blog.csdn.net/isea533/article/details/6416964
 * 网上的一个博客专家早期写的小程序
 * <br>类名：ProcessBar<br>
 * 作者： isea533<br>
 * 日期： 2018年9月19日-下午9:30:26<br>
 */
public class ProcessBar {

    /**
     * 显示一个进度条
     */
    private static int count = 1;
    private static boolean isStart = false;

    public static void processbarshow(int num, int total) {
        /**
         * 总共显示30个 ______________________________ ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
         */
        int process = num * 30 / total;
        if (!isStart) {
            System.out.println("______________________________");
            isStart = true;
        }
        if (count > 30) {
            count = 1;
            isStart = false;
        }
        if (process == count) {
            System.out.print("■");
            count++;
        }
        if (process == 30) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double ceshi = 0;
        double b = Math.random() * 10000;
        int a = (int) b;
        for (int i = 0; i < 5; i++) {
            System.out.println(a + ":");
            for (int j = 0; j <= a;) {
                ceshi = Math.random() * 100;
                if (ceshi > 99.99) {
                    j++;
                    ProcessBar.processbarshow(j, a);
                    // if(j>6000)
                    // break;
                }
            }
            b = Math.random() * 10000;
            a = (int) b;
        }
    }

}
