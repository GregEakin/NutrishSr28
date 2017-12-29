package info.gdbtech.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Shutdown {
    public static void main(String[] args) {
        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            //Creating the connection with HSQLDB
            try (Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/nutrish", "SA", "0xB5HweaDz")) {
                sqlShutdown(con);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void sqlShutdown(Connection con) throws SQLException {
        try (Statement statement = con.createStatement()) {
            statement.execute("SHUTDOWN");
        }
    }
}
