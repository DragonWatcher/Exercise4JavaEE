package EffectiveJava案例代码.第二条;

/**
 * 不直接生成想要的对象NutritionFacts，而是让客户端利用所有必要的参数调用构造器（或静态工厂），<br>
 * 得到一个builder对象。然后客户端在builder对象上调用类似于setter的方法，<br>
 * 来设置每个相关的可选参数。最后，客户端调用无参的builder方法来生成不可变的对象。<br>
 * 这个builder是它构建的类的静态成员类。<br>
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    /** 私有构造器 */
    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    /** 静态成员类 */
    public static class Builder {
        // required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "{servingSize : " + servingSize + ", servings : " + servings + ", calories : " + calories + ", fat : "
                + fat + ", sodium : " + sodium + ", carbohydrate : " + carbohydrate + "}";
    }
}
