package info.gdbtech.dao.dataValadition;

import info.gdbtech.dao.entities.*;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class YogurtTests {
    private final Session session;

    YogurtTests(Session session) {
        this.session = session;
    }

    @Test
    public void foodDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        Assertions.assertEquals("01119", foodDescription.getNDB_No());
        Assertions.assertEquals("Yogurt, vanilla, low fat, 11 grams protein per 8 ounce", foodDescription.getLong_Desc());
        Assertions.assertEquals("YOGURT,VANILLA,LOFAT,11 GRAMS PROT PER 8 OZ", foodDescription.getShrt_Desc());
        Assertions.assertEquals(new Double(3.87), foodDescription.getCHO_Factor());
        Assertions.assertEquals(new Double(4.27), foodDescription.getPro_Factor());
        Assertions.assertEquals(new Double(6.38), foodDescription.getN_Factor());
    }

    @Test
    public void foodGroupTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        FoodGroup foodGroup = foodDescription.getFoodGroup();

        Assertions.assertEquals("0100", foodGroup.getFdGrp_Cd());
        Assertions.assertEquals("Dairy and Egg Products", foodGroup.getFdGrp_Desc());
    }

    @Test
    public void foodDescriptionLoopbackTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();

        Assertions.assertEquals(91, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            Assertions.assertSame(foodDescription, nutrientDataKey.getFoodDescription());
        }
    }

    @Test
    public void nutrientDefinitionLoopbackTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();

        Assertions.assertEquals(8789, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            Assertions.assertSame(nutrientDefinition, nutrientDataKey.getNutrientDefinition());
        }
    }

    @Test
    public void nutrientDefinitionTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Assertions.assertEquals("204", nutrientDefinition.getNutr_No());
        Assertions.assertEquals("Total lipid (fat)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("FAT", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());
    }

    @Test
    public void nutrientDataTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);
        Assertions.assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        Assertions.assertEquals(new Double(1.25), nutrientData.getNutr_Val());
        Assertions.assertNull(nutrientData.getMax());
        Assertions.assertNull(nutrientData.getMin());
        Assertions.assertNull(nutrientData.getLow_EB());
        Assertions.assertNull(nutrientData.getUp_EB());
    }

    @Test
    public void weightTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        Set<Weight> weightSet = foodDescription.getWeightSet();
        Assertions.assertEquals(3, weightSet.size());

        for (Weight weight : weightSet) {
            Assertions.assertEquals(new Double(1), weight.getAmount());
            Assertions.assertNull(weight.getStd_Dev());
            switch (weight.getWeightKey().getSeq()) {
                case "1 ":
                    Assertions.assertEquals(new Double(170), weight.getGm_Wgt());
                    Assertions.assertEquals("container (6 oz)", weight.getMsre_Desc());
                    break;
                case "2 ":
                    Assertions.assertEquals(new Double(227), weight.getGm_Wgt());
                    Assertions.assertEquals("container (8 oz)", weight.getMsre_Desc());
                    break;
                case "3 ":
                    Assertions.assertEquals(new Double(245), weight.getGm_Wgt());
                    Assertions.assertEquals("cup (8 fl oz)", weight.getMsre_Desc());
                    break;
            }
        }
    }

    @Test
    public void FoodDescriptionFootnoteTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "05315");
        Set<Footnote> footnoteSet = foodDescription.getFootnoteSet();
        Assertions.assertEquals(3, footnoteSet.size());
        for (Footnote footnote : footnoteSet) {
            System.out.println("    Footnote: " + footnote.getFootnt_Txt());
        }
    }

    @Test
    public void nutrientDefinitionFootnoteTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<Footnote> footnoteSet = nutrientDefinition.getFootnoteSet();
        Assertions.assertEquals(13, footnoteSet.size());

        FoodDescription foodDescription = session.load(FoodDescription.class, "04673");
        Assertions.assertTrue(footnoteSet.stream().anyMatch(o -> o.getFoodDescription() == foodDescription));
        Assertions.assertTrue(footnoteSet.stream().map(Footnote::getFoodDescription).anyMatch(foodDescription::equals));

//        Stream<FoodDescription> foodDescriptionStream = footnoteSet.stream().map(Footnote::getFoodDescription).filter(o -> o.getNDB_No() == "04673");
//        FoodDescription f2 = foodDescriptionStream.findFirst().get();
//        Assertions.assertSame(foodDescription, f2);

        for (Footnote footnote : footnoteSet) {
            System.out.println("    Footnote: " + footnote.getFootnt_Txt() + " " + footnote.getFoodDescription().getNDB_No());

            if (footnote.getFoodDescription().getNDB_No() == "04673")
                Assertions.assertEquals("contains 2.841 g omega-3 fatty acids", footnote.getFootnt_Txt());
        }
    }

    @Test
    public void sourceCodeTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        SourceCode sourceCode = nutrientData.getSourceCode();
        Assertions.assertEquals("1 ", sourceCode.getSrc_Cd());
        Assertions.assertEquals("Analytical or derived from analytical", sourceCode.getSrcCd_Desc());
    }

    @Test
    public void dataDerivationTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "313");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        DataDerivation dataDerivation = nutrientData.getDataDerivation();
        Assertions.assertEquals("A   ", dataDerivation.getDeriv_Cd());
        Assertions.assertEquals("Analytical data", dataDerivation.getDeriv_Desc());
    }
}