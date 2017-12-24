package greg.info.parsers;

import greg.info.entities.FoodDescription;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

public class LanguaL {
    public static final String Filename = ".\\data\\LANGUAL.txt";

    public static void fileLanguaLMap(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> lineLanguaLMap(session, line));
        }
    }

    public static void lineLanguaLMap(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        String languaLId = fields[1].substring(1, fields[1].length() - 1);

        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        greg.info.entities.LanguaL languaL = session.load(greg.info.entities.LanguaL.class, languaLId);

        foodDescription.getLanguages().add(languaL);

        session.save("FoodDescription", foodDescription);
    }

    public static int sqlSelectRows(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM LANGUAL";
            ResultSet result = stmt.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                String x0 = result.getString("NDB_No");
                String x1 = result.getString("Factor_Code");
                System.out.println(x0 + ", " + x1);

                count++;
            }

            return count;
        }
    }
}
