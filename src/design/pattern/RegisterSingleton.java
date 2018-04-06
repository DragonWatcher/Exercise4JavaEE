package design.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册单例模式
 * <br>类名：RegisterSingleton<br>
 * 作者： mht<br>
 * 微信：baozoutianwa<br>
 * 日期： 2018年3月18日-下午10:03:27<br>
 */
public class RegisterSingleton<T> {

    /* 注册表 */
    private static Map<String, Object> regMap = new HashMap<>();
    // 类加载过程中，静态初始化
    static{
        Connection conn = new Connection();
        UserService us = new UserService();
        // 初始化注册表regMap
        regMap.put(conn.getClass().getName(), conn);
        regMap.put(us.getClass().getName(), us);
    }
    // 私有化构造器
    private RegisterSingleton() {
        System.out.println("注册单例模式构造器...");
    }
   
    public synchronized static Object getInstance(String key) {
        if (key == null) return null;
        try {
            if (regMap.get(key) == null) {
                // 这里注意，此Demo是以类名作为key传入map中的，因此，这里的传值也是相关方法，通过类名找到类，然后在进行自动实例化
                regMap.put(key, Class.forName(key).newInstance());
            }
            return regMap.get(key);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
