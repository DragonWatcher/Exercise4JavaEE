package 建造者模式.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import 建造者模式.item.Item;

public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public Meal addAll(List<? extends Item> items) {
        this.items.addAll(items);
        return this;
    }

    public Double getSum() {
        return this.items.stream()
                         .collect(Collectors.summarizingDouble(Item::price))
                         .getSum();
    }
    
    public Double getAverage() {
        return this.items.stream()
                         .collect(Collectors.summarizingDouble(Item::price))
                         .getAverage();
    }

    public void showItems() {
        this.items.forEach(item -> {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing()
                                                  .pack());
            System.out.println(", Price : " + item.price());
        });
    }
}
