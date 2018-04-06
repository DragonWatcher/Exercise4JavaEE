package tanzhou.javase_3_19.mon;

public class SnakeMonstar extends Monster{
    
    /**
     * 构造器
     * @param name
     * @param damage
     */
    public SnakeMonstar(String name, int damage) {
        super();
        this.name = name;
        this.damage = damage;
    }
    
    @Override
    public void move() {
        System.out.println("我是蛇怪,我走S型路线");
    }
    
    /**
     * 补血术
     * <br>作者： mht<br> 
     * 时间：2018年3月21日-下午2:37:50<br>
     */
    public int heal() {
        if (this.hitPoint < 10 && this.hitPoint > 0) {
            System.out.println("实施大蛇补血术。。。。。当前生命值是：" + (this.hitPoint + 20));
        }else {
            System.out.println("补血失败！");
            return this.hitPoint;
        }
        
        return this.hitPoint + 20;
    }
}
