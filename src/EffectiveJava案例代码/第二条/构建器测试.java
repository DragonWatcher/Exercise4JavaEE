package EffectiveJava案例代码.第二条;

import EffectiveJava案例代码.第二条.NutritionFacts.Builder;

/**
 * 1、不直接生成目标对象NutritionFacts，而是让客户端利用所有必要的参数调用构造器（或静态工厂），<br>
 * 得到一个builder对象。<br>
 * 2、然后客户端在builder对象上调用类似于setter的方法，来设置每个相关的可选参数。<br>
 * 3、最后，客户端调用无参的builder方法来生成不可变的对象。<br>
 * 这个builder是它构建的类的静态成员类。<br>
 */
public class 构建器测试 {
    public static void main(String[] args) {
        // 客户端代码使用必要的参数创建一个builder对象
        Builder nutritionFactsBuilder = new NutritionFacts.Builder(5, 10);
        
        NutritionFacts nutritionFacts = nutritionFactsBuilder.calories(50).build();
        
        System.out.println(nutritionFacts);
    }
}
