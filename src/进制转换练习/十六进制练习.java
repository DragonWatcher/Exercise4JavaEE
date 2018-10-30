package 进制转换练习;

import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * 死循环输出0-15之间任意的数字，然后显示十六进制，在脑海中回想对应的2或10进制。
 * @author mht
 * @date 2018年10月30日上午10:29:52
 */
public class 十六进制练习 {

	public static void main(String[] args) throws InterruptedException {
		Random rdm = new Random();
		int count = 0;
		for (;;) {
			int out = rdm.nextInt(16);
			TimeUnit.SECONDS.sleep(2);
			if (count == 10) {
				System.out.println();
				count = 0;
			}
			System.out.print(Integer.toHexString(out).toUpperCase() + "    ");
			count++;
		}
	}

}
