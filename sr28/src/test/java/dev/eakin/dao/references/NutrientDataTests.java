/*
 * Copyright (c) 2019. Greg Eakin
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

package dev.eakin.dao.references;

import dev.eakin.dao.entities.*;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

        assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        assertSame(foodDescription, nutrientData.getNutrientDataKey().getFoodDescription());
    }

    //  Links to the Weight file by NDB_No
//    @Test
//    public void weightTest() {
//        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
//        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
//        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
//        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);
//
//        Set<Weight> weightSet = nutrientData.getNutrientDataKey().getFoodDescription().getWeightSet();
//        assertEquals(3, weightSet.size());
//    }

    //  Links to the Footnote file by NDB_No
    @Test
    public void footnoteTest1() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "12040");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        Set<Footnote> footnoteSet = nutrientDataKey.getFoodDescription().getFootnoteSet();
        assertEquals(2, footnoteSet.size());
        for (Footnote footnote : footnoteSet) {
            assertEquals("12040", footnote.getFoodDescription().getNDB_No());
            assertNull(footnote.getNutrientDefinition());
        }
    }

    //  Links to the Footnote file by NDB_No and when applicable, Nutr_No
    @Test
    public void footnoteTest2() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "03073");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "320");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);

        String hql = "FROM Footnote WHERE foodDescription.NDB_No = :ndb_no and nutrientDefinition.nutr_No = :nutr_no";
        Query<Footnote> query = session.createQuery(hql, Footnote.class);
        query.setParameter("ndb_no", nutrientDataKey.getFoodDescription().getNDB_No());
        query.setParameter("nutr_no", nutrientDataKey.getNutrientDefinition().getNutr_No());
        Footnote footnote = query.getSingleResult();

        assertEquals("03073", footnote.getFoodDescription().getNDB_No());
        assertEquals("320", footnote.getNutrientDefinition().getNutr_No());
    }

    //  Links to the Sources of Data Link file by NDB_No and Nutr_No
    @Test
    public void DataSourceTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "313");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        Set<DataSource> dataSourceSet = nutrientData.getDataSourceSet();
        assertEquals(1, dataSourceSet.size());
    }

    //  Links to the Nutrient Definition file by Nutr_No
    @Test
    public void NutrientDefinitionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        assertSame(nutrientDataKey, nutrientData.getNutrientDataKey());
        assertSame(nutrientDefinition, nutrientData.getNutrientDataKey().getNutrientDefinition());
    }

    //  Links to the Source Code file by Src_Cd
    @Test
    public void sourceCodeTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "317");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        SourceCode sourceCode = nutrientData.getSourceCode();
        assertEquals("4", sourceCode.getSrc_Cd());
        assertEquals("Calculated or imputed", sourceCode.getSrcCd_Desc());
    }

    //  Links to the Data Derivation Code Description file by Deriv_Cd
    @Test
    public void DataDerivationTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "317");
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = session.load(NutrientData.class, nutrientDataKey);

        DataDerivation dataDerivation = nutrientData.getDataDerivation();
        assertEquals("BFNN", dataDerivation.getDeriv_Cd());
        assertEquals("Based on another form of the food or similar food; Concentration adjustment; Non-fat solids; Retention factors not used", dataDerivation.getDeriv_Desc());
    }
}

