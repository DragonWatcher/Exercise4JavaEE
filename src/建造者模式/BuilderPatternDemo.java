package 建造者模式;

import 建造者模式.item.burger.ChickenBurger;
import 建造者模式.item.burger.VegBurger;
import 建造者模式.item.colddrink.Coke;
import 建造者模式.item.colddrink.Pepsi;
import 建造者模式.meal.Meal;
import 建造者模式.meal.MealBuilder;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        
        Meal vegMeal = mealBuilder.prepareMeal(new VegBurger(), new Coke());
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getSum());

        Meal nonVegMeal = mealBuilder.prepareMeal(new ChickenBurger(), new Pepsi());
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getSum());
    }
}
