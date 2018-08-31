package page;

public class testPage {
    public static void main(String[] args) {
        // Math.ceil对浮点数向上取整
//        int pageAmount = (int) Math.ceil(1.0 * 19 / 10);
//        System.out.println(pageAmount);
        
        String sql = "select a.* from table_name";
        String sqlArr = sql.replaceAll("a.\\*", "count(*)");
        System.out.println(sqlArr);
    }

}
