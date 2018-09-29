package 泛型化抽象工厂模式.工厂;

public class GenericFactory<T> implements Factory<T> {

    @Override
    public T getProduct(Class<? extends T> clazz) {
        if (clazz == null)
            return null;

        try {
            T obj = (T) Class.forName(clazz.getName()).newInstance();
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
