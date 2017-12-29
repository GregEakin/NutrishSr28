package greg.info.dao.dataValadition;

import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientDefinitionTests {
    private final Session session;

    NutrientDefinitionTests(Session session) {
        this.session = session;
    }

    //  Links to the Nutrient Data file by Nutr_No
    @Test
    public void nutrientDataTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }
}

