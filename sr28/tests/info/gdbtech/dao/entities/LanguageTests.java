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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static info.gdbtech.dao.entities.FoodDescriptionTests.createFoodDescription;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(NutrishRepositoryExtension.class)
public class LanguageTests {
    private final Session session;

    LanguageTests(Session session) {
        this.session = session;
    }

    public static Language createLanguage() {
        Language language = new Language();
        language.setFactor_Code("00000");
        return language;
    }

    @Test
    public void addNullFoodDescription() {
        Language language = createLanguage();

        Executable closureContainingCodeToTest = () -> language.addFoodDescription(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodDescription");
    }

    @Test
    public void addFoodDescription() {
        Language language = createLanguage();
        FoodDescription foodDescription = createFoodDescription();

        language.addFoodDescription(foodDescription);
        assertTrue(language.getFoodDescriptionSet().contains(foodDescription));
        assertTrue(foodDescription.getLanguageSet().contains(language));
    }
}
