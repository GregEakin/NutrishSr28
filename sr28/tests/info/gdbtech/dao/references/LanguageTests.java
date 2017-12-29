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

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.Language;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class LanguageTests {
    private final Session session;

    LanguageTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by the NDB_No field
    @Test
    public void foodDescriptionTest() {
        Language language = session.load(Language.class, "A0143");
        Set<FoodDescription> foodDescriptionSet = language.getFoodDescriptionSet();
        Assertions.assertEquals(232, foodDescriptionSet.size());
    }

    //  Links to LanguaL Factors Description file by the Factor_Code field
    @Test
    public void LanguageSetTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "02014");
        Set<Language> languageSet = foodDescription.getLanguageSet();
        Assertions.assertEquals(13, languageSet.size());
    }

}
