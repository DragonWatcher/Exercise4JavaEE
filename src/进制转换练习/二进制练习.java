package 进制转换练习;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class 二进制练习 {

	public static void main(String[] args) throws InterruptedException {
		Random rdm = new Random();
		for (;;) {
			int out = rdm.nextInt(16);
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Integer.toBinaryString(out));
		}
	}

}
