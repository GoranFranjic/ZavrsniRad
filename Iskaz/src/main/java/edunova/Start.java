/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edunova;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edunova.controller.ObradaDjelatnik;
import edunova.model.Djelatnik;
import edunova.model.Entitet;
import edunova.model.Iskaz;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import edunova.view.Autorizacija;
import edunova.view.Izbornik;
/**
 *
 * @author goran
 */
public class Start {

    public static void main(String[] args) {
        
   new Autorizacija().setVisible(true);
    HibernateUtil.getSession();
    
      //lozinka();
     //new Autorizacija().setVisible(true);
      //new Start();
      /*
       ObradaDjelatnik oo = new ObradaDjelatnik();
       
       Djelatnik o = oo.autoriziraj("oper@proces.hr", "oper");
       
        System.out.println(o==null ? "Neispravno" : o.getIme());
       */
    }

    public Start() {
    //radSJSON();
    ucitajIzJSON();
    }
    
    
    
    private static void lozinka(){
         //factory pattern
        Argon2 argon2 = Argon2Factory.create();
        
        String hash = argon2.hash(10, 65536, 1, "oper".toCharArray());
        
        ObradaDjelatnik oo = new ObradaDjelatnik();
        Djelatnik o = new Djelatnik();
        o.setIme("Pero");
        o.setPrezime("perić");
        o.setEmail("oper@proces.hr");
        o.setUloga("oper");
        o.setOib("81425134722");
        o.setLozinka(hash);
        
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ucitajIzJSON() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    }

