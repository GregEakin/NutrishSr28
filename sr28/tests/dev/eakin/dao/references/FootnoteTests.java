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
import dev.eakin.dao.entities.FoodDescription;
import dev.eakin.dao.entities.Footnote;
import dev.eakin.dao.entities.NutrientDefinition;
import dev.eakin.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(NutrishRepositoryExtension.class)
public class FootnoteTests {
    private final Session session;

    FootnoteTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by NDB_No
    @Test
    public void foodDescriptionTest() {
        String hql = "FROM Footnote WHERE foodDescription.NDB_No = :ndb_no and nutrientDefinition.nutr_No is null";
        Query<Footnote> query = session.createQuery(hql, Footnote.class);
        query.setParameter("ndb_no", "05316");
        List results = query.list();
        assertEquals(1, results.size());
        Footnote footnote = query.getSingleResult();

        FoodDescription foodDescription = footnote.getFoodDescription();
        assertEquals("05316", foodDescription.getNDB_No());
    }

    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    @Test
    public void nutrientDataTest1() {
        String hql = "FROM Footnote WHERE foodDescription.NDB_No = :ndb_no and nutrientDefinition.nutr_No is null";
        Query<Footnote> query = session.createQuery(hql, Footnote.class);
        query.setParameter("ndb_no", "05316");
        Footnote footnote = query.getSingleResult();

        FoodDescription foodDescription = footnote.getFoodDescription();
        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
        assertEquals(44, nutrientDataSet.size());
        for (NutrientData nutrientData : nutrientDataSet)
            assertEquals("05316", nutrientData.getNutrientDataKey().getFoodDescription().getNDB_No());
    }

    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    @Test
    public void nutrientDataTest2() {
//        String hql = "FROM Footnote WHERE foodDescription.NDB_No = :ndb_no and nutrientDefinition.nutr_No = :nutr_no";
//        Query<Footnote> query = session.createQuery(hql, Footnote.class);
//        query.setParameter("ndb_no", "05316");
//        query.setParameter("nutr_no", "204");
//        Footnote footnote = query.getSingleResult();

        String hql = "FROM NutrientData WHERE nutrientDataKey.foodDescription.NDB_No = :ndb_no and nutrientDataKey.nutrientDefinition.nutr_No = :nutr_no";
        Query<NutrientData> query = session.createQuery(hql, NutrientData.class);
        query.setParameter("ndb_no", "05316");  // set from footnote.getFoodDescription().getNDB_No()
        query.setParameter("nutr_no", "204");   // set from footnote.getNutrientDefinition().getNutr_No()
        NutrientData nutrientData = query.getSingleResult();
        assertEquals("05316", nutrientData.getNutrientDataKey().getFoodDescription().getNDB_No());
        assertEquals("204", nutrientData.getNutrientDataKey().getNutrientDefinition().getNutr_No());
    }

    //  Links to the Nutrient Definition file by Nutr_No, when applicable
    @Test
    public void nutrientDefinitionTest() {
        String hql = "FROM Footnote WHERE foodDescription.NDB_No = :ndb_no and nutrientDefinition.nutr_No = :nutr_no";
        Query<Footnote> query = session.createQuery(hql, Footnote.class);
        query.setParameter("ndb_no", "05316");
        query.setParameter("nutr_no", "204");
        Footnote footnote = query.getSingleResult();

        NutrientDefinition nutrientDefinition = footnote.getNutrientDefinition();
        assertEquals("204", nutrientDefinition.getNutr_No());
    }
}


