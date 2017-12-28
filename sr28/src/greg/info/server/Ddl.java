package greg.info.server;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.io.File;
import java.util.EnumSet;

public class Ddl {
    public static void main(String[] args) throws Exception {

        String filename = "db-schema.hibernate5.ddl";
        File file = new File(filename);
        file.delete();

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("/hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .buildMetadata();

        new SchemaExport()
                .setOutputFile(filename)
                .create(EnumSet.of(TargetType.SCRIPT), metadata);

        metadata.buildSessionFactory().close();
    }

}
