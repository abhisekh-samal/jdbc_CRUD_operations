import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Create {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CRUD_operation";
        String user = "root";
        String pass = "abhi1a2b3c";

        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String insertSql = "INSERT INTO watchlist (sno, movie,genre,ratings,status) VALUES (?, ?,?,?,?)";
            System.out.print("How many records to insert: ");
            int n = sc.nextInt();
            

            PreparedStatement ps = con.prepareStatement(insertSql);

            for (int i = 0; i < n; i++) {
                System.out.print("sno: ");
                ps.setInt(1, sc.nextInt());
                System.out.print("movie: ");
                String name= sc.next();
                ps.setString(2, name);
                System.out.print("genre: ");
                ps.setString(3, sc.next());
                System.out.print("ratings: ");
                ps.setInt(4, sc.nextInt());
                System.out.print("status: ");
                ps.setString(5, sc.next());
                ps.executeUpdate();
                
            }
            System.out.println("Insert done");
    }catch (Exception e) {
            e.printStackTrace();
        }
}
}