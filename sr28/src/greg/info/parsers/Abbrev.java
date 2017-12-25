package greg.info.parsers;

import greg.info.entities.Abbreviations;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Abbrev {
    public static final String Filename = ".\\data\\ABBREV.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);
        Abbreviations item = parseAbbreviation(fields);
        session.save(item);
    }

    private static Abbreviations parseAbbreviation(final String[] fields) {

        Abbreviations item = new Abbreviations();
        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));
        item.setShrt_Desc(fields[1].substring(1, fields[1].length() - 1));
        if (fields[2].length() > 0) item.setWater(Double.parseDouble(fields[2]));
        // TODO -- Missing fields
        return item;
    }
}
