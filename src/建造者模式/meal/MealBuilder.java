package 建造者模式.meal;

import 建造者模式.item.ChickenBurger;
import 建造者模式.item.Coke;
import 建造者模式.item.Pepsi;
import 建造者模式.item.VegBurger;

public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
