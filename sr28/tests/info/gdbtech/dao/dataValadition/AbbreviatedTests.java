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

import info.gdbtech.dao.entities.DataSource;
import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

@ExtendWith(NutrishRepositoryExtension.class)
public class AbbreviatedTests {
    private final Session session;

    AbbreviatedTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {
        String hql = "FROM DataSource AS ds WHERE ds.id = :id";
        Query<DataSource> query = session.createQuery(hql, DataSource.class);
        query.setParameter("id", "D642");
        DataSource dataSource = query.getSingleResult();
        Assertions.assertEquals("D642", dataSource.getDataSrc_ID());
    }

    @Test
    public void Test2() {
        String hql = "select nds from DataSource as ds join ds.nutrientDataSet nds where ds.id = :id";
        Query<NutrientData> query = session.createQuery(hql, NutrientData.class);
        query.setParameter("id", "D642");
        List<NutrientData> list = query.getResultList();
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void Test3() {

        String hql = "select new map( max(nutr_Val) as max, min(nutr_Val) as min, count(*) as n ) "
                + "from NutrientData nut "
                + "where nut.nutrientDataKey.nutrientDefinition.nutr_No = :id";
        Query<Map<String, Object>> query = session.createQuery(hql);
        query.setParameter("id", "262");
        Map<String, Object> map = query.getSingleResult();
        Assertions.assertEquals(0.0, (double) map.get("min"));
        Assertions.assertEquals(5714.0, (double) map.get("max"));
        Assertions.assertEquals(5396, (long) map.get("n"));
    }

    @Test
    public void Test4() {
        String hql = "select nd.nutr_Val, fd.long_Desc "
                + "from NutrientData as nd join nd.nutrientDataKey.foodDescription as fd "
                + "where nd.nutrientDataKey.nutrientDefinition.nutr_No = :id and nd.nutr_Val >= :value "
                + "order by nd.nutr_Val desc ";
        Query query = session.createQuery(hql);
        query.setParameter("id", "204");
        query.setParameter("value", 98.0);
        List list = query.getResultList();
        Assertions.assertEquals(112, list.size());
    }
}
