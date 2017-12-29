package greg.info.dao.dataValadition;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDataKey;
import greg.info.dao.entities.NutrientDefinition;
import greg.info.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class ElementCountTests {
    private final Session session;

    ElementCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void waterTest() {
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

    }
}
