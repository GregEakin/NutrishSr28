package greg.info.dao.dataValadition;

import greg.info.dao.entities.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;
import java.util.stream.Stream;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientDataTests {
    private final Session session;

    NutrientDataTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by Ref_NDB_No
    @Test
    public void foodDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Assertions.assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        Assertions.assertSame(foodDescription, nutrientData.getNutrientDataKey().getFoodDescription());
    }

    //  Links to the Weight file by NDB_No
    @Ignore
    @Test
    public void weightTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Set<Weight> weightSet = nutrientData.getNutrientDataKey().getFoodDescription().getWeightSet();
        Assertions.assertEquals(3, weightSet.size());
    }

    //  Links to the Footnote file by NDB_No and when applicable, Nutr_No
    @Test
    public void footnoteTest1() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Set<Footnote> footnoteSet = nutrientData.getNutrientDataKey().getNutrientDefinition().getFootnoteSet();
        Assertions.assertEquals(13, footnoteSet.size());
    }

    //  Links to the Footnote file by NDB_No and when applicable, Nutr_No
    @Test
    public void footnoteTest2() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Set<Footnote> footnoteSet = nutrientData.getNutrientDataKey().getNutrientDefinition().getFootnoteSet();
        Stream<Footnote> footnoteStream = footnoteSet.stream().filter(o -> o.getNutrientDefinition().getNutr_No() == nutrientData.getNutrientDataKey().getNutrientDefinition().getNutr_No());
        Footnote footnote = (Footnote) footnoteStream.toArray()[0];
        Assertions.assertEquals("Total proximates do not equal 100% because piperine was subtracted from lipid value.", footnote.getFootnt_Txt());
    }

    //  Links to the Sources of Data Link file by NDB_No and Nutr_No
    @Test
    public void DataSourceTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "313");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Set<DataSource> dataSourceSet = nutrientData.getDataSourceSet();
        Assertions.assertEquals(1, dataSourceSet.size());
    }

    //  Links to the Nutrient Definition file by Nutr_No
    @Test
    public void NutrientDefinitionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Assertions.assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        Assertions.assertSame(nutrientDefinition, nutrientData.getNutrientDataKey().getNutrientDefinition());
    }

    //  Links to the Source Code file by Src_Cd
    @Test
    public void sourceCodeTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "317");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        SourceCode sourceCode = nutrientData.getSourceCode();
        Assertions.assertEquals("4 ", sourceCode.getSrc_Cd());
        Assertions.assertEquals("Calculated or imputed", sourceCode.getSrcCd_Desc());
    }

    //  Links to the Data Derivation Code Description file by Deriv_Cd
    @Test
    public void DataDerivationTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "317");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        DataDerivation dataDerivation = nutrientData.getDataDerivation();
        Assertions.assertEquals("BFNN", dataDerivation.getDeriv_Cd());
        Assertions.assertEquals("Based on another form of the food or similar food; Concentration adjustment; Non-fat solids; Retention factors not used", dataDerivation.getDeriv_Desc());
    }
}

