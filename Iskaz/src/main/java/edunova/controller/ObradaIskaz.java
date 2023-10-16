/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Iskaz;
import java.util.Collection;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author goran
 */
public class ObradaIskaz {

    public void spremiIskaz(Iskaz iskaz) throws EdunovaException {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(iskaz);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new EdunovaException("Pogreška pri spremanju iskaza: " + e.getMessage());
        } finally {
            HibernateUtil.zatvoriSession(session);
        }
    }
    
}

