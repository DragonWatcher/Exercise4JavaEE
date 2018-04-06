package tanzhou.javase_3_19.mon;

/**
 * 怪兽类
 * <br>类名：Monster<br>
 * 作者： mht<br>
 * 日期： 2018年3月21日-下午2:21:43<br>
 */
public abstract class Monster {
    // 怪兽名字
    public String name;
    // 血量
    public int hitPoint;
    // 攻击力
    public int damage;
    // 构造器
    public Monster() {
        this.hitPoint = 100;
    }
    // 攻击
    public int attact(int enemyHitPoint){
        enemyHitPoint -= this.damage;
        return enemyHitPoint;
    }
    // 移动
    public abstract void move();
    
    
}
