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
    String Stuff[][] = new String[][]{
            new String[]{"255", "Water", "WATER", "g", "8788"},
            new String[]{"208", "Energy", "ENERC_KCAL", "kcal", "8789"},
            new String[]{"211", "Glucose (dextrose)", "GLUS", "g", "1752"},
            new String[]{"204", "Total lipid (fat)", "FAT", "g", "8789"},
    };

    NutrientCountTests(Session session) {
        this.session = session;
    }

    @Test
    void counterTest() {
        for (String[] data : Stuff) {
            NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, data[0]);
            Assertions.assertEquals(data[1], nutrientDefinition.getNutrDesc());
            Assertions.assertEquals(data[2], nutrientDefinition.getTagname());
            Assertions.assertEquals(data[3], nutrientDefinition.getUnits());

            Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
            Assertions.assertEquals(Double.parseDouble(data[4]), nutrientDataSet.size());
        }
    }
}
