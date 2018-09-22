package Java编程思想.动态代理的实现;
/**
 * 实际的需要被代理的对象
 * <br>类名：RealObject<br>
 * 作者： mht<br>
 * 日期： 2018年9月22日-上午8:44:05<br>
 */
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
