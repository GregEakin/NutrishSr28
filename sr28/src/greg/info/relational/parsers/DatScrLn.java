package greg.info.relational.parsers;

import greg.info.relational.entities.*;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// After DataSource
// After NutrientData
public class DatScrLn {
    public static final String Filename = ".\\data\\DATSRCLN.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        String NDB_No = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, NDB_No);

        String Nutr_No = fields[1].substring(1, fields[1].length() - 1);
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, Nutr_No);

        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        String DataSrc_ID = fields[2].substring(1, fields[2].length() - 1);
        DataSource dataSource = session.load(DataSource.class, DataSrc_ID);

        nutrientData.getDataSourceSet().add(dataSource);
        session.save(nutrientData);
    }
}
