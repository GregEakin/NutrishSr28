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

import static info.gdbtech.dao.entities.FoodDescriptionTests.createFoodDescription;
import static info.gdbtech.dao.entities.NutrientDataTests.crateNutrientData;
import static info.gdbtech.dao.entities.NutrientDefinitionTests.createNutrientDefinition;

@ExtendWith(NutrishRepositoryExtension.class)
public class SourceCodeTests {
    private final Session session;

    SourceCodeTests(Session session) {
        this.session = session;
    }

    public static SourceCode createSourceCode() {
        SourceCode sourceCode = new SourceCode();
        sourceCode.setSrc_Cd("00");
        return sourceCode;
    }

    @Test
    public void addNullNutrientDataTest() {
        SourceCode sourceCode = createSourceCode();

        Executable closureContainingCodeToTest = () -> sourceCode.addNutrientData(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null NutrientData");
    }

    @Test
    public void addNutrientDataTest() {
        SourceCode sourceCode = createSourceCode();
        FoodDescription foodDescription = createFoodDescription();
        NutrientDefinition nutrientDefinition = createNutrientDefinition();
        NutrientData nutrientData = crateNutrientData(foodDescription, nutrientDefinition);

        sourceCode.addNutrientData(nutrientData);
        Assertions.assertSame(sourceCode, nutrientData.getSourceCode());
        Assertions.assertTrue(sourceCode.getNutrientDataSet().contains(nutrientData));
    }
}
