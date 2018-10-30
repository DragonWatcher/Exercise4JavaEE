package 进制转换练习;

import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 死循环输出0-15之间任意的数字，然后显示二进制，在脑海中回想对应的16或10进制。
 * 
 * @author mht
 * @date 2018年10月30日上午10:28:25
 */
public class 二进制练习 {

	public static final String[] ZEROS = { "", "0", "00", "000" };

	public static void main(String[] args) throws InterruptedException {
		Random rdm = new Random();
		int lineCount = 0;
		for (;;) {
			int out = rdm.nextInt(16);
			TimeUnit.SECONDS.sleep(2);
			if (lineCount == 10) {
				System.out.println();
				lineCount = 0;
			}
			System.out.print(format4Bits(out));
			lineCount++;
		}
	}

	private static String format4Bits(Integer unformatNum) {
		if (unformatNum == null)
			throw new InvalidParameterException("参数异常！");

		String binaryString = Integer.toBinaryString(unformatNum);
		int diff = 4 - binaryString.length();

		return ZEROS[diff] + binaryString + "	";
	}

}
