package 建造者模式;

import 建造者模式.item.burger.ChickenBurger;
import 建造者模式.item.burger.VegBurger;
import 建造者模式.item.colddrink.Coke;
import 建造者模式.item.colddrink.Pepsi;
import 建造者模式.meal.Meal;
import 建造者模式.meal.MealBuilder;

/**
 * 建造者模式<br>
 * 博客地址：https://blog.csdn.net/u014745069/article/details/82909779
 * <br>类名：BuilderPatternDemo<br>
 * 作者： mht<br>
 * 日期： 2018年10月5日-下午12:09:37<br>
 */
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
