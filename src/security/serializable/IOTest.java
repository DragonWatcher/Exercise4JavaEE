package security.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOTest {

    public static void main(String[] args) {
        // 在D盘创建一个文件user.txt，使用File的方法
        File file = new File("D:/user.txt");// 指定文件路径
        try {
            file.createNewFile();// 创建文件
        } catch (IOException e1) {
        }

        if (file.exists()) {
            // 文件的写入
            ForWrite(file);
            // 文件的读取
            ForRead(file);
        }
    }

    /**
     * 对象序列化写出
     * @param file
     */
    private static void ForWrite(File file) {
        ObjectOutputStream oos = null;
        try {
            // 把对象写入到文件中，使用ObjectOutputStream
            oos = new ObjectOutputStream(new FileOutputStream(file));
            // 创建对象
            User user = new User("danny", "123465", 26, 172.5);
            // 把对象写入到文件中
            oos.writeObject(user);
            // 创建一个集合
            ArrayList<Object> list = new ArrayList<>();
            list.add(11);
            list.add("是光棍数字！");
            // 把集合对象写入到文件中
            oos.writeObject(list);
            // 添加基本信息
            oos.writeObject(22222222);
            oos.writeObject("荷包蛋！");

            System.out.println("写入文件完毕！");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "错误！");
        } finally {
            try {
                oos.close();// 关闭输出流
            } catch (IOException e) {
            }

        }
    }
    
    /**
     * 对象序列化读入
     * @param file
     */
    private static void ForRead(File file) {
        // 文件的读取
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            // 数据的读取。每一次读取都会把相应的游标往下移动一位

            // 在输入流中读取对象
            User temp = (User) ois.readObject();
            System.out.println("读取的对象内容为：");
            System.out.println(temp);

            // 在输入流中读取集合
            ArrayList<Object> list = (ArrayList<Object>) ois.readObject();
            System.out.println("打印集合数据信息");
            System.out.println(list);// 打印list里面的元素

            // 在输入流中读取基本数据
            Object o1 = ois.readObject();
            Object o2 = ois.readObject();
            System.out.println("打印基本数据信息");
            System.out.println("o1=" + o1 + "  ,o2=" + o2);

        } catch (Exception e) {
            System.out.println(e.getMessage() + "错误!");
        } finally {
            try {
                ois.close();// 关闭输入流
            } catch (IOException e) {
            }

        }
    }
}