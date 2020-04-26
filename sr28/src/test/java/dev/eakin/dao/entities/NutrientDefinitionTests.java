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

package dev.eakin.dao.entities;

import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static dev.eakin.dao.entities.FoodDescriptionTests.createFoodDescription;
import static dev.eakin.dao.entities.FootnoteTests.createFootnote;
import static dev.eakin.dao.entities.NutrientDataTests.createNutrientData;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null NutrientData");
    }

    @Test
    public void addNutrientDataTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = createNutrientData(foodDescription, nutrientDefinition);

        nutrientDefinition.addNutrientData(nutrientData);
        assertTrue(nutrientDefinition.getNutrientDataSet().contains(nutrientData));
        assertSame(nutrientDefinition, nutrientData.getNutrientDataKey().getNutrientDefinition());
    }

    @Test
    public void addNullFootnoteTest() {
        NutrientDefinition nutrientDefinition = createNutrientDefinition();

        Executable closureContainingCodeToTest = () -> nutrientDefinition.addFootnote(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Footnote");
    }

    @Test
    public void addFootnoteTest() {
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        Footnote footnote = createFootnote();

        nutrientDefinition.addFootnote(footnote);
        assertSame(nutrientDefinition, footnote.getNutrientDefinition());
        assertTrue(nutrientDefinition.getFootnoteSet().contains(footnote));
    }
}
