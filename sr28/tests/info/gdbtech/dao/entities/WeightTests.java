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

import static info.gdbtech.dao.entities.FoodDescriptionTests.createFoodDescription;
import static info.gdbtech.dao.entities.NutrientDataTests.crateNutrientData;
import static info.gdbtech.dao.entities.NutrientDefinitionTests.createNutrientDefinition;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(NutrishRepositoryExtension.class)
public class WeightTests {
    private final Session session;

    WeightTests(Session session) {
        this.session = session;
    }

    public static Weight createWeight(FoodDescription foodDescription) {
        WeightKey weightKey = new WeightKey(foodDescription, "00");
        Weight weight = new Weight();
        weight.setWeightKey(weightKey);
        foodDescription.addWeight(weight);
        return weight;
    }

//    @Test
//    public void addNullFoodDescription() {
//        FoodDescription foodDescription = createFoodDescription();
//        Weight weight = createWeight(foodDescription);
//
//        Executable closureContainingCodeToTest = () -> weight.addFoodDescription(null);
//        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null NutrientData");
//    }

    @Test
    public void addFoodDescription() {
        FoodDescription foodDescription = createFoodDescription();
        Weight weight = createWeight(foodDescription);

        // weight.addFoodDescription(foodDescription);
        assertSame(foodDescription, weight.getWeightKey().getFoodDescription());
        assertTrue(foodDescription.getWeightSet().contains(weight));
    }

//    @Test
//    public void addNullNutrientDataTest() {
//        FoodDescription foodDescription = createFoodDescription();
//        Weight weight = createWeight(foodDescription);
//
//        Executable closureContainingCodeToTest = () -> weight.addNutrientData(null);
//        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null NutrientData");
//    }

    @Test
    public void addNutrientData() {
        FoodDescription foodDescription = createFoodDescription();
        Weight weight = createWeight(foodDescription);
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        assertSame(weight.getWeightKey().getFoodDescription(), nutrientData.getNutrientDataKey().getFoodDescription());
        // assertTrue(nutrientData.getWeightSet().contains(weight));
    }
}
