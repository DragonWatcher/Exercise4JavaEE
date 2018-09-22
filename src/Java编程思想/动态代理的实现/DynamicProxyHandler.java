package Java编程思想.动态代理的实现;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理器
 * 用于将
 * <br>类名：DynamicProxyHandler<br>
 * 作者： mht<br>
 * 日期： 2018年9月22日-上午9:03:09<br>
 */
public class DynamicProxyHandler implements InvocationHandler{

    private Object real;
    
    public DynamicProxyHandler(Object real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** proxy : " + proxy.getClass() + ";\n*** method : " + method + ";\n*** args : " + args);
        
        if (args != null) {
            for (Object arg : args) {
                System.out.println(">>> " + arg);
            }
        }
        
        return method.invoke(real, args);
    }
}
