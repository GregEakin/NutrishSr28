package greg.info.server;

import greg.info.relational.entities.FoodDescription;
import greg.info.relational.entities.FoodGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class NutGroupTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    FoodGroup foodGroup = session.load(FoodGroup.class, "1200");
                    System.out.println(foodGroup.getFdGrp_Cd() + ", " + foodGroup.getFdGrp_Desc());
                    Set<FoodDescription> foodDescriptionSet = foodGroup.getFoodDescriptionSet();
                    for (FoodDescription foodDescription : foodDescriptionSet) {
                        System.out.println("  " + foodDescription.getNDB_No() + " " + foodDescription.getShrt_Desc());
                    }
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
