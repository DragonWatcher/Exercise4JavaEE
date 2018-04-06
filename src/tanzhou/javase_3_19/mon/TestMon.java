package tanzhou.javase_3_19.mon;

public class TestMon {

    public static void main(String[] args) {
        // 创建对象蛇怪和蜈蚣精
        SnakeMonstar snake = new SnakeMonstar("蛇怪", 20);
        CentipedeMonster centipede = new CentipedeMonster("蜈蚣精", 15);
        // 经过激烈的混战，蛇怪已经仅剩20生命值
        snake.hitPoint = 20;
        // 经过激烈的混战，蜈蚣精还剩80生命值
        centipede.hitPoint = 80;
        
        System.out.println("怪物蛇妖甲展开攻击");
        System.out.println("当前生命值是：" + (snake.hitPoint = centipede.attact(snake.hitPoint)));
        System.out.println("攻击力是：" + snake.damage);
        // 蛇怪大招补血！！！
        snake.heal();
        snake.move();
        System.out.println("==========================");
        System.out.println("怪物蜈蚣乙展开攻击");
        System.out.println("当前生命值是：" + (centipede.hitPoint = snake.attact(centipede.hitPoint)));
        System.out.println("攻击力是： " + centipede.damage);
        centipede.move();
    }

}
