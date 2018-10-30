package 进制转换练习;

import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * 死循环输出0-15之间任意的数字，然后显示，在脑海中回想对应的16或2进制。
 * @author mht
 * @date 2018年10月30日上午10:29:35
 */
public class 十进制练习 {

	public static void main(String[] args) throws InterruptedException {
		Random rdm = new Random();
		for (;;) {
			int out = rdm.nextInt(16);
			TimeUnit.SECONDS.sleep(2);
			System.out.println(out);
		}
	}

}
