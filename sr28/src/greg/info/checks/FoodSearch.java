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

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FoodSearch {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    FoodDescription foodDescription = session.load(FoodDescription.class, "01001");
                    System.out.println("Basic Report: " + foodDescription.getNDB_No()
                            + ", " + foodDescription.getLong_Desc());

                    System.out.println("   Weight: Value per 100 g");
                    Set<greg.info.dao.entities.Weight> weightSet = foodDescription.getWeightSet();
                    for (greg.info.dao.entities.Weight weight : weightSet) {
                        System.out.println("   Weight: " + weight.getMsre_Desc() + ", " + weight.getAmount() + " x " + weight.getGm_Wgt() + " g");
                    }

                    Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
                    Comparator<NutrientData> nutrientDataComparator = Comparator.comparingInt(o -> o.getNutrientDataKey().getNutrientDefinition().getSR_Order());
                    List<NutrientData> data = nutrientDataSet.stream().sorted(nutrientDataComparator).collect(Collectors.toList());
                    for (NutrientData nutrientData : data) {
                        NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
                        NutrientDefinition nutrientDefinition = nutrientDataKey.getNutrientDefinition();

                        System.out.println("   NutData: " + nutrientDefinition.getSR_Order()
                                + ", " + nutrientDefinition.getNutrDesc()
                                + " = " + nutrientData.getNutr_Val()
                                + " " + nutrientDefinition.getUnits());

                    }
                } catch (Exception ex) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
    }
}
