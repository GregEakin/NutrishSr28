package greg.info;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static class LazyHolder {
        static final SessionFactory sessionFactory = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("META-INF/hibernate.cfg.xml"));
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return LazyHolder.sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
