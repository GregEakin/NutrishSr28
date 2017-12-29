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

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.NutrientDataKey;
import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class ElementCountTests {
    private final Session session;

    ElementCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void waterTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
        System.out.println(nutrientDefinition.getNutr_No()
                + " " + nutrientDefinition.getNutrDesc()
                + " " + nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        System.out.println("   NutData Cout: " + nutrientDataSet.size());
        int count = 0;
        for (NutrientData nutrientData : nutrientDataSet) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            System.out.print("    NutData: " + nutrientData.getNutr_Val());

            FoodDescription foodDescription = nutrientData.getNutrientDataKey().getFoodDescription();
            System.out.println(" " + foodDescription.getLong_Desc());

            if (++count > 15)
                break;
        }

    }
}
