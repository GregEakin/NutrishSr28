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

package info.gdbtech.dao.references;

import info.gdbtech.dao.entities.*;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodDescriptionTests {
    private final Session session;

    FoodDescriptionTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Group Description file by the FdGrp_Cd field
    @Test
    public void foodGroupDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");

        FoodGroup foodGroup = foodDescription.getFoodGroup();
        Assertions.assertEquals("0100", foodGroup.getFdGrp_Cd());
        Assertions.assertEquals("Dairy and Egg Products", foodGroup.getFdGrp_Desc());
    }

    //  Links to the Nutrient Data file by the NDB_No field
    @Test
    public void NutrientDataTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");

        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
        Assertions.assertEquals(91, nutrientDataSet.size());
    }

    //  Links to the Weight file by the NDB_No field
    @Test
    public void WeightTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");

        Set<Weight> weightSet = foodDescription.getWeightSet();
        Assertions.assertEquals(3, weightSet.size());
    }

    //  Links to the Footnote file by the NDB_No field
    @Test
    public void FootnoteTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "05315");

        Set<Footnote> footnoteSet = foodDescription.getFootnoteSet();
        Assertions.assertEquals(3, footnoteSet.size());
    }

    //  Links to the LanguaL Factor file by the NDB_No field
    @Test
    public void LanguageTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "02002");

        Set<Language> languageSet = foodDescription.getLanguageSet();
        Assertions.assertEquals(13, languageSet.size());
    }
}
