import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CRUD_operations";
        String user = "root";
        String pass = "abhi1a2b3c";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            /* ---------------- INSERT ---------------- */
            String insertSql = "INSERT INTO students (name, email) VALUES (?, ?)";
            System.out.print("How many records to insert: ");
            int n = sc.nextInt();

            PreparedStatement psInsert = con.prepareStatement(insertSql);

            for (int i = 0; i < n; i++) {
                System.out.print("Name: ");
                psInsert.setString(1, sc.next());
                System.out.print("Email: ");
                psInsert.setString(2, sc.next());
                psInsert.executeUpdate();
            }
            System.out.println("Insert done");

            /* ---------------- READ ---------------- */
            String readSql = "SELECT * FROM students";
            PreparedStatement psRead = con.prepareStatement(readSql);
            ResultSet rs = psRead.executeQuery();

            System.out.println("\nID | NAME | EMAIL");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email")
                );
            }

            /* ---------------- UPDATE ---------------- */
            String updateSql = "UPDATE students SET email=? WHERE id=?";
            PreparedStatement psUpdate = con.prepareStatement(updateSql);

            System.out.print("\nEnter ID to update: ");
            int uid = sc.nextInt();
            System.out.print("Enter new email: ");
            String newEmail = sc.next();

            psUpdate.setString(1, newEmail);
            psUpdate.setInt(2, uid);
            psUpdate.executeUpdate();
            System.out.println("Update done");

            /* ---------------- DELETE ---------------- */
            String deleteSql = "DELETE FROM students WHERE id=?";
            PreparedStatement psDelete = con.prepareStatement(deleteSql);

            System.out.print("\nEnter ID to delete: ");
            int did = sc.nextInt();

            psDelete.setInt(1, did);
            psDelete.executeUpdate();
            System.out.println("Delete done");

            /* ---------------- FINAL READ ---------------- */
            ResultSet rs2 = psRead.executeQuery();
            System.out.println("\nFINAL TABLE DATA");
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("id") + " | " +
                        rs2.getString("name") + " | " +
                        rs2.getString("email")
                );
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
