package greg.info;

import greg.info.relational.parsers.LanguaL;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbLoad {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
//                    FdGroup.parseFile(session);
//                    SrcCd.parseFile(session);
//                    DerivCD.parseFile(session);
//                    LangDesc.parseFile(session);
//                    DataSrc.parseFile(session);
//
//                    NutrDef.parseFile(session);
//                    FoodDes.parseFile(session);
                    LanguaL.parseFile(session);
//                    Weight.parseFile(session);
//                    DatScrLn.parseFile(session);
//                    NutData.parseFile(session);
//                    Footnote.parseFile(session);

                    transaction.commit();
                } catch (Exception ex) {
                    transaction.rollback();
                    throw ex;
                }
            }

            // DumpEntities(sessionFactory);
            // dump();
        }
    }

    private static void DumpEntities(SessionFactory sessionFactory) {
        try (final Session session = sessionFactory.openSession()) {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        }
    }

    public static void dump() {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql:nutrhis", "SA", "0xB5HweaDz")) {

                LanguaL.sqlSelectRows(con);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
