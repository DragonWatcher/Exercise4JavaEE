package thinging.in.java;

public class Student {
    private String name;
    private String age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "{name : " + name + ", age : " + age + "}";
    }
}
