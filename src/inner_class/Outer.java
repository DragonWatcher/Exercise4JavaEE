package inner_class;

public class Outer {
    // 1.创建一个内部类
    class Inner {
        private String name;
        public Inner(String name) {
            this.name = name;
        }
        String sayName() {
            return this.name;
        }
    }
    // 2.创建非静态方法，调用内部类构造器创建内部类实例
    public Inner getInner(String innerName) {
        return new Inner(innerName);
    }
    public static void main(String[] args) {
       //3. 创建外部类实例
        Outer out = new Outer();
        // 4.创建内部类实例
        Outer.Inner in = out.getInner("tom");
        // 5.使用内部类实例
        System.out.println(in.sayName());
    }

}
