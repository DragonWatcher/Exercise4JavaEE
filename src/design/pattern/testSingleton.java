package design.pattern;

public class testSingleton {
    public static void main(String[] args) {
//        UserService us = (UserService) RegisterSingleton.getInstance(UserService.class.getName());
//        Connection conn1 = (Connection) RegisterSingleton.getInstance(Connection.class.getName());
//        Connection conn2 = (Connection) RegisterSingleton.getInstance(Connection.class.getName());
//        System.out.println(us);
//        System.out.println(conn1);
//        System.out.println(conn2);
//        System.out.println(conn1 == conn2);
        
        StaticInnerClass sic = StaticInnerClass.getInstance();
        StaticInnerClass sic1 = StaticInnerClass.getInstance();
//        System.out.println(sic.hashCode());
//        System.out.println(sic1.hashCode());
        
    }
}
