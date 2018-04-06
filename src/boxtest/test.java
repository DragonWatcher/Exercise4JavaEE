package boxtest;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 这里我重写equals方法，规定只要Person的所有属性值相等。两个对象就相等
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Person) {
            try {
                Boolean check = true;
                Field[] objectFields = obj.getClass().getDeclaredFields();
                Field[] PersonFields = this.getClass().getDeclaredFields();
                for (int i = 0; i < objectFields.length; i++) {
                    if (!objectFields[i].get(obj).equals(PersonFields[i].get(this))) {
                        check = false;
                        break;
                    }
                }
                return check;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    // 重写hashCode方法，把对象的name和age属性转为一个字符串，返回次字符串的hashCode值
    @Override
    public int hashCode() {
        String id = this.name + this.age;
        return id.hashCode();
    }

}

public class test {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Person p = new Person("fanjie", 23);
        Person p2 = new Person("fanjie", 23);

        System.out.println(p.equals(p2));
        System.out.println(p.hashCode() == p2.hashCode());

    }

}
