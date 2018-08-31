package thinging.in.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import boxtest.Box;

public class testflect {
    public static void main(String[] args) throws Exception {
        Student t = new Student();
        String something = getSomething(t);
        System.out.println(something);
    }
    
    public static <T> String getSomething(T bean){
        return "something";
    }

}
