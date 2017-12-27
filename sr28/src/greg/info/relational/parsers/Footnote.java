package greg.info.relational.parsers;

import greg.info.relational.entities.FoodDescription;
import greg.info.relational.entities.NutrientDefinition;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// after FoodDescription
// after NutrientDefinition

public class Footnote {
    public static final String Filename = ".\\data\\FOOTNOTE.txt";

    public static void parseFile(final Session session) throws IOException {

        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);
        greg.info.relational.entities.Footnote item = parseFootnote(session, fields);
        session.save(item);
    }

    private static greg.info.relational.entities.Footnote parseFootnote(final Session session, final String[] fields) {
        greg.info.relational.entities.Footnote item = new greg.info.relational.entities.Footnote();

        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        item.setFoodDescription(foodDescription);

        item.setFootnt_No(fields[1].substring(1, fields[1].length() - 1));

        item.setFootnt_Typ(fields[2].substring(1, fields[2].length() - 1));

        String nutr_no = fields[3].substring(1, fields[3].length() - 1);
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, nutr_no);
        item.setNutrientDefinition(nutrientDefinition);

        item.setFootnt_Txt(fields[4].substring(1, fields[4].length() - 1));

        return item;
    }
}
