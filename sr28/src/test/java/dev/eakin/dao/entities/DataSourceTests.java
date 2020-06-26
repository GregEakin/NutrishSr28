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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(NutrishRepositoryExtension.class)
public class DataSourceTests {
    private final Session session;

    DataSourceTests(Session session) {
        this.session = session;
    }

    public static DataSource createDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDataSrc_ID("000000");
        return dataSource;
    }

    @Test
    public void addNullNutrientDataTest() {
        DataSource dataSource = createDataSource();

        Executable closureContainingCodeToTest = () -> dataSource.addNutrientData(null);
        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null DataDerivation");
    }

    @Test
    public void addNutrientDataTest() {
        DataSource dataSource = createDataSource();
        FoodDescription foodDescription = FoodDescriptionTests.createFoodDescription();
        NutrientDefinition nutrientDefinition = NutrientDefinitionTests.createNutrientDefinition();
        NutrientData nutrientData = NutrientDataTests.createNutrientData(foodDescription, nutrientDefinition);

        dataSource.addNutrientData(nutrientData);
        assertTrue(nutrientData.getDataSourceSet().contains(dataSource));
        assertTrue(dataSource.getNutrientDataSet().contains(nutrientData));
    }
}
