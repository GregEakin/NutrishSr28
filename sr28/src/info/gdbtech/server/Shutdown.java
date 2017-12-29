/*
 * Copyright (c) 2017. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
