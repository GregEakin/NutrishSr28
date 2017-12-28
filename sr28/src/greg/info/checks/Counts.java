package greg.info.checks;

import greg.info.flatfile.entities.Abbreviations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Counts {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    //Object count = session.createCriteria("Abbreviations").setProjection(Projections.rowCount()).uniqueResult();
                    //Query count = session.createQuery("select count(*) from Abbreviations");

                    Criteria c = session.createCriteria(Abbreviations.class);

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
}
