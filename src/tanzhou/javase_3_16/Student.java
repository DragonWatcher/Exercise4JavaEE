package tanzhou.javase_3_16;

public class Student {

    private String idNum;
    private String name;
    private int age;
    private String city;
    
    public Student() {
    }
    
    public String getIdNum() {
        return idNum;
    }
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public String info() {
        
        return this.getIdNum() + this.getName() + this.getAge() + this.getCity();
    }
}
