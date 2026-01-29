import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUD_operation";
        String user = "root";
        String pass = "abhi1a2b3c";

        String sql = "DELETE FROM watchlist WHERE status = 'Watched'";

        Scanner sc = new Scanner(System.in);
        System.out.println("Note the watched movie will be deleted permanently\n Are u sure u want to proceed click 'y' to proceed");
        String c=sc.next();
        if (c.equals("y")) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);

           

            ps.executeUpdate();
            System.out.println("Deleted");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }
}
