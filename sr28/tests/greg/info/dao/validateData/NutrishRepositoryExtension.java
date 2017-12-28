package greg.info.dao.validateData;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDefinition;
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
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        sessionFactory = createSessionFactory();
        session = createSession();
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        transaction = session.beginTransaction();
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        try {
            transaction.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
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
        configuration.addAnnotatedClass(NutrientData.class)
                .addAnnotatedClass(NutrientDefinition.class)
                .addAnnotatedClass(FoodDescription.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/nutrish");
        configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public Session createSession() {
        session = sessionFactory.openSession();
        return session;
    }
}
