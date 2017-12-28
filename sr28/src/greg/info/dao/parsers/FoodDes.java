package greg.info.dao.parsers;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.FoodGroup;
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

public class FoodDes {
    public static final String Filename = ".\\data\\FOOD_DES.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        FoodDescription item = parseFoodDescription(session, fields);

        session.save(item);
    }

    private static FoodDescription parseFoodDescription(final Session session, final String[] fields) {

        FoodDescription item = new FoodDescription();

        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));

        String foodGroupId = fields[1].substring(1, fields[1].length() - 1);
        FoodGroup foodGroup = session.load(FoodGroup.class, foodGroupId);
        item.setFoodGroup(foodGroup);

        item.setLong_Desc(fields[2].substring(1, fields[2].length() - 1));
        item.setShrt_Desc(fields[3].substring(1, fields[3].length() - 1));
        if (fields[4].length() > 2) item.setComName(fields[4].substring(1, fields[4].length() - 1));
        if (fields[5].length() > 2) item.setManufacName(fields[5].substring(1, fields[5].length() - 1));
        if (fields[6].length() > 2) item.setSurvey(fields[6].substring(1, fields[6].length() - 1));
        if (fields[7].length() > 2) item.setRef_desc(fields[7].substring(1, fields[7].length() - 1));
        if (fields[8].length() > 0) item.setRefuse(Integer.parseInt(fields[8]));
        if (fields[9].length() > 2) item.setSciName(fields[9].substring(1, fields[9].length() - 1));
        if (fields[10].length() > 0) item.setN_Factor(Double.parseDouble(fields[10]));
        if (fields[11].length() > 0) item.setPro_Factor(Double.parseDouble(fields[11]));
        if (fields[12].length() > 0) item.setFat_Factor(Double.parseDouble(fields[12]));
        if (fields[13].length() > 0) item.setCHO_Factor(Double.parseDouble(fields[13]));
        return item;
    }

    public static int sqlSelectRows2(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM FOOD_DES";
            ResultSet result = stmt.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                String x0 = result.getString("NDB_No");
                String x1 = result.getString("FdGrp_Cd");
                String x2 = result.getString("Long_Desc");
                String x3 = result.getString("Shrt_Desc");
                String x4 = result.getString("ComName");
                String x5 = result.getString("ManufacName");
                String x6 = result.getString("Survey");
                String x7 = result.getString("Ref_desc");

                Byte x8 = result.getByte("Refuse");
                if (result.wasNull()) x8 = null;

                String x9 = result.getString("SciName");

                Float x10 = result.getFloat("N_Factor");
                if (result.wasNull()) x10 = null;

                Float x11 = result.getFloat("Pro_Factor");
                if (result.wasNull()) x11 = null;

                Float x12 = result.getFloat("Fat_Factor");
                if (result.wasNull()) x12 = null;

                Float x13 = result.getFloat("CHO_Factor");
                if (result.wasNull()) x13 = null;

                System.out.println(x0 + ", " + x1 + ", " + x2 + ", " + x3);
                /*
                      0  "NDB_No", "CHARACTER(5)", Types.CHAR, "NOT NULL PRIMARY KEY"),
                      1  "FdGrp_Cd", "CHARACTER(4)", Types.CHAR, "NOT NULL"),
                      2  "Long_Desc", "VARCHAR(200)", Types.VARCHAR, "NOT NULL"),
                      3  "Shrt_Desc", "VARCHAR(60)", Types.VARCHAR, "NOT NULL"),
                      4  "ComName", "VARCHAR(100)", Types.VARCHAR, null),
                      5  "ManufacName", "VARCHAR(65)", Types.VARCHAR, null),
                      6  "Survey", "CHARACTER(1)", Types.CHAR, null),
                      7  "Ref_desc", "VARCHAR(135)", Types.VARCHAR, null),
                      8  "SciName", "VARCHAR(65)", Types.VARCHAR, null),
                      9  "N_Factor", "FLOAT", Types.FLOAT, null),
                     10  "Pro_Factor", "FLOAT", Types.FLOAT, null),
                     11  "Fat_Factor", "FLOAT", Types.FLOAT, null),
                     12  "CHO_Factor", "FLOAT", Types.FLOAT, null),
                */

                count++;
            }

            return count;
        }
    }
}
