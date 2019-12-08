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

import static dev.eakin.dao.entities.FootnoteTests.createFootnote;
import static dev.eakin.dao.entities.WeightTests.createWeight;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodDescriptionTests {
    private final Session session;

    FoodDescriptionTests(Session session) {
        this.session = session;
    }

    public static FoodDescription createFoodDescription() {
        FoodDescription foodDescription = new FoodDescription();
        foodDescription.setNDB_No("000000");
        return foodDescription;
    }

    @Test
    public void addNullFoodGroupTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addFoodGroup(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodGroup");
    }

    @Test
    public void addFoodGroupTest() {
        FoodDescription foodDescription = createFoodDescription();
        FoodGroup foodGroup = FoodGroupTests.createFoodGroup();

        foodDescription.addFoodGroup(foodGroup);
        assertSame(foodGroup, foodDescription.getFoodGroup());
        assertTrue(foodGroup.getFoodDescriptionSet().contains(foodDescription));
    }

    @Test
    public void addNullWeightTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addWeight(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Weight");
    }

    @Test
    public void addWeightTest() {
        FoodDescription foodDescription = createFoodDescription();
        Weight weight = createWeight(foodDescription);

        foodDescription.addWeight(weight);
        assertTrue(foodDescription.getWeightSet().contains(weight));
        assertSame(foodDescription, weight.getWeightKey().getFoodDescription());
    }

    @Test
    public void addNullFootnoteTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addFootnote(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Footnote");
    }

    @Test
    public void addFootnoteTest() {
        FoodDescription foodDescription = createFoodDescription();
        Footnote footnote = createFootnote();

        foodDescription.addFootnote(footnote);
        assertTrue(foodDescription.getFootnoteSet().contains(footnote));
        assertSame(foodDescription, footnote.getFoodDescription());
    }

    @Test
    public void addNullLanguageTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addLanguage(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Language");
    }

    @Test
    public void addLanguageTest() {
        FoodDescription foodDescription = createFoodDescription();
        Language language = LanguageTests.createLanguage();

        foodDescription.addLanguage(language);
        assertTrue(foodDescription.getLanguageSet().contains(language));
        assertTrue(language.getFoodDescriptionSet().contains(foodDescription));
    }
}
