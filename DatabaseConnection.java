import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;
    private static final String DATABASE_URL = "jdbc:sqlite:./sqlite-sakila.db";

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getInstance() {
        if (connection == null) {
            new DatabaseConnection();
        }
        return connection;
    }
}
