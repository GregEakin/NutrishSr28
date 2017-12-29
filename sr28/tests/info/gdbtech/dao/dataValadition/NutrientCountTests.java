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

import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientCountTests {

    private final Session session;

    NutrientCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void waterCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
        Assertions.assertEquals("Water", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("WATER", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8788, nutrientDataSet.size());
    }

    @Test
    public void energyKcalCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "208");
        Assertions.assertEquals("Energy", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("ENERC_KCAL", nutrientDefinition.getTagname());
        Assertions.assertEquals("kcal   ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }

    @Test
    void glucoseCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "211");
        Assertions.assertEquals("Glucose (dextrose)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("GLUS", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(1752, nutrientDataSet.size());
    }

    @Test
    void fatCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Assertions.assertEquals("Total lipid (fat)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("FAT", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }
}
