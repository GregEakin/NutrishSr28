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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(NutrishRepositoryExtension.class)
public class FootnoteTests {
    private final Session session;

    FootnoteTests(Session session) {
        this.session = session;
    }

    public static Footnote createFootnote() {
        Footnote footnote = new Footnote();
        return footnote;
    }

    @Test
    public void addNullNutrientDefinitionTest() {
        Footnote footnote = createFootnote();

        Executable closureContainingCodeToTest = () -> footnote.addNutrientDefinition(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodDescription");
    }

    @Test
    public void addNutrientDefinitionTest() {
        Footnote footnote = createFootnote();
        NutrientDefinition nutrientDefinition = NutrientDefinitionTests.createNutrientDefinition();

        footnote.addNutrientDefinition(nutrientDefinition);
        assertSame(nutrientDefinition, footnote.getNutrientDefinition());
        assertTrue(nutrientDefinition.getFootnoteSet().contains(footnote));
    }

    @Test
    public void addNullFoodDescriptionTest() {
        Footnote footnote = createFootnote();

//        Executable closureContainingCodeToTest = () -> footnote.addFoodDescriptionSet(null);
//        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodDescription");
    }

    @Test
    public void addFoodDescriptionTest() {
        Footnote footnote = createFootnote();
        FoodDescription foodDescription = FoodDescriptionTests.createFoodDescription();

        // footnote.addFoodDescription(foodDescription);
    }
}
