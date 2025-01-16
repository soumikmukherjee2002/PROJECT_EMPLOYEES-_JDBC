import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PROJECTEmpService {
    private static String url = "jdbc:postgresql://localhost:5432/employee";
    private static String user = "postgres";
    private static String pswd = "123";
    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    static {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pswd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Save employee data
    public int save() {
        System.out.println("Enter the employee id:");
        int id = sc.nextInt();
        System.out.println("Enter the employee name:");
        String name = sc.next();
        int res = 0;

        String sql = "INSERT INTO emp (id, name) VALUES (?, ?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, name);
            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    // Update employee data
    public int update() {
        System.out.println("Enter the employee id to update:");
        int id = sc.nextInt();
        System.out.println("Enter the new employee name:");
        String name = sc.next();
        int res = 0;

        String sql = "UPDATE emp SET name = ? WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    // Delete employee data
    public int delete() {
        System.out.println("Enter the employee id to delete:");
        int id = sc.nextInt();
        int res = 0;

        String sql = "DELETE FROM emp WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            res = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    // Fetch all employee data
    public void fetchAll() {
        String sql = "SELECT * FROM emp";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
