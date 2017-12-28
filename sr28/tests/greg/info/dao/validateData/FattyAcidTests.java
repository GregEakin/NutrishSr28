package greg.info.dao.validateData;

import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NutrishRepositoryExtension.class)
public class FattyAcidTests {
    private final Session session;

    FattyAcidTests(Session session) {
        this.session = session;
    }

    @Test
    public void butyricTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "607");
        Assertions.assertEquals("4:0", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F4D0", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }

    @Test
    public void caproicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "608");
        Assertions.assertEquals("6:0", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F6D0", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }

    @Test
    public void myristoleicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "625");
        Assertions.assertEquals("14:1", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F14D1", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }
}
