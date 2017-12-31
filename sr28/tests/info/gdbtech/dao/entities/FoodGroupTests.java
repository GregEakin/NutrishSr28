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

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodGroupTests {
    private final Session session;

    FoodGroupTests(Session session) {
        this.session = session;
    }

    public static FoodGroup createFoodGroup() {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setFdGrp_Cd("0000");
        return foodGroup;
    }

    @Test
    public void addNullFoodDescriptionTest() {
        FoodGroup foodGroup = createFoodGroup();

        Executable closureContainingCodeToTest = () -> foodGroup.addFoodDescriptionSet(null);
        Assertions.assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "null FoodDescription");
    }

    @Test
    public void addFoodDescriptionTest() {
        FoodGroup foodGroup = createFoodGroup();
        FoodDescription foodDescription = createFoodDescription();

        foodGroup.addFoodDescriptionSet(foodDescription);
        Assertions.assertSame(foodGroup, foodDescription.getFoodGroup());
        Assertions.assertTrue(foodGroup.getFoodDescriptionSet().contains(foodDescription));
    }
}
