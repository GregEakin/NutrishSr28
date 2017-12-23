package greg.info;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.metamodel.EntityType;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Optional;

public class TestFoodDes {
    private static final String line1 = "~01001~^~0100~^~Butter, salted~^~BUTTER,WITH SALT~^~~^~~^~Y~^~~^0^~~^6.38^4.27^8.79^3.87";
    private static final String line2 = "~01002~^~0100~^~Butter, whipped, with salt~^~BUTTER,WHIPPED,W/ SALT~^~~^~~^~Y~^~~^0^~~^6.38^^^";
    private static final String line3 = "~09444~^~0900~^~Juice, apple, grape and pear blend, with added ascorbic acid and calcium~^~JUICE,APPL,GRAPE & PEAR BLEND,W/ ADDED VIT C & CA~^~~^~~^~Y~^~~^0^~~^6.25^3.36^8.37^3.92\n";
    private static final String line4 = "~05068~^~0500~^~Chicken, broilers or fryers, drumstick, meat and skin, cooked, fried, flour~^~CHICKEN,BROILERS OR FRYERS,DRUMSTK,MEAT&SKN,CKD,FRIED,FLR~^~~^~~^~~^~Bone~^34^~~^6.25^4.27^9.02^3.87\n";

    public static void main(String[] args) throws Exception {

        URL configUrl = HibernateUtil.class.getResource("/hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure(configUrl);
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        try (final SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // DumpEntities(sessionFactory);

            try (final Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                processLine(session, line4);
                transaction.commit();
            }

            dump();
        }
    }

    private static void DumpEntities(SessionFactory sessionFactory) {
        try (final Session session = sessionFactory.openSession()) {
             System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        }
    }

    public static void processLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        FoodDescription item = new FoodDescription();
        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));
        item.setFdGrp_Cd(fields[1].substring(1, fields[1].length() - 1));
        item.setLong_Desc(fields[2].substring(1, fields[2].length() - 1));
        item.setShrt_Desc(fields[3].substring(1, fields[3].length() - 1));

        if (fields[4].length() > 2) item.setComName(fields[4].substring(1, fields[4].length() - 1));
        if (fields[5].length() > 2) item.setManufacName(fields[5].substring(1, fields[5].length() - 1));
        if (fields[6].length() > 2) item.setSurvey(fields[6].substring(1, fields[6].length() - 1));
        if (fields[7].length() > 2) item.setRef_desc(fields[7].substring(1, fields[7].length() - 1));
        if (fields[8].length() > 0) item.setRefuse(Byte.parseByte(fields[8]));
        if (fields[9].length() > 2) item.setSciName(fields[8].substring(1, fields[9].length() - 1));
        if (fields[10].length() > 0) item.setN_Factor(Double.parseDouble(fields[10]));
        if (fields[11].length() > 0) item.setPro_Factor(Double.parseDouble(fields[11]));
        if (fields[12].length() > 0) item.setFat_Factor(Double.parseDouble(fields[12]));
        if (fields[13].length() > 0) item.setCHO_Factor(Double.parseDouble(fields[13]));

        session.save("FoodDescription", item);
    }


    public static void dump() {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:mem:howtodoinjava", "SA", "1")) {

                sqlSelectRows(con);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static int sqlSelectRows(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM FOOD_DES";
            ResultSet result = stmt.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                String x0 = result.getString("NDB_No");
                String x1 = result.getString("FdGrp_Cd");
                String x2 = result.getString("Long_Desc");
                String x3 = result.getString("Shrt_Desc");
                String x4 = result.getString("ComName");
                String x5 = result.getString("ManufacName");
                String x6 = result.getString("Survey");
                String x7 = result.getString("Ref_desc");

                Byte x8 = result.getByte("Refuse");
                if (result.wasNull()) x8 = null;

                String x9 = result.getString("SciName");

                Float x10 = result.getFloat("N_Factor");
                if (result.wasNull()) x10 = null;

                Float x11 = result.getFloat("Pro_Factor");
                if (result.wasNull()) x11 = null;

                Float x12 = result.getFloat("Fat_Factor");
                if (result.wasNull()) x12 = null;

                Float x13 = result.getFloat("CHO_Factor");
                if (result.wasNull()) x13 = null;

                /*
                      0  "NDB_No", "CHARACTER(5)", Types.CHAR, "NOT NULL PRIMARY KEY"),
                      1  "FdGrp_Cd", "CHARACTER(4)", Types.CHAR, "NOT NULL"),
                      2  "Long_Desc", "VARCHAR(200)", Types.VARCHAR, "NOT NULL"),
                      3  "Shrt_Desc", "VARCHAR(60)", Types.VARCHAR, "NOT NULL"),
                      4  "ComName", "VARCHAR(100)", Types.VARCHAR, null),
                      5  "ManufacName", "VARCHAR(65)", Types.VARCHAR, null),
                      6  "Survey", "CHARACTER(1)", Types.CHAR, null),
                      7  "Ref_desc", "VARCHAR(135)", Types.VARCHAR, null),
                      8  "SciName", "VARCHAR(65)", Types.VARCHAR, null),
                      9  "N_Factor", "FLOAT", Types.FLOAT, null),
                     10  "Pro_Factor", "FLOAT", Types.FLOAT, null),
                     11  "Fat_Factor", "FLOAT", Types.FLOAT, null),
                     12  "CHO_Factor", "FLOAT", Types.FLOAT, null),
                */

                count++;
            }

            return count;
        }
    }
}