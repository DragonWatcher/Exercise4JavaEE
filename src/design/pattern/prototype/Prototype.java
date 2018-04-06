package design.pattern.prototype;
/**
 * 原型类
 * <br>类名：Prototype<br>
 * 作者： mht<br>
 * 日期： 2018年3月31日-上午10:12:48<br>
 */
public abstract class Prototype implements Cloneable{

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
