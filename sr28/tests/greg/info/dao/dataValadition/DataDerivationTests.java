package greg.info.dao.dataValadition;

import greg.info.dao.entities.DataDerivation;
import greg.info.dao.entities.NutrientData;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class DataDerivationTests {
    private final Session session;

    DataDerivationTests(Session session) {
        this.session = session;
    }

    //  Links to the Nutrient Data file by Deriv_Cd
    @Test
    public void nutrientDataTest() {
        DataDerivation dataDerivation = session.load(DataDerivation.class, "RC  ");
        Set<NutrientData> nutrientDataSet = dataDerivation.getNutrientDataSet();
        Assertions.assertEquals(2358, nutrientDataSet.size());
    }
}


