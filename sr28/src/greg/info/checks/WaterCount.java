package greg.info.checks;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDataKey;
import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class WaterCount {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
                    System.out.println(nutrientDefinition.getNutr_No()
                            + " " + nutrientDefinition.getNutrDesc()
                            + " " + nutrientDefinition.getUnits());

                    Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
                    System.out.println("   NutData Cout: " + nutrientDataSet.size());
                    int count = 0;
                    for (NutrientData nutrientData : nutrientDataSet) {
                        NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
                        System.out.print("    NutData: " + nutrientData.getNutr_Val());

                        FoodDescription foodDescription = nutrientData.getNutrientDataKey().getFoodDescription();
                        System.out.println(" " + foodDescription.getLong_Desc());

                        if (++count > 15)
                            break;
                    }
                } catch (Exception ex) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
    }
}
