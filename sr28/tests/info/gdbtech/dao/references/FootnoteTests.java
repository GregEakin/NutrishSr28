package info.gdbtech.dao.references;

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.Footnote;
import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;
import java.util.stream.Stream;

@ExtendWith(NutrishRepositoryExtension.class)
public class FootnoteTests {
    private final Session session;

    FootnoteTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by NDB_No
    @Test
    public void foodDescriptionTest() {
        Footnote footnote = session.load(Footnote.class, 2763);

        FoodDescription foodDescription = footnote.getFoodDescription();
        Assertions.assertEquals("02053", foodDescription.getNDB_No());
    }

    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    @Test
    public void nutrientDataTest1() {
        Footnote footnote = session.load(Footnote.class, 2763);
        FoodDescription foodDescription = footnote.getFoodDescription();

        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
        Assertions.assertEquals(72, nutrientDataSet.size());
    }

    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    @Test
    public void nutrientDataTest2() {
        Footnote footnote = session.load(Footnote.class, 2763);
        FoodDescription foodDescription = footnote.getFoodDescription();
        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();

        Stream<NutrientData> nutrientDataStreamStream = nutrientDataSet.stream().filter(o -> o.getNutrientDataKey().getNutrientDefinition() == footnote.getNutrientDefinition());
        NutrientData nutrientData = (NutrientData) nutrientDataStreamStream.toArray()[0];
        Assertions.assertEquals("02053", nutrientData.getNutrientDataKey().getFoodDescription().getNDB_No());
        Assertions.assertEquals("208", nutrientData.getNutrientDataKey().getNutrientDefinition().getNutr_No());
    }

    //  Links to the Nutrient Definition file by Nutr_No, when applicable
    @Test
    public void nutrientDefinitionTest() {
        Footnote footnote = session.load(Footnote.class, 2763);

        NutrientDefinition nutrientDefinition = footnote.getNutrientDefinition();
        Assertions.assertEquals("208", nutrientDefinition.getNutr_No());
    }
}


