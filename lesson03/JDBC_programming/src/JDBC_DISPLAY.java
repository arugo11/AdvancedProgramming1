import java.sql.*;

public class JDBC_DISPLAY{
    public static void main(String[] args){
        try{
            /**PosgreSQLでのDBへの接続
             * 接続先とポート: localhost:5432
             * データベース  : test1
             * ユーザ:shibaura
             * パスワード : toyosu
             */

            String url = "jdbc:postgresql://localhost:5432/test1";
            Class.forName("org.postgresql.Driver");
            Connection con =
                DriverManager.getConnection(url, "shibaura", "toyosu");

            Statement stmt = con.createStatement();

            // 検索の実施と結果の格納
            String sql = "SELECT * FROM test1";
            ResultSet rs = stmt.executeQuery(sql);

            // 検索結果を順に"ID NAME MESSAGE" の形式で出力
        while(rs.next()){
            String sID = rs.getString("ID");
            String sName = rs.getString("NAME");
            int sAge = rs.getInt("Age");
            String sAddress = rs.getString("Address");
            System.out.println(sID+""+sName+""+sAge+""+sAddress);
        }
        stmt.close();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
        }
    }
}
