/*
 * Copyright (c) 2017. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.gdbtech.dao.dataValadition;

import info.gdbtech.dao.entities.*;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(NutrishRepositoryExtension.class)
public class YogurtTests {
    private final Session session;

    YogurtTests(Session session) {
        this.session = session;
    }

    @Test
    public void foodDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        assertEquals("01119", foodDescription.getNDB_No());
        assertEquals("Yogurt, vanilla, low fat, 11 grams protein per 8 ounce", foodDescription.getLong_Desc());
        assertEquals("YOGURT,VANILLA,LOFAT,11 GRAMS PROT PER 8 OZ", foodDescription.getShrt_Desc());
        assertEquals(3.87, foodDescription.getCHO_Factor().doubleValue());
        assertEquals(4.27, foodDescription.getPro_Factor().doubleValue());
        assertEquals(6.38, foodDescription.getN_Factor().doubleValue());
    }

    @Test
    public void foodGroupTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        FoodGroup foodGroup = foodDescription.getFoodGroup();

        assertEquals("0100", foodGroup.getFdGrp_Cd());
        assertEquals("Dairy and Egg Products", foodGroup.getFdGrp_Desc());
    }

    @Test
    public void foodDescriptionLoopbackTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();

        assertEquals(91, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            assertSame(foodDescription, nutrientDataKey.getFoodDescription());
        }
    }

    @Test
    public void nutrientDefinitionLoopbackTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();

        assertEquals(8789, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            assertSame(nutrientDefinition, nutrientDataKey.getNutrientDefinition());
        }
    }

    @Test
    public void nutrientDefinitionTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        assertEquals("204", nutrientDefinition.getNutr_No());
        assertEquals("Total lipid (fat)", nutrientDefinition.getNutrDesc());
        assertEquals("FAT", nutrientDefinition.getTagname());
        assertEquals("g", nutrientDefinition.getUnits());
    }

    @Test
    public void nutrientDataTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);
        assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        assertEquals(new Double(1.25), nutrientData.getNutr_Val());
        assertNull(nutrientData.getMax());
        assertNull(nutrientData.getMin());
        assertNull(nutrientData.getLow_EB());
        assertNull(nutrientData.getUp_EB());
    }

    @Test
    public void weightTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        Set<Weight> weightSet = foodDescription.getWeightSet();
        assertEquals(3, weightSet.size());

        for (Weight weight : weightSet) {
            assertEquals(1.0, weight.getAmount().doubleValue());
            assertNull(weight.getStd_Dev());
            switch (weight.getWeightKey().getSeq()) {
                case "1 ":
                    assertEquals(170.0, weight.getGm_Wgt().doubleValue());
                    assertEquals("container (6 oz)", weight.getMsre_Desc());
                    break;
                case "2 ":
                    assertEquals(227.0, weight.getGm_Wgt().doubleValue());
                    assertEquals("container (8 oz)", weight.getMsre_Desc());
                    break;
                case "3 ":
                    assertEquals(245.0, weight.getGm_Wgt().doubleValue());
                    assertEquals("cup (8 fl oz)", weight.getMsre_Desc());
                    break;
            }
        }
    }

    @Test
    public void FoodDescriptionFootnoteTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "05315");
        Set<Footnote> footnoteSet = foodDescription.getFootnoteSet();
        assertEquals(3, footnoteSet.size());
        for (Footnote footnote : footnoteSet) {
            System.out.println("    Footnote: " + footnote.getFootnt_Txt());
        }
    }

    @Test
    public void nutrientDefinitionFootnoteTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<Footnote> footnoteSet = nutrientDefinition.getFootnoteSet();
        assertEquals(13, footnoteSet.size());

        FoodDescription foodDescription = session.load(FoodDescription.class, "04673");
        assertTrue(footnoteSet.stream().anyMatch(o -> o.getFoodDescription() == foodDescription));
        assertTrue(footnoteSet.stream().map(Footnote::getFoodDescription).anyMatch(foodDescription::equals));

//        Stream<FoodDescription> foodDescriptionStream = footnoteSet.stream().map(Footnote::getFoodDescription).filter(o -> o.getNDB_No() == "04673");
//        FoodDescription f2 = foodDescriptionStream.findFirst().get();
//        Assertions.assertSame(foodDescription, f2);

        for (Footnote footnote : footnoteSet) {
            System.out.println("    Footnote: " + footnote.getFootnt_Txt() + " " + footnote.getFoodDescription().getNDB_No());

            if (footnote.getFoodDescription().getNDB_No().equals("04673"))
                assertEquals("contains 2.841 g omega-3 fatty acids", footnote.getFootnt_Txt());
        }
    }

    @Test
    public void sourceCodeTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        SourceCode sourceCode = nutrientData.getSourceCode();
        assertEquals("1", sourceCode.getSrc_Cd());
        assertEquals("Analytical or derived from analytical", sourceCode.getSrcCd_Desc());
    }

    @Test
    public void dataDerivationTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "313");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        DataDerivation dataDerivation = nutrientData.getDataDerivation();
        assertEquals("A", dataDerivation.getDeriv_Cd());
        assertEquals("Analytical data", dataDerivation.getDeriv_Desc());
    }
}