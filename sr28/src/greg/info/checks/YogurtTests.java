package greg.info.checks;

import greg.info.dao.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class YogurtTests {
    // SELECT
    //  NDB_NO,
    //  LONG_DESC,
    //  TAGNAME,
    //  NUTRDESC,
    //  NUTR_VAL,
    //  UNITS
    //FROM NUTR_DEF, NUT_DATA, FOOD_DES
    //WHERE NUTR_DEF.NUTR_NO = NUT_DATA.NUTR_NO AND
    //      NUT_DATA.NDB_NO = FOOD_DES.NDB_NO AND
    //      NDB_NO = '01119'
    //ORDER BY UNITS, NUTR_VAL DESC;

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                try {
                    FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
                    System.out.println(foodDescription.getNDB_No()
                            + ", " + foodDescription.getLong_Desc());

                    Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
                    for (NutrientData nutrientData : nutrientDataSet) {
                        NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();

                        System.out.print("    NutData: " + nutrientData.getNutr_Val());

                        NutrientDefinition nutrientDefinition = nutrientDataKey.getNutrientDefinition();
                        System.out.println(", " + nutrientDefinition.getUnits()
                                + ", " + nutrientDefinition.getTagname()
                                + ", " + nutrientDefinition.getNutrDesc());

//                        Set<Footnote> footnoteSet = nutrientDefinition.getFootnoteSet();
//                        for (Footnote footnote : footnoteSet) {
//                            System.out.println("  Footnote: " + footnote.getFootnt_Txt());
//                        }

//                        SourceCode sourceCode = nutrientData.getSourceCode();
//                        System.out.println("   Source: " + sourceCode.getSrcCd_Desc());
//
//                        DataDerivation dataDerivationSet = nutrientData.getDataDerivation();
//                        System.out.println("   DataDerivation: " + dataDerivationSet.getDeriv_Desc());
                    }

                    Set<Weight> weightSet = foodDescription.getWeightSet();
                    for (Weight weight : weightSet) {
                        System.out.println("    Weight: " + weight.getAmount()
                                + " " + weight.getGm_Wgt()
                                + " " + weight.getMsre_Desc());
                    }

                    Set<Footnote> footnoteSet = foodDescription.getFootnoteSet();
                    for (Footnote footnote : footnoteSet) {
                        System.out.println("    Footnote: " + footnote.getFootnt_Txt());
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
