package greg.info;

import greg.info.parsers.*;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestFoodDes {
    public static void main(String[] args) throws Exception {

        URL configUrl = HibernateUtil.class.getResource("/hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure(configUrl);
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                Abbrev.fileAbbreviations(session);
                FdGroup.fileFoodGroup(session);
                FoodDes.fileFoodDescription(session);
                // NutrientData
                // Footnote
                Weight.fileWeight(session);
                LangDesc.fileLanguaL(session);
                LanguaL.fileLanguaLMap(session);
                transaction.commit();
            }

            DumpEntities(sessionFactory);
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
                    "jdbc:hsqldb:mem:howtodoinjava", "SA", "1")) {

                LanguaL.sqlSelectRows(con);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
