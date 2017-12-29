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

package info.gdbtech.dao.dataValadition;

import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NutrishRepositoryExtension.class)
public class FattyAcidTests {
    private final Session session;

    FattyAcidTests(Session session) {
        this.session = session;
    }

    @Test
    public void butyricTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "607");
        Assertions.assertEquals("4:0", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F4D0", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }

    @Test
    public void caproicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "608");
        Assertions.assertEquals("6:0", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F6D0", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }

    @Test
    public void myristoleicTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "625");
        Assertions.assertEquals("14:1", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("F14D1", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

    }
}
