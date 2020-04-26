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

package dev.eakin.dao.entities;

import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static dev.eakin.dao.entities.FoodDescriptionTests.createFoodDescription;
import static dev.eakin.dao.entities.NutrientDataTests.createNutrientData;
import static dev.eakin.dao.entities.NutrientDefinitionTests.createNutrientDefinition;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(NutrishRepositoryExtension.class)
public class DataDerivationTests {
    private final Session session;

    DataDerivationTests(Session session) {
        this.session = session;
    }

    public static DataDerivation createDataDerivation() {
        DataDerivation dataDerivation = new DataDerivation();
        dataDerivation.setDeriv_Cd("0000");
        return dataDerivation;
    }

    @Test
    public void addNullNutrientDataTest() {
        DataDerivation dataDerivation = createDataDerivation();

        Executable closureContainingCodeToTest = () -> dataDerivation.addNutrientData(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null DataDerivation");
    }

    @Test
    public void addNutrientDataTest() {
        DataDerivation dataDerivation = createDataDerivation();
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = createNutrientData(foodDescription, nutrientDefinition);

        dataDerivation.addNutrientData(nutrientData);
        assertSame(dataDerivation, nutrientData.getDataDerivation());
        assertTrue(dataDerivation.getNutrientDataSet().contains(nutrientData));
    }
}
