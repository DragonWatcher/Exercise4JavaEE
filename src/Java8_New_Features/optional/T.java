package Java8_New_Features.optional;

import java.util.Optional;

/**
 * Optional使用详解： 使用 Optional 时尽量不直接调用 Optional.get() 方法, Optional.isPresent()
 * 更应该被视为一个私有方法, 应依赖于其他像 Optional.orElse(), Optional.orElseGet(), Optional.map()
 * 等这样的方法. <br>
 * 类名：T<br>
 * 作者： mht<br>
 * 日期： 2018年9月2日-下午10:47:42<br>
 */
public class T {
    public static void main(String[] args) {
        /* 1. 三个构造器 */
        // 它要求传入的 obj 不能是 null 值的, 否则还没开始进入角色就倒在了 NullPointerException 异常上.
        Optional<User> opt1 = Optional.of(new User());
        // value == null ? empty() : of(value);
        Optional<User> opt2 = Optional.ofNullable(null);
        // 直接返回一个空的Optional对象
        Optional<User> opt3 = Optional.empty();
        System.out.println("#1 output: " + opt1 + " , " + opt2 + " , " + opt3);

        /* 2. 存在即返回, 无则提供默认值 */
        // 这种方法可以取代三目运算符的非空判断与默认值赋值。
        User u = opt1.orElse(new User(2, "小明"));
        User u2 = opt2.orElse(new User(2, "小明"));
        System.out.println("#2 output: " + u + " ; " + u2);
        /* 3.存在即返回, 无则由函数来产生 ,和上一个类似 */
        User u3 = opt2.orElseGet(() -> {
            return new User(3, "波多老师");
        });
        // 或者写成 >>> User u3 = opt2.orElseGet(() -> new User(3,"波多老师"));
        System.out.println("#3 output: " + u3);
        /* 4. 存在就对它做点什么 */
        opt1.ifPresent(user -> System.out.println("#4 output: " + user.getName()));
        opt2.ifPresent(user -> System.out.println("#4 output: " + user.getName()));
        /* 5. map函数 */
        // map函数判断isPresent() == true时，执行参数列表中的代码，以为返回的是Optional<T>所以可以配合orElse和orElseGet一起使用。
        User qiao = new User(100, "da-qiao-wei-jiu");
        String name = opt2.map(user -> user.getName()).orElseGet(() -> qiao.getName());
        System.out.println("#5 output: " + name);
        // 多个map级联
        Optional<User> teacherOpt = Optional.of(new User(19, "da-qiao-wei-jiu"));
        String name2 = teacherOpt.map(user -> user.getName()).map(n -> n.toUpperCase()).orElse("sss");
        System.out.println("#6 output: " + name2);
    }
}

class User {
    private Integer score = 1;
    private String name = "苍老师";

    public User() {
    }

    public User(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{score : " + score + ", name : " + name + "}";
    }

}
