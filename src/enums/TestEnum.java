package enums;

import java.util.EnumMap;

public class TestEnum {

    public static void main(String[] args) {
        EnumMap<ScalEnum, Object> eMap = new EnumMap<>(ScalEnum.class);
        eMap.put(ScalEnum.AIR_ON, 400);

        System.out.println(eMap.get(ScalEnum.AIR_ON));
    }

}
