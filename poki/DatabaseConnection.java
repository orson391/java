import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // JDBC URL for connecting to MySQL database running on XAMPP
        String url = "jdbc:mysql://localhost:3306/pokemon"; // Change 'mydatabase' to your database name
        
        // Database credentials (default credentials for XAMPP)
        String username = "root";
        String password = "";
        
        // Establish connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");
            // Perform database operations here
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
