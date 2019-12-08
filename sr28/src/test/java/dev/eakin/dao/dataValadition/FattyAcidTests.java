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

package dev.eakin.dao.dataValadition;

import dev.eakin.dao.entities.NutrientDefinition;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(NutrishRepositoryExtension.class)
public class FattyAcidTests {
    private final Session session;

    FattyAcidTests(Session session) {
        this.session = session;
    }

    @Test
    public void butyricTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "607");
        assertEquals("4:0", nutrientDefinition.getNutrDesc());
        assertEquals("F4D0", nutrientDefinition.getTagname());
        assertEquals("g", nutrientDefinition.getUnits());

    }

    @Test
    public void caproicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "608");
        assertEquals("6:0", nutrientDefinition.getNutrDesc());
        assertEquals("F6D0", nutrientDefinition.getTagname());
        assertEquals("g", nutrientDefinition.getUnits());

    }

    @Test
    public void myristoleicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "625");
        assertEquals("14:1", nutrientDefinition.getNutrDesc());
        assertEquals("F14D1", nutrientDefinition.getTagname());
        assertEquals("g", nutrientDefinition.getUnits());

    }
}
