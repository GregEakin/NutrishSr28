package greg.info.parsers;

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

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    public static void parseLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        greg.info.entities.LanguaL item = new greg.info.entities.LanguaL();

        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));
        item.setFactor_Code(fields[1].substring(1, fields[1].length() - 1));

//        FoodDescription item = session.load(FoodDescription.class, foodDescriptionId);
//        greg.info.entities.LanguaL languaL = session.load(greg.info.entities.LanguaL.class, languaLId);
//        item.getLanguages().add(languaL);

        session.save(item);
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
