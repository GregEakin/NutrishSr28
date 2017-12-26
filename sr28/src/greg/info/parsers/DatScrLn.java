package greg.info.parsers;

import greg.info.entities.DataSourceLink;
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
        String Nutr_No = fields[1].substring(1, fields[1].length() - 1);
        String DataSrc_ID = fields[2].substring(1, fields[2].length() - 1);

        DataSourceLink item = new DataSourceLink();

        item.setNDB_No(NDB_No);
        item.setNutr_No(Nutr_No);
        item.setDataSrc_ID(DataSrc_ID);
        session.save(item);

//        DataSource dataSource = session.load(DataSource.class, DataSrc_ID);
//        NutrientData.NutrientDataKey nutrientDataKey = new NutrientData.NutrientDataKey(NDB_No, Nutr_No);
//        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);
//
//        dataSource.getNutrientDataSet().add(nutrientData);
//        nutrientData.getDataSourceSet().add(dataSource);
//        session.save(dataSource);
//        session.save(nutrientData);
    }
}
