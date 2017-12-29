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
import info.gdbtech.dao.entities.FoodGroup;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutGroupTests {
    private final Session session;

    NutGroupTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {
        FoodGroup foodGroup = session.load(FoodGroup.class, "1200");
        System.out.println(foodGroup.getFdGrp_Cd() + ", " + foodGroup.getFdGrp_Desc());
        Set<FoodDescription> foodDescriptionSet = foodGroup.getFoodDescriptionSet();
        for (FoodDescription foodDescription : foodDescriptionSet) {
            System.out.println("  " + foodDescription.getNDB_No() + " " + foodDescription.getShrt_Desc());
        }
    }
}