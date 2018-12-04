package 序列化技术;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import 序列化技术.Person.Gender;

/**
 * 序列化的过程中会用到一个Hash值，这个Hash值是根据源文件中几乎所有信息如：字段名、字段类型、方法名、访问修饰符等
 * 计算出来的一个<code>long</code>型变量：<code>serialVersionUID</code>，叫做“序列化版本ID”，
 * @author mht
 * @date 2018年12月4日上午10:45:29
 */
public class PersonTest {

	@Test
	public void serializeToDisk() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			Person ted = new Person("Ted", "Neward", 39, Gender.MALE);
			Person charl = new Person("Charlotte", "Neward", 38, Gender.FEMALE);
			ted.setSpouse(charl);
			charl.setSpouse(ted);

			fos = new FileOutputStream("tempdata.ser");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(ted);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void readObject() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(new File("tempdata.ser"));
			ois = new ObjectInputStream(fis);

			Person ted = (Person) ois.readObject();

			System.out.println(ted);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
