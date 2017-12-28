package greg.info.dao.validateData;

import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.NutrientDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NutrientCountTests {

    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeAll
    public static void before() {
        sessionFactory = createSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(NutrientData.class)
                .addAnnotatedClass(NutrientDefinition.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/nutrish");
        configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    @Test
    public void waterCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "255");
        Assertions.assertEquals("Water", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("WATER", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8788, nutrientDataSet.size());
    }

    @Test
    public void energyKcalCountTest() {

        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "208");
        Assertions.assertEquals("Energy", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("ENERC_KCAL", nutrientDefinition.getTagname());
        Assertions.assertEquals("kcal   ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }

    @Test
    void glucoseCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "211");
        Assertions.assertEquals("Glucose (dextrose)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("GLUS", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(1752, nutrientDataSet.size());
    }

    @Test
    void fatCountTest() {
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, "204");
        Assertions.assertEquals("Total lipid (fat)", nutrientDefinition.getNutrDesc());
        Assertions.assertEquals("FAT", nutrientDefinition.getTagname());
        Assertions.assertEquals("g      ", nutrientDefinition.getUnits());

        Set<NutrientData> nutrientDataSet = nutrientDefinition.getNutrientDataSet();
        Assertions.assertEquals(8789, nutrientDataSet.size());
    }
}
