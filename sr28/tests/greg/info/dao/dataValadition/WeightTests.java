package greg.info.dao.dataValadition;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.Weight;
import greg.info.dao.entities.WeightKey;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class WeightTests {
    private final Session session;

    WeightTests(Session session) {
        this.session = session;
    }

    //  Links to Food Description file by NDB_No
    @Test
    public void foodDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        WeightKey weightKey = new WeightKey(foodDescription, "3 ");
        Weight weight = session.load(Weight.class, weightKey);

        Assertions.assertSame(foodDescription, weight.getWeightKey().getFoodDescription());
    }

    //  Links to Nutrient Data file by NDB_No
    @Test
    public void nutrientDataTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        WeightKey weightKey = new WeightKey(foodDescription, "3 ");
        Weight weight = session.load(Weight.class, weightKey);

        Set<NutrientData> nutrientDataSet = weight.getWeightKey().getFoodDescription().getNutrientDataSet();
        Assertions.assertEquals(91, nutrientDataSet.size());
    }
}


