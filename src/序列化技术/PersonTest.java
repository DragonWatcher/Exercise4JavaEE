package 序列化技术;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import 序列化技术.Person.Gender;

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
