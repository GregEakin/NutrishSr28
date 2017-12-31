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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static info.gdbtech.dao.entities.DataDerivationTests.createDataDerivation;
import static info.gdbtech.dao.entities.DataSourceTests.createDataSource;
import static info.gdbtech.dao.entities.FoodDescriptionTests.createFoodDescription;
import static info.gdbtech.dao.entities.NutrientDefinitionTests.createNutrientDefinition;
import static info.gdbtech.dao.entities.SourceCodeTests.createSourceCode;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutrientDataTests {
    private final Session session;

    NutrientDataTests(Session session) {
        this.session = session;
    }

    public static NutrientData crateNutrientData(FoodDescription foodDescription, NutrientDefinition nutrientDefinition) {
        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        NutrientData nutrientData = new NutrientData();
        nutrientData.setNutrientDataKey(nutrientDataKey);
        return nutrientData;
    }

    @Test
    public void addNullDataDerivationTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        Executable closureContainingCodeToTest = () -> nutrientData.addDataDerivation(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null DataDerivation");
    }

    @Test
    public void addDataDerivationTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);
        DataDerivation dataDerivation = createDataDerivation();

        nutrientData.addDataDerivation(dataDerivation);
        Assertions.assertSame(dataDerivation, nutrientData.getDataDerivation());
        Assertions.assertTrue(dataDerivation.getNutrientDataSet().contains(nutrientData));
    }

    @Test
    public void addNullDataSourceTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        Executable closureContainingCodeToTest = () -> nutrientData.addDataSource(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null DataSource");
    }

    @Test
    public void addDataSourceTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);
        DataSource dataSource = createDataSource();

        nutrientData.addDataSource(dataSource);
        Assertions.assertTrue(nutrientData.getDataSourceSet().contains(dataSource));
        Assertions.assertTrue(dataSource.getNutrientDataSet().contains(nutrientData));
    }

//    @Test
//    public void setNullRefFoodDescriptionTest() {
//        FoodDescription foodDescription = createFoodDescription();
//        NutrientDefinition nutrientDefinition = createNutrientDefinition();
//        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);
//
//        Executable closureContainingCodeToTest = () -> language.addFoodDescription(null);
//        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodDescription");
//    }

    @Test
    public void setRefFoodDescriptionTest() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        nutrientData.setRefFoodDescription(foodDescription);
        Assertions.assertSame(foodDescription, nutrientData.getRefFoodDescription());
    }

    @Test
    public void addNullSourceCode() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        Executable closureContainingCodeToTest = () -> nutrientData.addSourceCode(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null SourceCode");
    }

    @Test
    public void addSourceCode() {
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);
        SourceCode sourceCode = createSourceCode();

        nutrientData.addSourceCode(sourceCode);
        Assertions.assertSame(sourceCode, nutrientData.getSourceCode());
        Assertions.assertTrue(sourceCode.getNutrientDataSet().contains(nutrientData));
    }
}
