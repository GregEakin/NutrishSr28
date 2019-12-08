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

package dev.eakin;

import dev.eakin.dao.parsers.*;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbLoad {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction;
                try {
                    transaction = session.beginTransaction();
                    FdGroup.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    SrcCd.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    DerivCD.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    LangDesc.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    DataSrc.parseFile(session);
                    transaction.commit();

                    transaction = session.beginTransaction();
                    NutrDef.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    FoodDes.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    LanguaL.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    Weight.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    NutData.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    DatScrLn.parseFile(session);
                    transaction.commit();
                    transaction = session.beginTransaction();
                    Footnote.parseFile(session);
                    transaction.commit();
                } catch (Exception ex) {
                    throw ex;
                }
            }

            // DumpEntities(sessionFactory);
            // dump();
        }
    }

    private static void DumpEntities(SessionFactory sessionFactory) {
        try (final Session session = sessionFactory.openSession()) {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = "from " + entityType.getName();
                final Query query = session.createQuery(entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        }
    }

    public static void dump() {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql:nutrhis", "SA", "")) {

                LanguaL.sqlSelectRows(con);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
