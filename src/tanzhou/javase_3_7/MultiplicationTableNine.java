package tanzhou.javase_3_7;


/**
 * 作业第五题：定义方法：实现打印9,9乘法表
 * @author Morty
 *
 */
public class MultiplicationTableNine {

    public static void main(String[] args) {
        comeTrueTheTable();
    }
    
    /**
     * 乘法表实现方法
     * @author Morty
     */
    public static void comeTrueTheTable(){
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "×" + j + "=" + i*j + (j != i ? "," : ""));
            }
            System.out.println();
        }
    }
}
