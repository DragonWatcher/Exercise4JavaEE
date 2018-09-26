package Java8_New_Features.方法引用;

//学生类
class Student {

    private String stuName; // 学生姓名
    private Integer stuAge; // 学生年龄
    private Double stuGrade;// 学生成绩

    public Student() {
    } // 无参构造函数

    public Student(String stuName) { // 只有一个参数的构造函数
        this.stuName = stuName;
    }

    public Student(String stuName, Integer stuAge, Double stuGrade) { // 含有全部参数的构造函数
        this.stuAge = stuAge;
        this.stuGrade = stuGrade;
        this.stuName = stuName;
    }

    // 一些 get，set，toString方法
    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Double getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(Double stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "Student [stuAge=" + stuAge + ", stuName=" + stuName + ", stuGrade=" + stuGrade + "]";
    }

}