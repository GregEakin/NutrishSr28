package greg.info.relational.parsers;

import greg.info.relational.entities.DataSource;
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
        item.setDataSrc_ID(fields[0].substring(1, fields[0].length() - 1));
        if (fields[1].length() > 2) item.setAuthors(fields[1].substring(1, fields[1].length() - 1));
        item.setTitle(fields[2].substring(1, fields[2].length() - 1));
        if (fields[3].length() > 2) item.setYear(fields[3].substring(1, fields[3].length() - 1));
        if (fields[4].length() > 2) item.setJournal(fields[4].substring(1, fields[4].length() - 1));
        if (fields[5].length() > 2) item.setVol_City(fields[5].substring(1, fields[5].length() - 1));
        if (fields[6].length() > 2) item.setIssue_State(fields[6].substring(1, fields[6].length() - 1));
        if (fields[7].length() > 2) item.setStart_Page(fields[7].substring(1, fields[7].length() - 1));
        if (fields[8].length() > 2) item.setEnd_Page(fields[8].substring(1, fields[8].length() - 1));
        return item;
    }
}
