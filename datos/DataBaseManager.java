package datos;

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final Connection connection;

    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:tienda");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) instance = new DatabaseManager();
        return instance;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return connection.createStatement().executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        return connection.createStatement().executeUpdate(sql);
    }

    public void close() throws SQLException {
        connection.close();
    }
}