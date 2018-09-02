package LeetCode;

public class Java709_To_Lower_Case {
    /**
     * 自己的答案
     * <br>作者： mht<br> 
     * 时间：2018年9月2日-下午3:34:30<br>
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        if(str == null || str.length() == 0) return str;
        
        int diff = 'a' - 'A';
        char[] strChars = str.toCharArray();
        char[] lowerStrChars = new char[str.length()];
        
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] >= 'A' && strChars[i] < 'Z') {
                if (strChars[i] < 'Z') {
                    lowerStrChars[i] = (char) (strChars[i] + diff);
                }
            } else {
                lowerStrChars[i] += strChars[i];
            }
        }
        
        return new String(lowerStrChars);
    }
    
    /**
     * 网上的答案，char数组已经可以直接修改里面的值了，不需要单起一个char数组
     * <br>作者： mht<br> 
     * 时间：2018年9月2日-下午3:34:22<br>
     * @param str
     * @return
     */
    public static String toLowerCase2(String str) {
        int diff = 'a' - 'A';
        
        char[] ch = str.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] + diff);
            }
        }
        
        return new String(ch);
    }
    
    public static void main(String[] args) {
        System.out.println(toLowerCase2("LUSUWajflewq3243295"));
    }

}
