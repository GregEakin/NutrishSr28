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

package dev.eakin.dao.dataValadition;

import dev.eakin.dao.entities.*;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodSearchTests {
    private final Session session;

    FoodSearchTests(Session session) {
        this.session = session;
    }

    @Test
    public void SortedQueryTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01001");
        System.out.println("Basic Report: " + foodDescription.getNDB_No()
                + ", " + foodDescription.getLong_Desc());

        System.out.println("   Weight: Value per 100 g");
        Set<Weight> weightSet = foodDescription.getWeightSet();
        for (Weight weight : weightSet) {
            System.out.println("   Weight: " + weight.getMsre_Desc() + ", " + weight.getAmount() + " x " + weight.getGm_Wgt() + " g");
        }

        String hql = "select nds "
                + "from FoodDescription fd join fd.nutrientDataSet nds "
                + "where fd.NDB_No = :id "
                + "order by nds.nutrientDataKey.nutrientDefinition.SR_Order";
        Query<NutrientData> query = session.createQuery(hql, NutrientData.class);
        query.setParameter("id", "01001");
        List<NutrientData> list = query.getResultList();

//        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
//        Comparator<NutrientData> nutrientDataComparator = Comparator.comparingInt(o -> o.getNutrientDataKey().getNutrientDefinition().getSR_Order());
//        List<NutrientData> list = nutrientDataSet.stream().sorted(nutrientDataComparator).collect(Collectors.toList());

        assertEquals(115, list.size());
        for (NutrientData nutrientData : list) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            NutrientDefinition nutrientDefinition = nutrientDataKey.getNutrientDefinition();

            System.out.println("   NutData: " + nutrientDefinition.getSR_Order()
                    + ", " + nutrientDefinition.getNutrDesc()
                    + " = " + nutrientData.getNutr_Val()
                    + " " + nutrientDefinition.getUnits());
        }
    }
}

