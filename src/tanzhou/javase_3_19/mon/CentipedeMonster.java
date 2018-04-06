package tanzhou.javase_3_19.mon;

public class CentipedeMonster extends Monster{
    
    public CentipedeMonster(String name, int damage) {
        super();
        this.name = name;
        this.damage = damage;
    }

    @Override
    public void move() {
        System.out.println("我是蜈蚣精，御风飞行  ");
    }
    

}
