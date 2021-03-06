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

package dev.eakin.dao.references;

import dev.eakin.dao.entities.NutrientData;
import dev.eakin.dao.entities.DataSource;
import dev.eakin.dao.entities.NutrientDefinition;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(NutrishRepositoryExtension.class)
public class DataSourceTests {
    private final Session session;

    DataSourceTests(Session session) {
        this.session = session;
    }

    //  Links to Nutrient Data file by NDB No. through the Sources of Data Link file
    @Test
    public void nutrientDataTest() {
        DataSource dataSource = session.load(DataSource.class, "D642");

        Set<NutrientData> nutrientDataSet = dataSource.getNutrientDataSet();
        assertEquals(2, nutrientDataSet.size());
    }

    //  Links to the Nutrient Definition file by Nutr_No
    @Test
    public void nutrientDefinitionTest() {
        //DataSource dataSource = session.load(DataSource.class, "D642");

        String hql = "select nd from DataSource ds join ds.nutrientDataSet nds join nds.nutrientDataKey.nutrientDefinition nd where ds.id = :id";
        Query<NutrientDefinition> query = session.createQuery(hql, NutrientDefinition.class);
        query.setParameter("id", "D642");
        List<NutrientDefinition> list = query.getResultList();
        assertEquals(2, list.size());
        assertArrayEquals(new String[]{"306", "307"}, list.stream().map(NutrientDefinition::getNutr_No).sorted().toArray());
    }
}
