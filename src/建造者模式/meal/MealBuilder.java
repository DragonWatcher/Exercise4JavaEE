package 建造者模式.meal;

import 建造者模式.item.burger.ChickenBurger;
import 建造者模式.item.burger.VegBurger;
import 建造者模式.item.colddrink.Coke;
import 建造者模式.item.colddrink.Pepsi;

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
