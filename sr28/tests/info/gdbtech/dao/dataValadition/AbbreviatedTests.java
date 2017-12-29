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

@ExtendWith(NutrishRepositoryExtension.class)
public class AbbreviatedTests {
    private final Session session;

    AbbreviatedTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {
        String hql = "FROM DataSource AS d1 where d1.id = :id";
        Query<DataSource> query = session.createQuery(hql, DataSource.class);
        query.setParameter("id", "D642");
        DataSource dataSource = query.getSingleResult();
        Assertions.assertEquals("D642", dataSource.getDataSrc_ID());
    }

    @Test
    public void Test2() {
        String hql = "select nds from DataSource ds join ds.nutrientDataSet nds where ds.id = :id";
        Query<NutrientData> query = session.createQuery(hql, NutrientData.class);
        query.setParameter("id", "D642");
        List<NutrientData> list = query.getResultList();
        Assertions.assertEquals(2, list.size());
    }
}
