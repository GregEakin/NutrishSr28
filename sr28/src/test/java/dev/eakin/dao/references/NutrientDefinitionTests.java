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

import dev.eakin.dao.entities.NutrientData;
import dev.eakin.dao.entities.NutrientDefinition;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientDefinitionTests {
    private final Session session;

    NutrientDefinitionTests(Session session) {
        this.session = session;
    }

    //  Links to the Nutrient Data file by Nutr_No
    @Test
    public void nutrientDataTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        assertEquals(8789, nutrientDataSet.size());
    }
}

