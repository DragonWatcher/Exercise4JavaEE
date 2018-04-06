package tanzhou.javase_3_7;

/**
 * 作业第六题：定义方法：打印5行5列的矩形
 * 
 * @author Morty
 *
 */
public class RectangleBy5_5 {

    public static void main(String[] args) {
        // 方法调用
        printRectangle();
    }
    
    /**
     * 打印五行五列矩形
     * 
     * @author Morty
     */
    public static void printRectangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("■ ");
            }
            System.out.println();
        }
        
        
    }

}
