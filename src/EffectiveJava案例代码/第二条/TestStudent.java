package EffectiveJava案例代码.第二条;

public class TestStudent {

    public static void main(String[] args) {
        // 客户端代码使用必需参数创建一个builder对象
        Student stu = new Student.StudentBuilder(10001, "张三", 1, 17)// 必须参数：学号、姓名、性别、年龄
                                 .headTeacherName("张老师")           // 可选参数：班主任名称
                                 .className("三年一班")               // 可选参数：班级名称
                                 .address("朝阳区-潘家园")             // 可选参数：家庭住址
                                 .specialty("硬笔书法")               // 可选参数：特长
                                 .build();

        System.out.println(stu);
    }

}
