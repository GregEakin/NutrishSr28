package info.gdbtech.dao.references;

import info.gdbtech.dao.entities.DataSource;
import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.NutrientDataKey;
import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
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

        String nutrKeys[] = nutrientDataSet.stream()
                .map(NutrientData::getNutrientDataKey)
                .map(NutrientDataKey::getNutrientDefinition)
                .map(NutrientDefinition::getNutr_No)
                .sorted()
                .toArray(String[]::new);
        Assertions.assertArrayEquals(new String[]{"306", "307"}, nutrKeys);
    }
}
