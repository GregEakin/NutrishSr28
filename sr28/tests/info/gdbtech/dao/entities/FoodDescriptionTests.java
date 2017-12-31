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

import static info.gdbtech.dao.entities.FoodGroupTests.createFoodGroup;
import static info.gdbtech.dao.entities.FootnoteTests.createFootnote;
import static info.gdbtech.dao.entities.LanguageTests.createLanguage;
import static info.gdbtech.dao.entities.WeightTests.createWeight;

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
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodGroup");
    }

    @Test
    public void addFoodGroupTest() {
        FoodDescription foodDescription = createFoodDescription();
        FoodGroup foodGroup = createFoodGroup();

        foodDescription.addFoodGroup(foodGroup);
        Assertions.assertSame(foodGroup, foodDescription.getFoodGroup());
        Assertions.assertTrue(foodGroup.getFoodDescriptionSet().contains(foodDescription));
    }

    @Test
    public void addNullWeightTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addWeight(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Weight");
    }

    @Test
    public void addWeightTest() {
        FoodDescription foodDescription = createFoodDescription();
        Weight weight = createWeight(foodDescription);

        foodDescription.addWeight(weight);
        Assertions.assertTrue(foodDescription.getWeightSet().contains(weight));
        Assertions.assertSame(foodDescription, weight.getWeightKey().getFoodDescription());
    }

    @Test
    public void addNullFootnoteTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addFootnote(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Footnote");
    }

    @Test
    public void addFootnoteTest() {
        FoodDescription foodDescription = createFoodDescription();
        Footnote footnote = createFootnote();

        foodDescription.addFootnote(footnote);
        Assertions.assertTrue(foodDescription.getFootnoteSet().contains(footnote));
        Assertions.assertSame(foodDescription, footnote.getFoodDescription());
    }

    @Test
    public void addNullLanguageTest() {
        FoodDescription foodDescription = createFoodDescription();

        Executable closureContainingCodeToTest = () -> foodDescription.addLanguage(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null Language");
    }

    @Test
    public void addLanguageTest() {
        FoodDescription foodDescription = createFoodDescription();
        Language language = createLanguage();

        foodDescription.addLanguage(language);
        Assertions.assertTrue(foodDescription.getLanguageSet().contains(language));
        Assertions.assertTrue(language.getFoodDescriptionSet().contains(foodDescription));
    }
}
