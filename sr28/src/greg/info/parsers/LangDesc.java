package greg.info.parsers;

import greg.info.entities.LanguaL;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LangDesc {
    public static final String Filename = ".\\data\\LANGDESC.txt";

    public static void fileLanguaL(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> lineLanguaL(session, line));
        }
    }

    public static void lineLanguaL(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        greg.info.entities.LanguaL item = new LanguaL();
        item.setFactor_Code(fields[0].substring(1, fields[0].length() - 1));
        item.setDescription(fields[1].substring(1, fields[1].length() - 1));

        session.save("LanguaL", item);
    }

}
