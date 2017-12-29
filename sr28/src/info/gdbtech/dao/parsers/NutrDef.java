package info.gdbtech.dao.parsers;

import info.gdbtech.dao.entities.NutrientDefinition;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NutrDef {
    public static final String Filename = ".\\data\\NUTR_DEF.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        NutrientDefinition item = new NutrientDefinition();

        item.setNutr_No(fields[0].substring(1, fields[0].length() - 1));
        item.setUnits(fields[1].substring(1, fields[1].length() - 1));
        if (fields[2].length() > 2) item.setTagname(fields[2].substring(1, fields[2].length() - 1));
        item.setNutrDesc(fields[3].substring(1, fields[3].length() - 1));
        item.setNum_Dec(fields[4].substring(1, fields[4].length() - 1));
        item.setSR_Order(Integer.parseInt(fields[5].substring(1, fields[5].length() - 1)));

        session.save(item);
    }
}
