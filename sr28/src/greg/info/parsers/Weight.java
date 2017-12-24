package greg.info.parsers;

import greg.info.entities.FoodDescription;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Weight {
    public static final String Filename = ".\\data\\WEIGHT.txt";

    public static void fileWeight(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> lineWeight(session, line));
        }
    }

    public static void lineWeight(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        greg.info.entities.Weight item = new greg.info.entities.Weight();
        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        item.setFoodDescription(foodDescription);

        item.setSeq(fields[1]);

        session.save("Weight", item);
    }

}
