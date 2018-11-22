package EffectiveJava案例代码.第二条;

public class Student {
    // 必需参数
    private int stuNo;
    private String name;
    private int gender;// 性别：0代表女生；1代表男生
    private int age; // 
    // 可选参数
    private String headTeacherName;// 班主任名称
    private String address;// 家庭住址
    private String className;//班级名称
    private String specialty;//特长
    
    private Student(StudentBuilder builder) {
        this.stuNo = builder.stuNo;
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.headTeacherName = builder.headTeacherName;
        this.address = builder.address;
        this.className = builder.className;
        this.specialty = builder.specialty;
    }

    /** 用于构建Student对象的构建器类*/
    public static class StudentBuilder {
        // 必需
        private int stuNo;
        private String name;
        private int gender;
        private int age;
        
        // 可选
        private String headTeacherName;// 班主任名称
        private String address;// 家庭住址
        private String className;//班级名称
        private String specialty;//特长
        
        public StudentBuilder(int stuNo, String name, int gender, int age) {
            this.stuNo = stuNo;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
        
        public StudentBuilder headTeacherName(String headTeacherName) {
            this.headTeacherName = headTeacherName;
            return this;
        }
        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }
        public StudentBuilder className(String className) {
            this.className = className;
            return this;
        }
        public StudentBuilder specialty(String specialty) {
            this.specialty = specialty;
            return this;
        }
        
        public Student build() {
            return new Student(this);
        }
    }
}
