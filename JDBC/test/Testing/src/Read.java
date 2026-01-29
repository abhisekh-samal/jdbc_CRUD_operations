import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUD_operation";
        String user = "root";
        String pass = "abhi1a2b3c";
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
        //  String readSql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM watchlist");
            ResultSet rs = ps.executeQuery();

            // System.out.println("\ns.no.| movie | genre | ratings | status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("sno") + " | " +
                        rs.getString("movie") + " | " +
                        rs.getString("genre")+" " +
                        rs.getInt("ratings")+" | " +
                        rs.getString("status")
                );
            }
    }catch (Exception e) {
            e.printStackTrace();
        }
    
}
}
