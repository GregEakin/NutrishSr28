package greg.info.relational.parsers;

import greg.info.relational.entities.DataDerivation;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DerivCD {
    public static final String Filename = ".\\data\\DERIV_CD.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        DataDerivation item = new DataDerivation();
        item.setDeriv_Cd(fields[0].substring(1, fields[0].length() - 1));
        item.setDeriv_Desc(fields[1].substring(1, fields[1].length() - 1));

        session.save(item);
    }
}
