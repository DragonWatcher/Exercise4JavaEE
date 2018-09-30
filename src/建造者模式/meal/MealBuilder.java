package 建造者模式.meal;

import java.util.Arrays;

import 建造者模式.item.Item;

public class MealBuilder {

    public Meal prepareMeal(Item... items) {
        return new Meal().addAll(Arrays.asList(items));
    }
}
