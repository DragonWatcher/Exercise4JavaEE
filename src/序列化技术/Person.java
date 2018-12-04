package 序列化技术;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -7178619182797665493L;

	private String firstName;

    private String lastName;

    private int age;

    private Person spouse;

    public enum Gender {
        MALE, FEMALE
    }

    private Gender gender;

    public Person() {
    }

    public Person(String fn, String ln, int a, Gender gender) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setFirstName(String value) {
        firstName = value;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public void setAge(int value) {
        age = value;
    }

    public void setSpouse(Person value) {
        spouse = value;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{firstName : " + firstName + ", lastName : " + lastName + ", age : " + age + ", spouse : " + spouse.getFirstName()
                + ", gender : " + gender + "}";
    }
    
}
