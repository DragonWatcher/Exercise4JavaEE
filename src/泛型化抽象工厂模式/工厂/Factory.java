package 泛型化抽象工厂模式.工厂;

public interface Factory<T> {
    T getProduct(Class<? extends T> clazz);
}
