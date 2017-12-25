package greg.info.parsers;

import greg.info.entities.FoodDescription;
import greg.info.entities.NutrientData;
import greg.info.entities.NutrientDefinition;
import greg.info.entities.SourceCode;
import org.hibernate.Session;

import java.io.IOException;

public class NutData {
    public static final String Filename = ".\\data\\NUT_DATA.txt";

    public static void parseFile(final Session session) throws IOException {
        // TODO
//        Path path = Paths.get(Filename);
//        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
//            lines.forEach((line) -> parseLine(session, line));
//        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        NutrientData item = new NutrientData();

        String NDB_No = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, NDB_No);
        item.setFoodDescription(foodDescription);

        String Nutr_No = fields[1].substring(1, fields[1].length() - 1);
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, Nutr_No);
        item.setNutrientDefinition(nutrientDefinition);

        item.setNutr_Val(Double.parseDouble(fields[2]));

        item.setNum_Data_Pts(Integer.parseInt(fields[3]));

        String Src_Cd = fields[5].substring(1, fields[5].length() - 1);
        SourceCode sourceCode = session.load(SourceCode.class, Src_Cd);
        item.setSourceCode(sourceCode);

        System.out.println(foodDescription.getNDB_No() + ", " + nutrientDefinition.getNutr_No());
        session.save(item);
    }
}
