package JavaGUI编程;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 * 原文地址 https://www.cnblogs.com/adamjwh/p/8392737.html
 * <br>类名：JFrameDemo<br>
 * 作者： mht<br>
 * 日期： 2018年9月25日-下午1:09:31<br>
 */
public class JFrameDemo {
    public void CreateFrame() {
        JFrame frame = new JFrame("JFrameDemo演示");
        frame.setVisible(Boolean.TRUE);
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameDemo().CreateFrame();
    }

}
