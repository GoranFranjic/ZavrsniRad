/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edunova.model.Djelatnik;
import edunova.util.EdunovaException;
import java.util.List;


public class ObradaDjelatnik extends ObradaOsoba<Djelatnik>{

    @Override
    public List<Djelatnik> read() {
        return session.createQuery("from Djelatnik",Djelatnik.class).list();
    }
    
   public Djelatnik autoriziraj(String email, String lozinka){
        Djelatnik o;
        
        try {
            o = session.createQuery(
                    "from Djelatnik o where o.email=:email",Djelatnik.class)
                    .setParameter("email", email).getSingleResult();
            
              Argon2 argon2 = Argon2Factory.create();
              
              return argon2.verify(o.getLozinka(), lozinka.toCharArray()) ? o : null;
              
        } catch (Exception e) {
            return null;
        }
        
    }
    

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
       
    }

    /*public Djelatnik autoriziraj(String operedunovahr, String oper) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    
    
}
