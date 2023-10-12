/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author goran
 */
public class HibernateUtil {
    
      private static Session session = null;

    public static SessionFactory getSessionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private HibernateUtil(){
        session = new Configuration().configure().buildSessionFactory().openSession();
    }
    
    public static Session getSession(){
        if(session==null){
            new HibernateUtil();
        }
        return session;
    }
    
    
}
