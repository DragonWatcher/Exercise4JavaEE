package 建造者模式.item;

import 建造者模式.packing.Packing;
import 建造者模式.packing.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
