package greg.info.dao.dataValadition;

import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientCountTests {

    private final Session session;

    NutrientCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void waterCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
        Assertions.assertEquals("Water", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("WATER", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8788, nutrientDataSet.size());
    }

    @Test
    public void energyKcalCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "208");
        Assertions.assertEquals("Energy", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("ENERC_KCAL", nutrientDefinition.getTagname());
        Assertions.assertEquals("kcal   ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }

    @Test
    void glucoseCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "211");
        Assertions.assertEquals("Glucose (dextrose)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("GLUS", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(1752, nutrientDataSet.size());
    }

    @Test
    void fatCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Assertions.assertEquals("Total lipid (fat)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("FAT", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }
}
