package edunova.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    private HibernateUtil() {
    }
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Kreiranje SessionFactory iz hibernate.cfg.xml
                Configuration konfiguracija = new Configuration().configure();
                sessionFactory = konfiguracija.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Inicijalno stvaranje SessionFactory nije uspjelo." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
    
    public static Session getSession() {
        return getSessionFactory().openSession();
    }
    
    public static void zatvoriSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
