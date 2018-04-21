package boxtest;

public class TestMac {
    public static void main(String[] args) {
        
        char[] managerMac = { 0x94, 0xC6, 0x91, 0x18, 0xDD, 0x90 };
        
        char[] macStr2Char = macStr2Char("94-C6-91-18-DD-90");
        
        for (int i = 0; i < macStr2Char.length; i++) {
            System.out.println(macStr2Char[i] == managerMac[i]);
        }
    }

    public static char[] macStr2Char(String macStr) {
        if (macStr.equals("")) {
            return null;
        } else {
            String[] macArr = macStr.split("-");
            char[] macChars = new char[6];
            for (int i = 0; i < macChars.length; i++) {
                int point = Integer.parseInt(macArr[i], 16);
                if ((point < 0) || (point > Character.MAX_CODE_POINT)) {
                    throw new IllegalArgumentException(macStr + " hexString表示的字符范围溢出");
                }
                char macChar = Character.toChars(point)[0];
                macChars[i] = macChar;
            }
            return macChars;
        }
    }
}
