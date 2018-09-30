package 建造者模式;

import 建造者模式.item.Item;
import 建造者模式.item.burger.ChickenBurger;
import 建造者模式.item.burger.VegBurger;
import 建造者模式.item.colddrink.Coke;
import 建造者模式.item.colddrink.Pepsi;
import 建造者模式.meal.Meal;
import 建造者模式.meal.MealBuilder;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        
        Item vegBurger = new VegBurger();
        Item coke = new Coke();
        Meal vegMeal = mealBuilder.prepareMeal(vegBurger, coke);
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getSum());

        Item chickenBurger = new ChickenBurger();
        Item pepsi = new Pepsi();
        Meal nonVegMeal = mealBuilder.prepareMeal(chickenBurger, pepsi);
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getSum());
    }
}
