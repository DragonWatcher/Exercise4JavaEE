package inner_class;

public class AnonymousConstructor {

    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initrializer");
            }
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }
    
    public static void main(String[] args) {
        Base b = getBase(47);
        b.f();
    }

}

abstract class Base {
    
    public Base(int i) {
        
        System.out.println("Base constractor initializer,i = " + i);
    }
    
    public abstract void f();
}
