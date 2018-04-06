package design.pattern.factory;

public class FactoryPattern {

    public static void main(String[] args) {
        //客户要生产产品A
        Factory fa = new FactoryA();
        fa.manufacture().show();
        
        // 客户要生产产品B
        Factory fb = new FactoryB();
        fb.manufacture().show();
    }

}
