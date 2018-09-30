package 建造者模式.item.colddrink;

import 建造者模式.item.Item;
import 建造者模式.packing.Bottle;
import 建造者模式.packing.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
