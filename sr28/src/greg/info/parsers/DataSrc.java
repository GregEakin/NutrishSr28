package greg.info.parsers;

import greg.info.entities.DataSource;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataSrc {
    public static final String Filename = ".\\data\\DATA_SRC.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);
        DataSource item = parseDataSource(fields);
        session.save(item);
    }

    private static DataSource parseDataSource(final String[] fields) {

        DataSource item = new DataSource();
        return item;
    }
}
