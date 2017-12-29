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

package info.gdbtech.dao.utilities;

import info.gdbtech.dao.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.extension.*;

public class NutrishRepositoryExtension implements
        BeforeAllCallback,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback,
        AfterAllCallback,
        ParameterResolver {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        sessionFactory = createSessionFactory();
        session = createSession();
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        transaction = session.beginTransaction();
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        try {
            transaction.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        try {
            try {
                session.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            sessionFactory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Session.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return session;
    }

    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/nutrish");
        configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
        configuration
                .addAnnotatedClass(DataDerivation.class)
                .addAnnotatedClass(DataSource.class)
                .addAnnotatedClass(FoodDescription.class)
                .addAnnotatedClass(FoodGroup.class)
                .addAnnotatedClass(Footnote.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(NutrientData.class)
                .addAnnotatedClass(NutrientDefinition.class)
                .addAnnotatedClass(SourceCode.class)
                .addAnnotatedClass(Weight.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public Session createSession() {
        session = sessionFactory.openSession();
        return session;
    }
}
