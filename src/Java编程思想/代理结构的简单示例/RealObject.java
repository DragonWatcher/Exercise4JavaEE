package Java编程思想.代理结构的简单示例;

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
    

}
