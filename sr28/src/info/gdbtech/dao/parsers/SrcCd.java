package info.gdbtech.dao.parsers;

import info.gdbtech.dao.entities.SourceCode;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SrcCd {
    public static final String Filename = ".\\data\\SRC_CD.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        SourceCode item = new SourceCode();
        item.setSrc_Cd(fields[0].substring(1, fields[0].length() - 1));
        item.setSrcCd_Desc(fields[1].substring(1, fields[1].length() - 1));
        session.save(item);
    }
}
