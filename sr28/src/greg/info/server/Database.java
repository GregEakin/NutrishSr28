package greg.info.server;

import java.util.Arrays;

public class Database {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        args = Arrays.copyOf(args, args.length + 4);
        args[args.length - 4] = "--trace";
        args[args.length - 3] = "false";
        args[args.length - 2] = "--props";
        args[args.length - 1] = ".\\sr28\\hsqldb\\server.properties";

        for (String item : args) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();

        org.hsqldb.server.Server.main(args);
    }
}
