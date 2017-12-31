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

package info.gdbtech.dao.entities;

import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static info.gdbtech.dao.entities.FoodDescriptionTests.createFoodDescription;
import static info.gdbtech.dao.entities.FootnoteTests.createFootnote;
import static info.gdbtech.dao.entities.NutrientDataTests.crateNutrientData;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientDefinitionTests {
    private final Session session;

    NutrientDefinitionTests(Session session) {
        this.session = session;
    }

    public static NutrientDefinition createNutrientDefinition() {
        NutrientDefinition nutrientDefinition = new NutrientDefinition();
        nutrientDefinition.setNutr_No("000");
        return nutrientDefinition;
    }

    @Test
    public void addNullNutrientDataTest() {
        NutrientDefinition nutrientDefinition = createNutrientDefinition();

        Executable closureContainingCodeToTest = () -> nutrientDefinition.addNutrientData(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null NutrientData");
    }

    @Test
    public void addNutrientDataTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        nutrientDefinition.addNutrientData(nutrientData);
        Assertions.assertTrue(nutrientDefinition.getNutrientDataSet().contains(nutrientData));
        Assertions.assertSame(nutrientDefinition, nutrientData.getNutrientDataKey().getNutrientDefinition());
    }

    @Test
    public void addNullFootnoteTest() {
        NutrientDefinition nutrientDefinition = createNutrientDefinition();

        Executable closureContainingCodeToTest = () -> nutrientDefinition.addFootnote(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Footnote");
    }

    @Test
    public void addFootnoteTest() {
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        Footnote footnote = createFootnote();

        nutrientDefinition.addFootnote(footnote);
        Assertions.assertSame(nutrientDefinition, footnote.getNutrientDefinition());
        Assertions.assertTrue(nutrientDefinition.getFootnoteSet().contains(footnote));
    }
}
