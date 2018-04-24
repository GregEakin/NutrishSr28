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
import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.Weight;
import info.gdbtech.dao.entities.WeightKey;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(NutrishRepositoryExtension.class)
public class WeightTests {
    private final Session session;

    WeightTests(Session session) {
        this.session = session;
    }

    //  Links to Food Description file by NDB_No
    @Test
    public void foodDescriptionTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        WeightKey weightKey = new WeightKey(foodDescription, "3 ");
        Weight weight = session.load(Weight.class, weightKey);

        assertSame(foodDescription, weight.getWeightKey().getFoodDescription());
    }

    //  Links to Nutrient Data file by NDB_No
    @Test
    public void nutrientDataTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01119");
        WeightKey weightKey = new WeightKey(foodDescription, "3 ");
        Weight weight = session.load(Weight.class, weightKey);

        Set<NutrientData> nutrientDataSet = weight.getWeightKey().getFoodDescription().getNutrientDataSet();
        assertEquals(91, nutrientDataSet.size());
    }
}


