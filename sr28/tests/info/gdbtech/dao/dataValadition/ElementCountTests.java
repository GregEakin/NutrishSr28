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

import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.NutrientDefinition;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(NutrishRepositoryExtension.class)
public class ElementCountTests {
    private final Session session;

    ElementCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void waterTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
        Assertions.assertEquals("255", nutrientDefinition.getNutr_No());
        Assertions.assertEquals("Water", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("g", nutrientDefinition.getUnits());

        String hql = "select count(*) from  NutrientData where nutrientDataKey.nutrientDefinition.nutr_No = :nutr_no";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("nutr_no", "255");
        Long count = query.getSingleResult();
        Assertions.assertEquals(8788L, count.longValue());
    }

    @Test
    public void waterLimitTest() {

        String hql = "FROM NutrientData "
                + "WHERE nutrientDataKey.nutrientDefinition.nutr_No = :nutr_no "
                + "ORDER BY nutrientDataKey.foodDescription.NDB_No DESC ";
        Query<NutrientData> query = session.createQuery(hql, NutrientData.class);
        query.setParameter("nutr_no", "255");
        query.setMaxResults(10);
        List<NutrientData> list = query.getResultList();
        Assertions.assertEquals(10, list.size());

        for (NutrientData nutrientData : list) {
            Assertions.assertEquals("255", nutrientData.getNutrientDataKey().getNutrientDefinition().getNutr_No());
            System.out.println(nutrientData.getNutrientDataKey().getFoodDescription().getNDB_No());
        }
    }
}
