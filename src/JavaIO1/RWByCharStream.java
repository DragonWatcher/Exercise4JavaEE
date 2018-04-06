package JavaIO1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RWByCharStream {

	public static void main(String[] args) {
		try {
			
			FileInputStream fis = new FileInputStream("mark.txt");
			FileOutputStream fos = new FileOutputStream("mark_new.txt");
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			char[] input = new char[100];
			int length = 0;
			while ((length = isr.read(input)) != -1) {
//				System.out.println(new String(input,0,length));
				osw.write(input,0,length);
			}
			isr.close();
			fis.close();
			osw.close();
			fos.close();
			System.out.println("done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
