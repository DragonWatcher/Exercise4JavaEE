package 枚举;

public enum ScalEnum {
    AIR_ON(405),
    AIR_OFF(400),
    FAN_ON(105),
    FAN_OFF(100);
    
    private int scalNum;

    private ScalEnum(int scalNum) {
        this.scalNum = scalNum;
    }
    
    
}
