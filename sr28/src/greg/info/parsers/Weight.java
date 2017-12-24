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

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> praseLine(session, line));
        }
    }


    private static void praseLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        greg.info.entities.Weight item = new greg.info.entities.Weight();

        // NDB_No A 5* N 5-digit Nutrient Databank number that uniquely identifies a food item.
        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        item.setFoodDescription(foodDescription);

        // Seq A 2* N Sequence number.
        item.setSeq(fields[1]);

        // Amount N 5.3 N Unit modifier (for example, 1 in “1 cup”).
        item.setAmount(Double.parseDouble(fields[2]));

        // Msre_Desc A 84 N Description (for example, cup, diced, and 1-inch pieces).
        String description = fields[3].substring(1, fields[3].length() - 1);
        item.setMsre_Desc(description);

        // Gm_Wgt N 7.1 N Gram weight.
        item.setGm_Wgt(Double.parseDouble(fields[4]));

        // Num_Data_Pts N 3 Y Number of data points.
        if (fields[5].length() > 0) item.setNum_Data_Pts(Integer.parseInt(fields[5]));

        // Std_Dev N 7.3 Y Standard deviation.
        if (fields[6].length() > 0) item.setStd_Dev(Double.parseDouble(fields[6]));

        session.save("Weight", item);
    }
}
