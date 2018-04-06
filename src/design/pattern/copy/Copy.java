package design.pattern.copy;
/**
 * Serializable序列化深拷贝
 * <br>类名：Copy<br>
 * 作者： mht<br>
 * 日期： 2018年4月1日-下午6:13:37<br>
 */
public class Copy {

    public static void main(String[] args) {
        Student s1 = new Student();
        Teacher t1 = new Teacher();
        s1.setTeacher(t1);
        System.out.println("t1的内存地址：" + t1);
        System.out.println("==========================");
        Student s2 = (Student) s1.deepClone();
        // 两个学生对象的内存为：
        System.out.println(s1 + "\n" + s2);
        System.out.println("==========================");
        // 两个学生对象中的老师对象为：
        System.out.println("s1.getTeacher() : " + s1.getTeacher() + "\ns2.getTeacher() : " +  s2.getTeacher());
    }
}
