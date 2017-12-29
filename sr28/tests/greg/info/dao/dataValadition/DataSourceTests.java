package greg.info.dao.dataValadition;

import greg.info.dao.entities.DataSource;
import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class DataSourceTests {
    private final Session session;

    DataSourceTests(Session session) {
        this.session = session;
    }

    //  Links to Nutrient Data file by NDB No. through the Sources of Data Link file
    @Test
    public void nutrientDataTest() {
        DataSource dataSource = session.load(DataSource.class, "D642  ");

        Set<NutrientData> nutrientDataSet = dataSource.getNutrientDataSet();
        Assertions.assertEquals(2, nutrientDataSet.size());
    }

    //  Links to the Nutrient Definition file by Nutr_No
    @Test
    public void nutrientDefinitionTest() {
        DataSource dataSource = session.load(DataSource.class, "D642  ");

        Set<NutrientData> nutrientDataSet = dataSource.getNutrientDataSet();
        Assertions.assertEquals(2, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDefinition nutrientDefinition = nutrientData.getNutrientDataKey().getNutrientDefinition();
            System.out.println(nutrientDefinition.getNutr_No());
            // Todo: 306, and 307
        }
    }
}



