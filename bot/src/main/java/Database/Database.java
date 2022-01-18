package Database;

import java.sql.*;

public class Database {

    public static Connection connection = null;

    public static void connect() {
        try {

            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:Database.db");
            Statement statement = connection.createStatement();
            System.out.println("connected to database");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS table (userId INTEGER PRIMARY KEY);");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public static void closeCon() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("\nDatabase connection closed");
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

}
