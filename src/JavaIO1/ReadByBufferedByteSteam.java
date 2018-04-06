package JavaIO1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadByBufferedByteSteam {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("Rick_and_Morty.mkv");
			//第二个参数指定了缓冲区的size，根据实际的执行时间可以优化这个数字。
			BufferedInputStream bis = new BufferedInputStream(fis,1000000);
			FileOutputStream fos = new FileOutputStream("Rck.mkv");
			BufferedOutputStream bos = new BufferedOutputStream(fos,1000000);
			//byte数组会先从缓冲区取得数据，大型文件对应的数据可以大一些，小文件对应的数组可以小一些。
			byte[] input = new byte[1000000];
			int count = 0;
			long before = System.currentTimeMillis();
			//while循环读取视频文件，-1代表已经将文件的字节流全部读取了，!=-1则文件继续读取
			while (bis.read(input) != -1) {
				bos.write(input);
				count++;
			}
			//输入流一组，输出流一组，先打开的流后关闭
			bis.close();
			fis.close();
			bos.close();
			fos.close();
			long after = System.currentTimeMillis();
			System.out.println("读取时间为：" + (after - before) + "ms");
			System.out.println("访问磁盘：" + count + "次");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
